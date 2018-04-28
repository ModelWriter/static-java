import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.TypeSystem;
import kodkod.ast.Relation;

public class TypeSystemKodkodTest {

    public static void main(String[] args) {
        String path = "C:\\Users\\Harun\\Documents\\GitHub\\static-java\\JavaAnalyzer\\src\\main\\java\\";
        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator(path, false);

        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

        // Detection of composite pattern
        KodkodTranslator translator = new KodkodTranslator(typeSystem);
        Relation composite = translator.addRelation("Composite");
        Relation component = translator.addRelation("Component");
        Relation leaf = translator.addRelation("Leaf");
        translator.addFormula(component.in(leaf.join(translator.EXTENDS)));
        translator.addFormula(component.in(composite.join(translator.EXTENDS)));
        translator.addFormula(composite.in(component.join(translator.CONTAINS)));
        translator.addFormula(leaf.in(component.join(translator.CONTAINS)).not());
        translator.solve();

        System.out.println("Composite Patterns:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }
        System.out.println();

        // Detection of degenerate inheritance
        translator = new KodkodTranslator(typeSystem);
        Relation superType = translator.addRelation("Super");
        Relation subType = translator.addRelation("Sub");
        Relation degSubType = translator.addRelation("DegSub");
        translator.addFormula(subType.in(degSubType.join(translator.EXTENDS.union(translator.IMPLEMENTS))));
        translator.addFormula(superType.in(degSubType.join(translator.EXTENDS.union(translator.IMPLEMENTS))));
        translator.addFormula(superType.in(subType.join(translator.EXTENDS.union(translator.IMPLEMENTS).closure())));
        translator.solve();

        System.out.println("Degenerate Inheritances:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }
        System.out.println();

        // Detection of sub class knowledge
        translator = new KodkodTranslator(typeSystem);
        Relation _superType = translator.addRelation("Super");
        Relation _subType = translator.addRelation("Sub");
        translator.addFormula(_superType.in(_subType.join(translator.EXTENDS.union(translator.IMPLEMENTS).closure())));
        translator.addFormula(_superType.in(_subType.join(translator.CONTAINS)));
        translator.solve();

        System.out.println("Degenerate Inheritances:\n");
        while (translator.hasNext()) {
            System.out.println(translator.next());
        }

        // Detection of singleton pattern
        translator = new KodkodTranslator(typeSystem);
        Relation singleton = translator.addRelation("Singleton");
        Relation field = translator.addRelation("StaticField");

        // Public !in Singleton.constructors.access
        translator.addFormula(translator.ACCESS_PUBLIC.in(singleton.join(translator.CONSTRUCTORS).join(translator.ACCESS_SPECIFIER)).not());

        // StaticField in singleton.fields
        translator.addFormula(field.in(singleton.join(translator.FIELDS)));

        // true in StaticField.static
        translator.addFormula(translator.BOOLEAN_TRUE.in(field.join(translator.STATIC)));

        // Singleton in StaticField.returns    ->   (which means type)
        translator.addFormula(singleton.in(field.join(translator.RETURNS)));

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
