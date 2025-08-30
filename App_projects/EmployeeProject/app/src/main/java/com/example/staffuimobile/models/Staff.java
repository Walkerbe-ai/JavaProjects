package com.example.staffuimobile.models;

import java.util.List;

public class Staff {
    private int Id;
    private String FirstName, LastName, MiddleName;
    private List<Integer> ProjectName;

    public Staff(int id, String firstName, String lastName, String middleName) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
        MiddleName = middleName;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public List<Integer> getProjectName() {
        return ProjectName;
    }
}
