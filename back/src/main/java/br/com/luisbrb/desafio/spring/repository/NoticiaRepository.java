package br.com.luisbrb.desafio.spring.repository;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
        return super.inserir(noticia.getId(), tabelas);
    }

    public List<Noticia> adquirir() {
        RowMapper<Noticia> mapper = (ResultSet rs, int rowNum) -> {
            Noticia n = new Noticia();
            n.setId(rs.getInt(1));
            n.setTitulo(rs.getString(2));
            n.setAtualizadoEm(rs.getTimestamp(3));
            n.setMinutosLeitura(rs.getInt(4));
            return n;
        };

        return super.adquirir(mapper);
    }



    public void atualizar(Noticia noticia) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", noticia.getTitulo()),
            Map.entry("atualizado_em", noticia.getAtualizadoEm()),
            Map.entry("minutos_leitura", noticia.getMinutosLeitura())
        ));
        super.atualizar(noticia.getId(), tabelas);
    }

    public List<Noticia> adquirir(int[] areaTematicas, int[] orgaosInstitucionais) {
        String whereString = "";
        String areasTematicasWhere = " nat.id_area_tematica IN (" + Arrays.stream(areaTematicas).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ")";
        String orgaosInstitucionaisWhere = " noi.id_orgao_institucional IN (" + Arrays.stream(orgaosInstitucionais).mapToObj(String::valueOf).collect(Collectors.joining(",")) + ")";

        RowMapper<Noticia> mapper = (ResultSet rs, int rowNum) -> {
            Noticia n = new Noticia();
            n.setId(rs.getInt(1));
            n.setTitulo(rs.getString(2));
            n.setAtualizadoEm(rs.getTimestamp(3));
            n.setMinutosLeitura(rs.getInt(4));
            return n;
        };

        if (areaTematicas.length > 0 || orgaosInstitucionais.length > 0) {
            whereString += "WHERE ";
            if (areaTematicas.length > 0) {
                whereString += areasTematicasWhere;
                if (orgaosInstitucionais.length > 0) {
                    whereString += " OR ";
                }
            }
    
            if (orgaosInstitucionais.length > 0) {
                whereString += orgaosInstitucionaisWhere;
            }
        }


        String sql = "SELECT DISTINCT ON (n.id) n.* FROM " + getNomeTabela() + " n LEFT JOIN noticia_orgao_institucional noi ON n.id = noi.id_noticia LEFT JOIN noticia_area_tematica nat ON n.id = nat.id_noticia " + whereString + " ORDER BY n.id;";

        List<Noticia> noticias = getTemplate().query(sql, mapper);

        return noticias;        
    }
}