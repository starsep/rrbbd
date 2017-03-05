package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.translation.*;

import javax.swing.*;
import java.io.File;

public class DirectoryChoosePanel extends JPanel implements ITranslatable {
    private JTextField directoryTextField;
    private JButton chooseButton;
    private JPanel directoryChoosePanel;
    private JLabel directoryLabel;

    DirectoryChoosePanel() {
        super();
        chooseButton.addActionListener(e -> showDirectoryDialog());
        add(directoryChoosePanel);
        Translatable.add(this);
    }

    private void showDirectoryDialog() {
        JFileChooser directoryDialog = new JFileChooser();
        directoryDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String directoryApproveText = Translation.get().choose() + " " + Translation.get().directory();
        if (directoryDialog.showDialog(getParent(), directoryApproveText) == JFileChooser.APPROVE_OPTION) {
            File file = directoryDialog.getSelectedFile();
            directoryTextField.setText(file.toString());
        }
    }

    @Override
    public void translate() {
        chooseButton.setText(Translation.get().choose());
        directoryLabel.setText(Translation.get().directory() + ":");
    }
}
