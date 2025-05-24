package br.com.luisbrb.desafio.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import br.com.luisbrb.desafio.model.OrgaoInstitucionalModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BaseRepository<T> {
    private JdbcTemplate template;
    private String nomeTabela; 

    public void inserir(Object id, LinkedHashMap<String, Object> tables) {
        ArrayList<Object> args = new ArrayList<>();
        args.addAll(tables.values());

        String rowsToUpdate = String.join(
            ", ",
            tables.keySet().stream().toList()
        );

        String rowsValues = String.join(
            ", ",
            tables.keySet().stream().map(o -> "?").toList()
        );

        String sql = "INSERT INTO " + nomeTabela + " (" + rowsToUpdate + ") VALUES (" + rowsValues + ")";

        int rows = template.update(sql, args.toArray(new Object[0]));
        System.out.println(rows);
    }

    public List<T> adquirir(RowMapper<T> mapper) {
        String sql = "SELECT * FROM " + nomeTabela;

        List<T> orgaosInstitucionais = template.query(sql, mapper);
        return orgaosInstitucionais;        
    }


    public boolean remover(Object id) {
        final String DELETE_SQL = "DELETE FROM " + nomeTabela + " WHERE id=?";
        return template.update(DELETE_SQL, id) > 0;
    }

    public void atualizar(Object id, LinkedHashMap<String, Object> tables) {
        ArrayList<Object> args = new ArrayList<>();
        args.addAll(tables.values());
        args.add(id);

        String rowsToUpdate = String.join(
            ", ",
            tables.keySet().stream().map(col -> col + "=?").toList()
        );

        String sql = "UPDATE " + nomeTabela + " SET " + rowsToUpdate + " WHERE id=?";
        template.update(sql, args.toArray(new Object[0]));
    }
}
