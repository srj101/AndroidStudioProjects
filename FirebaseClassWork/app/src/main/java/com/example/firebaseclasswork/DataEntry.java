package com.example.firebaseclasswork;

public class DataEntry {
    private String name;
    private String email;

    public DataEntry(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
