package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.model.OrgaoInstitucionalModel;

@Repository
public class OrgaoInstitucionalRepository extends BaseRepository<OrgaoInstitucionalModel> {
    public OrgaoInstitucionalRepository(JdbcTemplate template) {
        super(template, "orgao_institucional");
    }

    public void inserir(OrgaoInstitucionalModel orgaoInstitucional) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", orgaoInstitucional.getTitulo())
        ));
        super.inserir(orgaoInstitucional.getId(), tabelas);
    }

    public List<OrgaoInstitucionalModel> adquirir() {        
        RowMapper<OrgaoInstitucionalModel> mapper = new RowMapper<OrgaoInstitucionalModel>() {
            @Override
            public OrgaoInstitucionalModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrgaoInstitucionalModel o = new OrgaoInstitucionalModel();
                o.setId(rs.getInt(1));
                o.setTitulo(rs.getString(2));
                return o;
            }
        };

        return super.adquirir(mapper); 
    }

    public void atualizar(OrgaoInstitucionalModel orgaoInstitucionalModel) {
        LinkedHashMap<String, Object> tabelas = new LinkedHashMap<>(Map.ofEntries(
            Map.entry("titulo", orgaoInstitucionalModel.getTitulo())
        ));
        super.atualizar(orgaoInstitucionalModel.getId(), tabelas);
    }
}
