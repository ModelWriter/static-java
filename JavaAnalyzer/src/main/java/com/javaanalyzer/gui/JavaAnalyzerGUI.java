package com.javaanalyzer.gui;

import com.javaanalyzer.patterns.Patterns;
import com.javaanalyzer.typecollector.JavaParserTypeSystemCreator;
import com.javaanalyzer.typecollector.PackageRootFinder;
import com.javaanalyzer.typesystem.TypeSystem;

import javax.swing.*;
import java.io.File;
import java.util.Vector;

public class JavaAnalyzerGUI extends javax.swing.JFrame {

    private javax.swing.JButton addRootButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JTextField pathTextField;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton removeRootButton;
    private javax.swing.JList<String> rootList;
    private javax.swing.JButton selectFolderButton;

    private Vector<String> rootVector;


    public JavaAnalyzerGUI() {
        super("Static Java Analyzer");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        selectFolderButton = new javax.swing.JButton();
        pathTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        rootList = new javax.swing.JList<>();
        addRootButton = new javax.swing.JButton();
        removeRootButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuHelp = new javax.swing.JMenu();

        rootVector = new Vector<>();

        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        selectFolderButton.setText("Select Project Folder");
        selectFolderButton.addActionListener(this::selectFolderButtonActionPerformed);

        pathTextField.setText("");
        pathTextField.setEditable(false);

        jScrollPane1.setViewportView(rootList);

        addRootButton.setText("Add Root");
        addRootButton.addActionListener(this::addRootButtonActionPerformed);

        removeRootButton.setText("Remove Root");
        removeRootButton.addActionListener(this::removeRootButtonActionPerformed);

        doneButton.setText("Done");
        doneButton.addActionListener(this::doneButtonActionPerformed);

        menuFile.setText("File");
        menuBar.add(menuFile);

        menuHelp.setText("Help");
        menuBar.add(menuHelp);

        rootList.setListData(rootVector);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(pathTextField)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(selectFolderButton))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addRootButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(removeRootButton)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(doneButton)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(pathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectFolderButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addRootButton)
                                        .addComponent(removeRootButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(doneButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }

    private void selectFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            String path = file.getAbsolutePath();
            pathTextField.setText(path);

            rootVector.clear();

            addRootButton.setEnabled(false);
            removeRootButton.setEnabled(false);
            selectFolderButton.setEnabled(false);
            doneButton.setEnabled(false);
            selectFolderButton.setText("Processing...");

            Thread thread = new Thread(() -> {
                try {
                    PackageRootFinder.getDirectories(path, (Double d) -> {
                        progressBar.setValue(d.intValue());
                    }).forEach(p -> {
                        if (!rootVector.contains(p))
                            rootVector.add(p);
                    });
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                finally {
                    addRootButton.setEnabled(true);
                    removeRootButton.setEnabled(true);
                    selectFolderButton.setEnabled(true);
                    doneButton.setEnabled(true);
                    selectFolderButton.setText("Select Project Folder");

                    rootList.setListData(rootVector);

                    progressBar.setValue(0);
                }
            });

            thread.start();
        }
    }

    private void addRootButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            if (rootVector.contains(file.getAbsolutePath()))
                return;
            rootVector.add(file.getAbsolutePath());
            rootList.setListData(rootVector);
        }
    }

    private void removeRootButtonActionPerformed(java.awt.event.ActionEvent evt) {
        rootVector.removeAll(rootList.getSelectedValuesList());
        rootList.setListData(rootVector);
    }

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String path = pathTextField.getText();
        if (path.equals("")) {
            JOptionPane.showMessageDialog(JavaAnalyzerGUI.this, "Path field cannot be empty.");
            return;
        }

        addRootButton.setEnabled(false);
        removeRootButton.setEnabled(false);
        selectFolderButton.setEnabled(false);
        doneButton.setEnabled(false);
        doneButton.setText("Processing...");

        Thread thread = new Thread(() -> {
            JavaParserTypeSystemCreator typeSystemCreator = new JavaParserTypeSystemCreator(path, false);
            rootVector.forEach(typeSystemCreator::addPackagePath);

            TypeSystem typeSystem = typeSystemCreator.createTypeSystem((Double d) -> {
                progressBar.setValue(d.intValue());
            });

            progressBar.setValue(0);

            addRootButton.setEnabled(true);
            removeRootButton.setEnabled(true);
            selectFolderButton.setEnabled(true);
            doneButton.setEnabled(true);
            doneButton.setText("Done");

            this.setVisible(false);
            new PatternFinderGUI(this, path, typeSystem).setVisible(true);
        });

        thread.start();
    }

    public static void main(String args[]) {
        try {
            Patterns.readPatterns();
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | javax.swing.UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaAnalyzerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new JavaAnalyzerGUI().setVisible(true));
    }

}
