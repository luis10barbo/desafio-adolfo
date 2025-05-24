package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.model.OrgaoInstitucional;

@Repository
public class OrgaoInstitucionalRepository extends BaseRepository<OrgaoInstitucional> {
    public OrgaoInstitucionalRepository(JdbcTemplate template) {
        super(template, "orgao_institucional");
    }

    public void inserir(OrgaoInstitucional orgaoInstitucional) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", orgaoInstitucional.getTitulo())
        ));
        super.inserir(orgaoInstitucional.getId(), tabelas);
    }

    public List<OrgaoInstitucional> adquirir() {        
        RowMapper<OrgaoInstitucional> mapper = new RowMapper<OrgaoInstitucional>() {
            @Override
            public OrgaoInstitucional mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrgaoInstitucional o = new OrgaoInstitucional();
                o.setId(rs.getInt(1));
                o.setTitulo(rs.getString(2));
                return o;
            }
        };

        return super.adquirir(mapper); 
    }

    public void atualizar(OrgaoInstitucional orgaoInstitucionalModel) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", orgaoInstitucionalModel.getTitulo())
        ));
        super.atualizar(orgaoInstitucionalModel.getId(), tabelas);
    }
}
