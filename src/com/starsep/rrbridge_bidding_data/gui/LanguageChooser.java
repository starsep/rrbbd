package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.Main;
import com.starsep.rrbridge_bidding_data.translation.*;

import javax.swing.*;
import java.util.Locale;

public class LanguageChooser extends JPanel implements ITranslatable {
    private JPanel languageChooserPanel;
    private JButton englishButton;
    private JButton polishButton;
    private JLabel languageLabel;

    LanguageChooser() {
        super();
        englishButton.addActionListener(e -> setEnglish());
        polishButton.addActionListener(e -> setPolish());
        add(languageChooserPanel);
        Translatable.add(this);
    }

    private void setEnglish() {
        Main.setLocale(new Locale("en"));
    }

    private void setPolish() {
        Main.setLocale(new Locale("pl"));
    }

    @Override
    public void translate() {
        languageLabel.setText(Translation.get().language() + ":");
    }
}
