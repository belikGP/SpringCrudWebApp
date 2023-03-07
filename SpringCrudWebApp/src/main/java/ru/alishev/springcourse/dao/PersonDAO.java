package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM people", new PersonMapper());
    }

    public Person show(int id){
        return jdbcTemplate.query("SELECT * FROM people WHERE id = ?", new Object[]{id}, new PersonMapper())
                .stream().findAny().orElse(null);
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO people (name, email, age, gender) VALUES (?,?,?,?)", person.getName(),
                person.getEmail(), person.getAge(), person.getGender());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE people SET name=?, email=?, age=?, gender=? WHERE id=?",
                updatedPerson.getName(), updatedPerson.getEmail(),
                updatedPerson.getAge(), updatedPerson.getGender(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM people WHERE id=?", id);
    }

}
