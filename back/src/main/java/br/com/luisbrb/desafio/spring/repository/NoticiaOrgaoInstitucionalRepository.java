package br.com.luisbrb.desafio.spring.repository;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.spring.model.NoticiaOrgaoInstitucional;

@Repository
public class NoticiaOrgaoInstitucionalRepository extends BaseRepository<NoticiaOrgaoInstitucional> {
    public NoticiaOrgaoInstitucionalRepository(JdbcTemplate template) {
        super(template, "noticia_orgao_institucional");
    }

    public void inserir(NoticiaOrgaoInstitucional model) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("id_noticia", model.getIdNoticia()),
            Map.entry("id_orgao_institucional", model.getIdOrgaoInstitucional())
        ));
        super.inserir(model.getId(), tabelas);
    }

    public List<NoticiaOrgaoInstitucional> adquirir() {
        RowMapper<NoticiaOrgaoInstitucional> mapper = (ResultSet rs, int rowNum) -> {
            NoticiaOrgaoInstitucional m = new NoticiaOrgaoInstitucional();
            m.setId(rs.getInt(1));
            m.setIdNoticia(rs.getInt(2));
            m.setIdOrgaoInstitucional(rs.getInt(3));
            return m;
        };

        return super.adquirir(mapper);
    }

    public void atualizar(NoticiaOrgaoInstitucional model) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("id_noticia", model.getIdNoticia()),
            Map.entry("id_orgao_institucional", model.getIdOrgaoInstitucional())
        ));
        super.atualizar(model.getId(), tabelas);
    }
}