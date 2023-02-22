package ru.alishev.springcourse.People;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private final List<Person> people;
    private static int ID;
    {
        people = new ArrayList<>();
        people.add(new Person(ID++,"Gosha"));
        people.add(new Person(ID++,"Dima"));
        people.add(new Person(ID++,"Kirill"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.get(id);
    }

    public void save(Person person){
        person.setId(ID++);
        people.add(person);
    }
}
