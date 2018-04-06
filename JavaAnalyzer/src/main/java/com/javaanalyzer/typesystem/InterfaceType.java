package com.javaanalyzer.typesystem;

import java.util.HashSet;
import java.util.Set;

public class InterfaceType extends Type {

    private Set<InterfaceType> subTypes;
    private Set<InterfaceType> superTypes;
    private Set<ClassType> implementingTypes;

    public InterfaceType(String fullName, String shortName) {
        super(fullName, shortName);
        this.subTypes = new HashSet<>();
        this.superTypes = new HashSet<>();
        implementingTypes = new HashSet<>();
    }

    public void addSubType(InterfaceType type) {
        subTypes.add(type);
        type.superTypes.add(this);
    }

    public void addSuperType(InterfaceType type) {
        superTypes.add(type);
        type.subTypes.add(this);
    }

    protected void addImplementingType(ClassType type) {
        implementingTypes.add(type);
    }

    public Set<ClassType> getImplementingTypes() {
        return implementingTypes;
    }

    public Set<InterfaceType> getSubTypes() {
        return subTypes;
    }

    public Set<InterfaceType> getSuperTypes() {
        return superTypes;
    }
}
