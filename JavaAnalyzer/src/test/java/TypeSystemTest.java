import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.TypeSystem;

import java.io.IOException;

public class TypeSystemTest {

    public static void main(String[] args) throws IOException {

        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator("C:\\Users\\Harun\\Documents\\GitHub\\static-java\\JavaAnalyzer\\src", true);

        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

        typeSystem.getEntities().forEach(System.out::println);
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
