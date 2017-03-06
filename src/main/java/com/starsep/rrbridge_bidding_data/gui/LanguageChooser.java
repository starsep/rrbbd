package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.core.Main;
import com.starsep.rrbridge_bidding_data.translation.ITranslatable;
import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class LanguageChooser extends JPanel implements ITranslatable {
    private JButton englishButton;
    private JButton polishButton;
    private JLabel languageLabel;

    LanguageChooser() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        languageLabel = new JLabel();
        languageLabel.setText("Language:");
        add(languageLabel);

        polishButton = new JButton();
        polishButton.setIcon(new ImageIcon(getClass().getResource("/icons/pl.png")));
        polishButton.setText("Polski");
        polishButton.addActionListener(e -> Main.setPolish());
        add(polishButton);

        englishButton = new JButton();
        englishButton.setHideActionText(false);
        englishButton.setIcon(new ImageIcon(getClass().getResource("/icons/gb.png")));
        englishButton.setText("English");
        englishButton.addActionListener(e -> Main.setEnglish());
        add(englishButton);

        Translatable.add(this);
    }

    @Override
    public void translate() {
        languageLabel.setText(Translation.get().language() + ":");
    }
}
