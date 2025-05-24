package br.com.luisbrb.desafio.spring.repository;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.spring.model.AreaTematica;

@Repository
public class AreaTematicaRepository extends BaseRepository<AreaTematica> {
    public AreaTematicaRepository(JdbcTemplate template) {
        super(template, "area_tematica");
    }

    public void inserir(AreaTematica area) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", area.getTitulo())
        ));
        super.inserir(area.getId(), tabelas);
    }

    public List<AreaTematica> adquirir() {
        RowMapper<AreaTematica> mapper = (ResultSet rs, int rowNum) -> {
            AreaTematica a = new AreaTematica();
            a.setId(rs.getInt(1));
            a.setTitulo(rs.getString(2));
            return a;
        };

        return super.adquirir(mapper);
    }

    public void atualizar(AreaTematica area) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", area.getTitulo())
        ));
        super.atualizar(area.getId(), tabelas);
    }
}