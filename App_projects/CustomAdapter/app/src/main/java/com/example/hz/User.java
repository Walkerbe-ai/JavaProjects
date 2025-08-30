package com.example.hz;

public class User {

    private String name;
    private String password;
    private int photoPath;

    public User(String name, String password, int photoPath) {
        this.name = name;
        this.password = password;
        this.photoPath = photoPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(int photoPath) {
        this.photoPath = photoPath;
    }
}