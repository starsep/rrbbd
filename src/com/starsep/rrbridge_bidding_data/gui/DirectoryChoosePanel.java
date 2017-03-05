package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;
import java.io.File;

public class DirectoryChoosePanel extends JPanel {
    private JTextField directoryTextField;
    private JButton chooseButton;
    private JPanel directoryChoosePanel;

    DirectoryChoosePanel() {
        super();
        chooseButton.addActionListener(e -> showDirectoryDialog());
        add(directoryChoosePanel);
    }

    private void showDirectoryDialog() {
        JFileChooser directoryDialog = new JFileChooser();
        directoryDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (directoryDialog.showDialog(getParent(), Translation.get().choose()) == JFileChooser.APPROVE_OPTION) {
            File file = directoryDialog.getSelectedFile();
            directoryTextField.setText(file.toString());
        }
    }
}
