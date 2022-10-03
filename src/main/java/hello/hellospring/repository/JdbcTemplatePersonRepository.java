package hello.hellospring.repository;

import hello.hellospring.domain.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplatePersonRepository implements PersonRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePersonRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Person save(Person person) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("person").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", person.getName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        person.setId(key.longValue());
        return person;
    }

    @Override
    public Optional<Person> findByPerson(Long id) {
        String sql = "select * from person where id = ?";
        List<Person> result = jdbcTemplate.query(sql, personRowMapper(), id );
        return result.stream().findAny();
    }

    @Override
    public Optional<Person> findByName(String name) {
        String sql = "select * from person where name = ?";
        List<Person> result = jdbcTemplate.query(sql, personRowMapper(), name );
        return result.stream().findAny();
    }

    @Override
    public Optional<Person> findByAge(Integer age) {
        String sql = "select * from person where age = ?";
        List<Person> result = jdbcTemplate.query(sql, personRowMapper(), age );
        return result.stream().findAny();
    }

    @Override
    public List<Person> findAll() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, personRowMapper());
    }

    private  RowMapper<Person> personRowMapper() {
        return ((rs, rowNum) -> {
            Person person = new Person();
            person.setId(rs.getLong("id"));
            person.setName(rs.getString("name"));
            person.setAge(rs.getInt("age"));
            return person;
        });
    }
}
