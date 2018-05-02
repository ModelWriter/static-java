package com.javaanalyzer.gui;

import com.javaanalyzer.patterns.Patterns;
import com.javaanalyzer.recognizer.JavaAnalyzerLexer;
import com.javaanalyzer.recognizer.JavaAnalyzerParser;
import com.javaanalyzer.recognizer.JavaAnalyzerVisitorImpl;
import com.javaanalyzer.solver.KodkodTranslator;
import com.javaanalyzer.typesystem.Entity;
import com.javaanalyzer.typesystem.TypeSystem;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class PatternFinderGUI extends javax.swing.JFrame {

    private javax.swing.JButton findPatternButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable resultTable;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JList<String> patternList;
    private javax.swing.JTextArea patternTextField;

    private JFrame senderFrame;
    private String path;
    private TypeSystem typeSystem;

    private DefaultTableModel tableModel;

    private boolean stopThread = true;

    public PatternFinderGUI(JFrame senderFrame, String path, TypeSystem typeSystem) {
        super("Pattern Finder");

        this.senderFrame = senderFrame;
        this.path = path;
        this.typeSystem = typeSystem;

        this.tableModel = new DefaultTableModel(new Object [][] {}, new String [] {}) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };

        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        pathLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pathTextField = new javax.swing.JTextField();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patternList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        patternTextField = new javax.swing.JTextArea();
        findPatternButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jProgressBar1 = new javax.swing.JProgressBar();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                stopThread = true;
               senderFrame.setVisible(true);
            }
        });

        pathLabel.setText("Project Location:");

        pathTextField.setEditable(false);
        pathTextField.setText(path);

        jSplitPane1.setDividerLocation(310);

        findPatternButton.setText("Find Pattern");
        findPatternButton.addActionListener(this::findPatternButtonActionPerformed);

        jLabel1.setText("Choose One Or Write To Search Through Project:");

        Vector<String> patternVector = new Vector<>(Patterns.PATTERN_MAP.keySet());

        patternList.setListData(patternVector);
        patternList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(patternList);

        patternList.addListSelectionListener(e -> {
            String selected = patternList.getSelectedValue();
            if (selected != null) {
                patternTextField.setText(Patterns.PATTERN_MAP.getOrDefault(selected, patternTextField.getText()));
            }
        });

        patternTextField.setColumns(20);
        patternTextField.setRows(5);
        jScrollPane2.setViewportView(patternTextField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(findPatternButton)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(findPatternButton)
                                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    Entity entity = (Entity) tableModel.getValueAt(resultTable.getSelectedRow(), resultTable.getSelectedColumn());

                    System.out.println(entity.getLocation());

                    File file = new File (entity.getLocation());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(PatternFinderGUI.this, e1.getMessage());
                    }
                }
            }
        });
        resultTable.setAutoCreateRowSorter(true);
        resultTable.setModel(tableModel);
        jScrollPane3.setViewportView(resultTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel2);

        menuFile.setText("File");
        menuBar.add(menuFile);

        menuHelp.setText("Help");
        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSplitPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(pathLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pathTextField))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathLabel)
                                        .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSplitPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void findPatternButtonActionPerformed(java.awt.event.ActionEvent evt) {

        if (!stopThread) {
            stopThread = true;
            return;
        }

        stopThread = false;

        Thread thread = new Thread(() ->{

            try {
                tableModel = new DefaultTableModel(new Object [][] {}, new String [] {}) {
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                };

                findPatternButton.setText("Stop");

                InputStream stream = new ByteArrayInputStream(patternTextField.getText().getBytes(StandardCharsets.UTF_8));

                JavaAnalyzerLexer lexer = null;
                try {
                    lexer = new JavaAnalyzerLexer(CharStreams.fromStream(stream, StandardCharsets.UTF_8));
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(PatternFinderGUI.this, e.getMessage());
                }

                assert lexer != null;
                JavaAnalyzerParser parser = new JavaAnalyzerParser(new CommonTokenStream(lexer));

                JavaAnalyzerVisitorImpl visitor = new JavaAnalyzerVisitorImpl(typeSystem);
                visitor.visit(parser.input());

                KodkodTranslator kodkodTranslator = visitor.getKodkodTranslator();

                try {
                    kodkodTranslator.solve();
                } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                    unsatisfiedLinkError.printStackTrace();
                    JOptionPane.showMessageDialog(PatternFinderGUI.this, unsatisfiedLinkError.getMessage());
                }

                List<String> columnNames = new ArrayList<>(kodkodTranslator.getVariableNames());
                Collections.sort(columnNames);

                columnNames.forEach(tableModel::addColumn);
                resultTable.setModel(tableModel);

                double count = 0;

                while (kodkodTranslator.hasNext() && !stopThread) {
                    Map<String, Entity> map = kodkodTranslator.next();

                    tableModel.addRow(new Vector<>(map.entrySet().stream()
                            .sorted(Map.Entry.comparingByKey())
                            .map(Map.Entry::getValue)
                            .collect(Collectors.toList())));

                    resultTable.setModel(tableModel);

                    count += 0.05d;

                    jProgressBar1.setValue((int)(100 * (1 - Math.pow(Math.E, -count))));
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(PatternFinderGUI.this, e.getMessage());
            }
            finally {
                jProgressBar1.setValue(0);
                stopThread = true;
                findPatternButton.setText("Find Pattern");
            }

        });

        thread.start();
    }

}