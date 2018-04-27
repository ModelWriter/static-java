package com.javaanalyzer.typesystem;

public abstract class Entity {

    private String shortName;
    private String fullName;
    private String location = "";

    public Entity(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return shortName;
    }

}
