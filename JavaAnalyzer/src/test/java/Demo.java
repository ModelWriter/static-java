import com.javaanalyzer.recognizer.JavaAnalyzerLexer;
import com.javaanalyzer.recognizer.JavaAnalyzerParser;
import com.javaanalyzer.recognizer.JavaAnalyzerVisitorImpl;
import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typesystem.Entity;
import com.javaanalyzer.typesystem.Field;
import com.javaanalyzer.typesystem.TypeSystem;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {

        String exampleInput = "Class classA\n" +
                "Class classB\n" +
                "!(classA = classB)\n" +
                "classB in classA.*(contains + calls + extends + implements)\n" +
                "classA in classB.(contains + calls + extends + implements)\n";

        JFrame frame = new JFrame("Static Java Analyzing Tool");

        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 2));

        TextArea textArea = new TextArea();

        JScrollPane jScrollPane = new JScrollPane(textArea);

        JPanel subPanel = new JPanel();
        subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));

        TextField textField = new TextField();
        Button button = new Button("Find Pattern");
        TextArea results = new TextArea();
        JScrollPane resultScroll = new JScrollPane(results);

        subPanel.add(textField);
        subPanel.add(button);
        subPanel.add(resultScroll);

        jPanel.add(jScrollPane);
        jPanel.add(subPanel);

        frame.getContentPane().add(jPanel);

        results.setEditable(false);

        textArea.setText(exampleInput);
        textField.setText("C:\\Users\\Harun\\Documents\\GitHub\\static-java\\JavaAnalyzer\\src\\main\\java");

        frame.pack();
        frame.setVisible(true);

        /*if (System.getenv().get("PROCESSOR_ARCHITECTURE").equals("x86"))*/
            new Demo().process(textField, textArea, results, button);
        /*else {
            button.setEnabled(false);
            textArea.setEditable(false);
            textField.setEditable(false);
            results.setText("Please run the application using 32-bit Java SDK.");
        }*/
    }

    private boolean started = false;
    private boolean stop = false;

    public void process(TextField path, TextArea input, TextArea output, Button button) {
        button.addActionListener(e -> {

            if (started) {
                button.setLabel("Stopping...");
                button.setEnabled(false);
                started = false;
                stop = true;
            }
            else {
                Thread thread = new Thread(() -> {
                    try {
                        started = true;
                        stop = false;

                        output.setText("");

                        button.setLabel("Getting the root files... Click to stop.");

                        JavaParserTypeSystemCreator javaParserTypeSystemCollector = new JavaParserTypeSystemCreator(path.getText(), true);

                        if (stop) {
                            return;
                        }

                        button.setLabel("Parsing java files... Click to stop.");

                        TypeSystem typeSystem = javaParserTypeSystemCollector.createTypeSystem();

                        InputStream stream = new ByteArrayInputStream(input.getText().getBytes(StandardCharsets.UTF_8));

                        JavaAnalyzerLexer lexer = null;
                        try {
                            lexer = new JavaAnalyzerLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        assert lexer != null;
                        JavaAnalyzerParser parser = new JavaAnalyzerParser(new CommonTokenStream(lexer));

                        JavaAnalyzerVisitorImpl visitor = new JavaAnalyzerVisitorImpl(typeSystem);
                        visitor.visit(parser.input());

                        KodkodTranslator kodkodTranslator = visitor.getKodkodTranslator();

                        kodkodTranslator.getFormulas().forEach(System.out::println);

                        StringBuilder sb = new StringBuilder();

                        sb.append("Formula:").append(System.lineSeparator()).append(System.lineSeparator())
                                .append(kodkodTranslator.getFormulas().stream().map(Object::toString).
                                        collect(Collectors.joining(System.lineSeparator())))
                                .append(System.lineSeparator()).append(System.lineSeparator());

                        if (stop){
                            return;
                        }

                        button.setLabel("Solving... Click to stop.");

                        try {
                            kodkodTranslator.solve();
                        } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                            unsatisfiedLinkError.printStackTrace();
                            sb.append(unsatisfiedLinkError.getMessage());
                        }

                        while (kodkodTranslator.hasNext() && !stop) {
                            Map<String, Entity> map = kodkodTranslator.next();
                            System.out.println(map);
                            sb.append(map.toString());
                            sb.append(System.lineSeparator());
                            output.setText(sb.toString());
                        }

                    } catch (Exception e12) {
                        output.setText(e12.getMessage());
                    } finally {
                        if (stop)
                            button.setLabel("Stopped, Find Pattern");
                        else
                            button.setLabel("Finished, Find Pattern");

                        stop = false;
                        started = false;

                        button.setEnabled(true);
                    }
                });

                thread.start();
            }
        });
    }

}
