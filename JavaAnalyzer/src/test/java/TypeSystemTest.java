import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.TypeSystem;

import java.io.IOException;

public class TypeSystemTest {

    public static void main(String[] args) throws IOException {

        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator("/home/irem/IdeaProjects/JavaAnalyzer", true);
        javaParserTypeSystemCollector.addPackagePath("/home/irem/IdeaProjects/JavaAnalyzer/src/main/java");
        javaParserTypeSystemCollector.addPackagePath("/home/irem/IdeaProjects/JavaAnalyzer/src/test/java");

        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

        typeSystem.getTypes().forEach(System.out::println);
        System.out.println();
        System.out.println(typeSystem.getExtends());
        System.out.println();
        System.out.println(typeSystem.getImplements());
        System.out.println();
        System.out.println(typeSystem.getCalls());
        System.out.println();
        System.out.println(typeSystem.getContains());
        System.out.println();
    }

    private class A {

    }

    private class B extends A {

    }

    private class C extends B {

    }

}
