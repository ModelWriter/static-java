import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.TypeSystem;
import kodkod.ast.Relation;

import java.io.IOException;

public class TypeSystemKodkodTest {

    public static void main(String[] args) throws IOException {
        String path = "/home/harun/git/JavaAnalyzer/src";
        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator(path);

        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

        // Detection of composite pattern
        KodkodTranslator translator = new KodkodTranslator(typeSystem);
        translator.add("Composite");
        translator.add("Component");
        translator.add("Leaf");
        translator.setExtends("Leaf", "Component", true);
        translator.setExtends("Composite", "Component", true);
        translator.setContains("Composite", "Component", true);
        translator.setContains("Leaf", "Component", false);
        translator.solve();

        System.out.println("Composite Patterns:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }
        System.out.println();

        // Detection of degenerate inheritance
        translator = new KodkodTranslator(typeSystem);
        Relation superType = translator.add("Super");
        Relation subType = translator.add("Sub");
        Relation degSubType = translator.add("DegSub");
        translator.addFormula(subType.in(degSubType.join(translator.INHERITS)));
        translator.addFormula(superType.in(degSubType.join(translator.INHERITS)));
        translator.addFormula(superType.in(subType.join(translator.INHERITS.closure())));
        translator.solve();

        System.out.println("Degenerate Inheritances:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }
        System.out.println();

        // Detection of sub class knowledge
        translator = new KodkodTranslator(typeSystem);
        Relation _superType = translator.add("Super");
        Relation _subType = translator.add("Sub");
        translator.addFormula(_superType.in(_subType.join(translator.INHERITS.closure())));
        translator.addFormula(_superType.in(_subType.join(translator.CONTAINS)));
        translator.solve();

        System.out.println("Degenerate Inheritances:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }
    }

    public interface FSObject {
        Directory dir = null;
    }

    public interface File extends FSObject {

    }

    public interface Directory extends File, FSObject {
        FSObject fsObject = null;
    }

}
