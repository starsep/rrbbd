package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.core.Runner;
import com.starsep.rrbridge_bidding_data.translation.ITranslatable;
import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;

public class RunButton extends JButton implements ITranslatable {

    public RunButton() {
        Translatable.add(this);
        addActionListener(e -> new Runner().run());
    }



    @Override
    public void translate() {
        setText(Translation.get().run());
    }
}
