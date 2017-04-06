package com.starsep.rrbridge_bidding_data.gui;

import javax.swing.*;

public class RunPanel extends JPanel {
    public RunPanel() {
        super();
        add(new RunButton());
        Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3"},
                { "Row2-Column1", "Row2-Column2", "Row2-Column3"} };
        Object columnNames[] = { "Column One", "Column Two", "Column Three"};
        add(new StatusTable());
    }
}
