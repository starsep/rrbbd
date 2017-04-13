package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.core.BWSReader;
import com.starsep.rrbridge_bidding_data.core.Main;
import com.starsep.rrbridge_bidding_data.translation.ITranslatable;
import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BWSChoosePanel extends JPanel implements ITranslatable {
    private JButton chooseButton;
    private JTextField bwsTextField;
    private JLabel bwsLabel;

    BWSChoosePanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        bwsLabel = new JLabel();
        add(bwsLabel);

        bwsTextField = new JTextField();
        bwsTextField.setColumns(35);
        bwsTextField.setText(Main.getBwsFile().toString());
        add(bwsTextField);

        chooseButton = new JButton();
        chooseButton.addActionListener(e -> showBWSDialog());
        add(chooseButton);

        Translatable.add(this);
    }

    @Override
    public void translate() {
        bwsLabel.setText(Translation.get().bwsLabel() + ":");
        chooseButton.setText(Translation.get().choose());
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
            Main.setBWSFile(file);
        }
    }
}
