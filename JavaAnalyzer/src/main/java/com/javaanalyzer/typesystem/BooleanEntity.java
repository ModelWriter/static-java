package com.javaanalyzer.typesystem;

public class BooleanEntity extends Entity {

    public static final BooleanEntity TRUE = new BooleanEntity("BOOLEAN::TRUE", "TRUE");
    public static final BooleanEntity FALSE = new BooleanEntity("BOOLEAN::FALSE", "FALSE");

    private BooleanEntity(String fullName, String shortName) {
        super(fullName, shortName);
    }

}
