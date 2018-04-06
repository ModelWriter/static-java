import com.javaanalyzer.typecollector.PackageRootFinder;
import com.javaanalyzer.typecollector.JavaParserTypeCollector;
import com.javaanalyzer.typesystem.ClassType;
import com.javaanalyzer.typesystem.InterfaceType;
import com.javaanalyzer.typesystem.Type;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class TypeCollectorTest {

    public static void main(String[] args) throws IOException {
        String mainPath = "/home/irem/IdeaProjects/JavaAnalyzer";
        Set<String> subPaths = PackageRootFinder.getDirectories(mainPath);

        JavaParserTypeCollector javaParserTypeSystemCollector = new JavaParserTypeCollector(mainPath);
        for(String path : subPaths){
            javaParserTypeSystemCollector.addPackagePath(path);
            System.out.println(path);
        }

        Set<Type> types = javaParserTypeSystemCollector.collect();

        types.forEach(type -> {
            System.out.println(type);
            if (type instanceof ClassType) {
                ClassType classType = ((ClassType) type);
                System.out.println("Type: Class");
                System.out.println("Super Types: " + classType.getSuperTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Sub Types: " + classType.getSubTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Implemented Types: " + classType.getImplementedTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Contains: " + classType.getContains().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Calls: " + classType.getCalls().stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
            else if (type instanceof InterfaceType) {
                InterfaceType interfaceType = ((InterfaceType) type);
                System.out.println("Type: Interface");
                System.out.println("Super Types: " + interfaceType.getSuperTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Sub Types: " + interfaceType.getSubTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Implementing Types: " + interfaceType.getImplementingTypes().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Contains: " + interfaceType.getContains().stream().map(Object::toString).collect(Collectors.joining(", ")));
                System.out.println("Calls: " + interfaceType.getCalls().stream().map(Object::toString).collect(Collectors.joining(", ")));
            }
            System.out.println();
        });
    }
}
