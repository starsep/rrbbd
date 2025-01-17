package com.starsep.rrbbd.gui;

import com.starsep.rrbbd.core.Main;
import com.starsep.rrbbd.translation.ITranslatable;
import com.starsep.rrbbd.translation.TranslatableSet;
import com.starsep.rrbbd.translation.Translation;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class DirectoryChoosePanel extends JPanel implements ITranslatable {
    private JTextField directoryTextField;
    private JButton chooseButton;
    private JLabel directoryLabel;

    DirectoryChoosePanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        directoryLabel = new JLabel();
        directoryLabel.setText("RRBridge work directory:");
        add(directoryLabel);

        directoryTextField = new JTextField();
        directoryTextField.setColumns(35);
        directoryTextField.setEditable(false);
        directoryTextField.setText(Main.getWorkingDirectory().toString());
        add(directoryTextField);

        chooseButton = new JButton();
        chooseButton.setText("Choose");
        chooseButton.addActionListener(e -> showDirectoryDialog());
        add(chooseButton);

        TranslatableSet.add(this);
    }

    private void showDirectoryDialog() {
        JFileChooser directoryDialog = new JFileChooser();
        directoryDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String directoryApproveText = Translation.get().choose() + " " + Translation.get().directory();
        if (directoryDialog.showDialog(getParent(), directoryApproveText) == JFileChooser.APPROVE_OPTION) {
            File file = directoryDialog.getSelectedFile();
            directoryTextField.setText(file.toString());
            Main.setWorkingDirectory(file);
        }
    }

    @Override
    public void translate() {
        chooseButton.setText(Translation.get().choose());
        directoryLabel.setText(Translation.get().directory() + ":");
    }
}
