package com.example.staffuimobile.models;

public class Project {
    public int Id;
    public String Name, StartDate, EndDate;

    public Project(int id, String name, String startDate, String endDate) {
        Id = id;
        Name = name;
        StartDate = startDate;
        EndDate = endDate;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }
}
