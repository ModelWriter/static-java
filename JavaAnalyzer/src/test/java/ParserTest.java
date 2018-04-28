import com.javaanalyzer.recognizer.JavaAnalyzerLexer;
import com.javaanalyzer.recognizer.JavaAnalyzerParser;
import com.javaanalyzer.recognizer.JavaAnalyzerVisitorImpl;
import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.TypeSystem;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ParserTest {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Harun\\Documents\\GitHub\\static-java\\JavaAnalyzer\\src\\main\\java\\";

        String input = "classA\n" +
                "Class classB\n" +
                "classC in classA.*(contains + calls + extends + implements)\n" +
                "classA in classB.(contains + calls + extends + implements)\n";

        new ParserTest().test(path, input);
    }

    public void test(String path, String input) throws IOException {
        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator(path, false);

        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));

        JavaAnalyzerLexer lexer = new JavaAnalyzerLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
        JavaAnalyzerParser parser = new JavaAnalyzerParser(new CommonTokenStream(lexer));

        JavaAnalyzerVisitorImpl visitor = new JavaAnalyzerVisitorImpl(typeSystem);
        visitor.visit(parser.input());

        KodkodTranslator kodkodTranslator = visitor.getKodkodTranslator();

        kodkodTranslator.getFormulas().forEach(System.out::println);

        kodkodTranslator.solve();

        while (kodkodTranslator.hasNext()) {
            System.out.println(kodkodTranslator.next());
            System.out.println();
        }
    }

}
