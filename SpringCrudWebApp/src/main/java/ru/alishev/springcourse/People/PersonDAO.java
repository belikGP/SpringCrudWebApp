package ru.alishev.springcourse.People;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int ID;
    {
        people = new ArrayList<>();
        people.add(new Person(++ID,"Gosha"));
        people.add(new Person(++ID,"Dima"));
        people.add(new Person(++ID,"Kirill"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++ID);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personForUpdate = show(id);
        personForUpdate.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }

}
