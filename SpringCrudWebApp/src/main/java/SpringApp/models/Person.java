package SpringApp.models;

import javax.validation.constraints.*;
public class Person {

    @NotEmpty(message = "Enter the name")
    @Size(min=4, max=20, message="Name should be between 4 and 20 characters")
    private String name;

    @Email(message = "Enter the correct email")
    private String email;
    private boolean gender;

    @Min(value = 16, message = "You should be over 16")
    @Max(value = 99, message = "Enter the correct age")
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
