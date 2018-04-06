package com.javaanalyzer.typesystem;

import java.util.HashSet;
import java.util.Set;

public class ClassType extends Type {

    private boolean isAbstract;

    private Set<ClassType> subTypes;
    private Set<ClassType> superTypes;
    private Set<InterfaceType> implementedTypes;

    public ClassType(String fullName, String shortName, boolean isAbstract) {
        super(fullName, shortName);
        this.isAbstract = isAbstract;
        this.subTypes = new HashSet<>();
        this.superTypes = new HashSet<>();
        this.implementedTypes = new HashSet<>();
    }

    public ClassType(String fullName, String shortName) {
        this(fullName, shortName, false);
    }

    public void addSubType(ClassType type) {
        subTypes.add(type);
        type.addSuperType(this);
    }

    protected void addSuperType(ClassType type) {
        superTypes.add(type);
    }

    public void addImplementedType(InterfaceType type) {
        implementedTypes.add(type);
        type.addImplementingType(this);
    }

    public Set<ClassType> getSubTypes() {
        return subTypes;
    }

    public Set<ClassType> getSuperTypes() {
        return superTypes;
    }

    public Set<InterfaceType> getImplementedTypes() {
        return implementedTypes;
    }
}
