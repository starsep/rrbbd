package com.starsep.rrbbd.gui;

import com.starsep.rrbbd.core.Main;
import com.starsep.rrbbd.translation.ITranslatable;
import com.starsep.rrbbd.translation.TranslatableSet;
import com.starsep.rrbbd.translation.Translation;

import javax.swing.*;

class MainFrame extends JFrame implements ITranslatable {
    MainFrame() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
        add(new DirectoryChoosePanel());
        add(new BWSChoosePanel());
        add(new RunPanel());
        add(new LanguageChooser());
        TranslatableSet.add(this);
    }

    @Override
    public void translate() {
        setTitle("RRBridge Bidding Data " + Translation.get().version() + " " + Main.getVersion());
    }
}
