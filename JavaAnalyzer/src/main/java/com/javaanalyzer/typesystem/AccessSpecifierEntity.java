package com.javaanalyzer.typesystem;

public class AccessSpecifierEntity extends Entity {

    public static final AccessSpecifierEntity PUBLIC = new AccessSpecifierEntity("ACCESS_SPECIFIER::PUBLIC", "PUBLIC");
    public static final AccessSpecifierEntity PRIVATE = new AccessSpecifierEntity("ACCESS_SPECIFIER::PRIVATE", "PRIVATE");
    public static final AccessSpecifierEntity PROTECTED = new AccessSpecifierEntity("ACCESS_SPECIFIER::PROTECTED", "PROTECTED");
    public static final AccessSpecifierEntity DEFAULT = new AccessSpecifierEntity("ACCESS_SPECIFIER::DEFAULT", "DEFAULT");

    private AccessSpecifierEntity(String fullName, String shortName) {
        super(fullName, shortName);
    }

}
