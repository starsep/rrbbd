package com.starsep.rrbbd.gui;

import com.starsep.rrbbd.core.Main;
import com.starsep.rrbbd.translation.ITranslatable;
import com.starsep.rrbbd.translation.TranslatableSet;
import com.starsep.rrbbd.translation.Translation;

import java.awt.*;
import javax.swing.*;

public class LanguageChooser extends JPanel implements ITranslatable {
    private JLabel languageLabel;

    LanguageChooser() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        languageLabel = new JLabel();
        languageLabel.setText("Language:");
        add(languageLabel);

        JButton polishButton = new JButton();
        polishButton.setIcon(new ImageIcon(getClass().getResource("/icons/pl.png")));
        polishButton.setText("Polski");
        polishButton.addActionListener(e -> Main.setPolish());
        add(polishButton);

        JButton englishButton = new JButton();
        englishButton.setIcon(new ImageIcon(getClass().getResource("/icons/gb.png")));
        englishButton.setText("English");
        englishButton.addActionListener(e -> Main.setEnglish());
        add(englishButton);

        TranslatableSet.add(this);
    }

    @Override
    public void translate() {
        languageLabel.setText(Translation.get().language() + ":");
    }
}
