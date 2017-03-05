package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.core.Main;
import com.starsep.rrbridge_bidding_data.translation.*;

import javax.swing.*;

class MainFrame extends JFrame implements ITranslatable {
    MainFrame() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(new DirectoryChoosePanel());
        add(new BWSChoosePanel());
        add(new LanguageChooser());
        Translatable.add(this);
    }

    @Override
    public void translate() {
        setTitle("RRBridge Bidding Data " + Translation.get().version() + " " + Main.getVersion());
    }
}
