package br.com.luisbrb.desafio.spring.repository;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class BaseRepository<T> {
    private JdbcTemplate template;
    private String nomeTabela; 

    public Integer inserir(Object id, LinkedHashMap<String, Object> tables) {
        ArrayList<Object> args = new ArrayList<>();

        // Ignorar tabelas com valores nulos
        Map<String, Object> filteredTables = tables.entrySet().stream()
        .filter(entry -> entry.getValue() != null)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

        args.addAll(filteredTables.values());

        String rowsToUpdate = String.join(
            ", ",
            filteredTables.keySet().stream().toList()
        );

        String rowsValues = String.join(
            ", ",
            filteredTables.keySet().stream().map(o -> "?").toList()
        );

        String sql = "INSERT INTO " + nomeTabela + " (" + rowsToUpdate + ") VALUES (" + rowsValues + ")";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            for (int i = 0; i < args.size(); i++) {
                ps.setObject(i + 1, args.get(i));
            }
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        return key != null ? key.intValue() : null;
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
