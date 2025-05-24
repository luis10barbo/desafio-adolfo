package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.model.NoticiaAreaTematica;

@Repository
public class NoticiaAreaTematicaRepository extends BaseRepository<NoticiaAreaTematica> {
    public NoticiaAreaTematicaRepository(JdbcTemplate template) {
        super(template, "noticia_area_tematica");
    }

    public void inserir(NoticiaAreaTematica model) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("id_noticia", model.getIdNoticia()),
            Map.entry("id_area_tematica", model.getIdAreaTematica())
        ));
        super.inserir(model.getId(), tabelas);
    }

    public List<NoticiaAreaTematica> adquirir() {
        RowMapper<NoticiaAreaTematica> mapper = (ResultSet rs, int rowNum) -> {
            NoticiaAreaTematica m = new NoticiaAreaTematica();
            m.setId(rs.getInt(1));
            m.setIdNoticia(rs.getInt(2));
            m.setIdAreaTematica(rs.getInt(3));
            return m;
        };

        return super.adquirir(mapper);
    }

    public void atualizar(NoticiaAreaTematica model) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("id_noticia", model.getIdNoticia()),
            Map.entry("id_area_tematica", model.getIdAreaTematica())
        ));
        super.atualizar(model.getId(), tabelas);
    }
}