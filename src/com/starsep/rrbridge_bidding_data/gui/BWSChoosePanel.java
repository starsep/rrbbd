package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class BWSChoosePanel extends JPanel {
    private JPanel bwsChoosePanel;
    private JButton chooseButton;
    private JTextField bwsTextField;

    BWSChoosePanel() {
        super();
        chooseButton.addActionListener(e -> showBWSDialog());
        add(bwsChoosePanel);
    }

    private class BWSFileFilter extends FileFilter {
        @Override
        public boolean accept(File f) {
            return f.isDirectory() || f.toString().endsWith(".bws");
        }

        @Override
        public String getDescription() {
            return Translation.get().bwsDescription() + " (*.bws)";
        }
    }

    private void showBWSDialog() {
        JFileChooser bwsDialog = new JFileChooser();
        bwsDialog.setFileFilter(new BWSFileFilter());
        String bwsApproveText = Translation.get().choose() + " " + Translation.get().bwsDescription();
        if (bwsDialog.showDialog(getParent(), bwsApproveText) == JFileChooser.APPROVE_OPTION) {
            File file = bwsDialog.getSelectedFile();
            bwsTextField.setText(file.toString());
        }
    }
}
