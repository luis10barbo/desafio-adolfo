package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.luisbrb.desafio.model.OrgaoInstitucionalModel;

@Repository
public class OrgaoInstitucionalRepository extends BaseRepository {
    private JdbcTemplate template;
    private final String NOME_TABELA = "orgao_institucional"; 

    public OrgaoInstitucionalRepository(JdbcTemplate template) {
        this.template = template;
        
    }

    public void inserir(OrgaoInstitucionalModel orgaoInstitucional) {
        String sql = "INSERT INTO " + NOME_TABELA + "(titulo) VALUES (?)";
        int rows = template.update(sql, orgaoInstitucional.getTitulo());
        System.out.println(rows);
    }

    public List<OrgaoInstitucionalModel> adquirir() {
        String sql = "SELECT * FROM " + NOME_TABELA;
        
        RowMapper<OrgaoInstitucionalModel> mapper = new RowMapper<OrgaoInstitucionalModel>() {
            @Override
            public OrgaoInstitucionalModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                OrgaoInstitucionalModel o = new OrgaoInstitucionalModel();
                o.setId(rs.getInt(1));
                o.setTitulo(rs.getString(2));
                return o;
            }
        };

        List<OrgaoInstitucionalModel> orgaosInstitucionais = template.query(sql, mapper);
        return orgaosInstitucionais;        
    }
}
