package ru.alishev.springcourse.People;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int id;
    public Person(){};

    Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return this.name;
    }

}
