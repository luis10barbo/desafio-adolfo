package br.com.luisbrb.desafio.spring.repository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.spring.model.ResultadoPaginado;
import br.com.luisbrb.desafio.spring.model.interfaces.QueriesViaObjeto;
import br.com.luisbrb.desafio.spring.model.tabelas.Noticia;

@Repository
public class NoticiaRepository extends BaseRepository<Noticia> implements QueriesViaObjeto<Noticia> {
    public NoticiaRepository(JdbcTemplate template) {
        super(template, "noticia");
    }

    public Integer inserir(Noticia noticia) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>();
        tabelas.put("titulo", noticia.getTitulo());
        tabelas.put("atualizado_em", noticia.getAtualizadoEm());
        tabelas.put("minutos_leitura", noticia.getMinutosLeitura());
        tabelas.put("autor", noticia.getAutor());
        tabelas.put("img", noticia.getImg());
        return super.inserir(noticia.getId(), tabelas);
    }

    public List<Noticia> adquirir() {
        RowMapper<Noticia> mapper = (ResultSet rs, int rowNum) -> {
            Noticia n = new Noticia();
            n.setId(rs.getInt(1));
            n.setTitulo(rs.getString(2));
            n.setAtualizadoEm(rs.getTimestamp(3));
            n.setMinutosLeitura(rs.getInt(4));
            n.setAutor(rs.getString(5));
            n.setImg(rs.getBytes(6));
            return n;
        };

        return super.adquirir(mapper);
    }

    public byte[] adquirirImagemNoticia(int id) {
         RowMapper<Noticia> mapper = (ResultSet rs, int rowNum) -> {
            Noticia n = new Noticia();
            n.setImg(rs.getBytes(1));
            return n;
        };

        List<Noticia> res = super.adquirir(mapper, new Object[] { id },"img", "id=?");
        Noticia noticia = res.get(0);
        if (noticia == null) {
            return null;
        }
        return noticia.getImg();
    }


    public void atualizar(Noticia noticia) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", noticia.getTitulo()),
            Map.entry("atualizado_em", noticia.getAtualizadoEm()),
            Map.entry("minutos_leitura", noticia.getMinutosLeitura())
        ));
        super.atualizar(noticia.getId(), tabelas);
    }

    public ResultadoPaginado<List<Noticia>> adquirir(int[] areaTematicas, int[] orgaosInstitucionais, Integer offset) {
        String whereString = "";
        List<Object> arguments = new LinkedList<>();
        String areasTematicasWhere = " nat.id_area_tematica IN (" + IntStream.range(0, areaTematicas.length).mapToObj(a -> "?").collect(Collectors.joining(",")) + ")";
        String orgaosInstitucionaisWhere = " noi.id_orgao_institucional IN (" +  IntStream.range(0, orgaosInstitucionais.length).mapToObj(a -> "?").collect(Collectors.joining(",")) + ")";

        RowMapper<Noticia> mapper = (ResultSet rs, int rowNum) -> {
            Noticia n = new Noticia();
            n.setId(rs.getInt(1));
            n.setTitulo(rs.getString(2));
            n.setAtualizadoEm(rs.getTimestamp(3));
            n.setMinutosLeitura(rs.getInt(4));
            n.setAutor(rs.getString(5));
            // n.setImg(rs.getBytes(6));
            return n;
        };

        if (areaTematicas.length > 0 || orgaosInstitucionais.length > 0) {
            whereString += "WHERE ";
            if (areaTematicas.length > 0) {
                whereString += areasTematicasWhere;
                if (orgaosInstitucionais.length > 0) {
                    whereString += " OR ";
                }
                Arrays.stream(areaTematicas).forEach(arguments::add);
            }
    
            if (orgaosInstitucionais.length > 0) {
                whereString += orgaosInstitucionaisWhere;
                Arrays.stream(orgaosInstitucionais).forEach(arguments::add);
            }
        }
        arguments.add(offset != null ? offset : 0);


        String sql = "SELECT n.* FROM " + getNomeTabela() + " n " + 
        "LEFT JOIN noticia_orgao_institucional noi ON n.id = noi.id_noticia " + 
        "LEFT JOIN noticia_area_tematica nat ON n.id = nat.id_noticia " + 
        whereString + 
        " ORDER BY n.atualizado_em DESC " +
        "LIMIT 9 OFFSET ?;";

        
        List<Noticia> noticias = getTemplate().query(sql, mapper, arguments.toArray(new Object[0]));
        
        LinkedHashMap<Integer, Noticia> noticiaFiltrada = new LinkedHashMap<>(); 
        for (int i = 0; i < noticias.size(); i++) {
            Noticia noticia = noticias.get(i);
            noticiaFiltrada.put(noticia.getId(), noticia);
        }

        return new ResultadoPaginado<List<Noticia>>(new LinkedList<>(noticiaFiltrada.values()), noticias.size() > 8 ? true : false, offset + 8);        
    }
}