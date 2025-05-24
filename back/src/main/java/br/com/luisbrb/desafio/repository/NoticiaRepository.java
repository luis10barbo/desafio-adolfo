package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.model.Noticia;

@Repository
public class NoticiaRepository extends BaseRepository<Noticia> {
    public NoticiaRepository(JdbcTemplate template) {
        super(template, "noticia");
    }

    public void inserir(Noticia noticia) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", noticia.getTitulo()),
            Map.entry("atualizado_em", noticia.getAtualizadoEm()),
            Map.entry("minutos_leitura", noticia.getMinutosLeitura())
        ));
        super.inserir(noticia.getId(), tabelas);
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
}