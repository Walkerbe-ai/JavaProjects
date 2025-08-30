package com.example.jsonrecyclerview;

public class MyViewClass {

    private int id;
    private String name, login, password;
    private int age;
    private String group;

    public MyViewClass(int id, String name, String login, String password, int age, String group) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }
}
