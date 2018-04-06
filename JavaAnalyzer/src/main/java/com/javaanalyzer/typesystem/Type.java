package com.javaanalyzer.typesystem;

import java.util.HashSet;
import java.util.Set;

public abstract class Type {

    private String shortName;
    private String fullName;
    private String location = "";

    private Set<Type> contains;
    private Set<Type> calls;

    public Type(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;

        this.calls = new HashSet<>();
        this.contains = new HashSet<>();
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

    public Set<Type> getCalls() {
        return calls;
    }

    public Set<Type> getContains() {
        return contains;
    }

    public void addCalls(Type type) {
        this.calls.add(type);
    }

    public void addContains(Type type) {
        this.contains.add(type);
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj == this
                || (obj instanceof Type
                        && ((Type) obj).getFullName().equals(fullName));
    }

    @Override
    public String toString() {
        return shortName;
    }
}
