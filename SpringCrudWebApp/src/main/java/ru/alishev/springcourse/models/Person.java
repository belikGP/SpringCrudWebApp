package ru.alishev.springcourse.models;
public class Person {

    private String name;
    private String email;
    private boolean gender;
    private int age;
    private int id;
    public Person(){};

    public Person(int id, String name, String email, boolean gender, int age){
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
