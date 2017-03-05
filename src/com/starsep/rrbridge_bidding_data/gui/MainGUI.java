package com.starsep.rrbridge_bidding_data.gui;

import javax.swing.*;
import java.awt.*;

public class MainGUI {
    public static void launchGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(() -> {
            MainFrame window = new MainFrame();
            window.setVisible(true);
        });
    }
}
