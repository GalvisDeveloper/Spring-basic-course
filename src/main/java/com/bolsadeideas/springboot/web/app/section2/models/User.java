package com.bolsadeideas.springboot.web.app.section2.models;

public class User {

    private String name;
    private String second_name;
    private String email;

    public User() {
    }

    public User(String name, String second_name, String email) {
        this.name = name;
        this.second_name = second_name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "nombre= " + name + '\n' +
                "apellido= " + second_name + '\n' +
                "email= " + email + '\n';
    }
}
