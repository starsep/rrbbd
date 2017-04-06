package com.starsep.rrbridge_bidding_data.gui;

import javax.swing.*;
import java.awt.*;

public class StatusTable extends JComponent {
    public StatusTable() {
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(700, 100);
    }

    @Override
    public void paint(Graphics _g) {
        super.paint(_g);
        System.err.print("PAINTING");
        Graphics2D g = (Graphics2D) _g;
        g.setFont(g.getFont().deriveFont(Font.BOLD));
        int strHeight = g.getFont().getSize();
        int dealsPerRound = 3;
        int roundCount = 7;
        int tableCount = 4;
        int cellsVertical = tableCount + 1;
        int selected = 2;

        int k;
        for (int i = 1; i < cellsVertical; ++i) {
            Rectangle r = new Rectangle(0, i * 20, 40, 20);
            if (i - 1 == selected) {
                g.setColor(Style.SELECTED_HEADER_COLOR);
            } else {
                g.setColor(Style.HEADER_COLOR);
            }

            g.fill(r);
            g.setColor(Color.black);
            g.draw(r);
            String strVal = String.valueOf(i);
            k = (int) g.getFont().getStringBounds(strVal, g.getFontRenderContext()).getWidth();
            g.drawString(strVal, 20 - k / 2, 20 * (i + 1) - 10 + strHeight / 2);
        }


        int horizontalCoord;
        for (int i = 0; i < roundCount; ++i) {
            Rectangle r = new Rectangle(40 + i * dealsPerRound * 30, 0, 30 * dealsPerRound, 20);
            if (i == selected / dealsPerRound) {
                g.setColor(Style.SELECTED_HEADER_COLOR);
            } else {
                g.setColor(Style.HEADER_COLOR);
            }

            g.fill(r);
            g.setColor(Color.black);
            g.draw(r);
            String strVal = "runda " + String.valueOf(i + 1);
            horizontalCoord = (int) g.getFont().getStringBounds(strVal, g.getFontRenderContext()).getWidth();
            g.drawString(strVal, 40 + i * dealsPerRound * 30 + dealsPerRound * 30 / 2 - horizontalCoord / 2, 10 + strHeight / 2);
        }

        for (int i = 0; i < tableCount; ++i) {
            for (int j = 0; j < roundCount; ++j) {
                for (k = 0; k < dealsPerRound; ++k) {
                    horizontalCoord = j * dealsPerRound + k;
                    Rectangle r = new Rectangle(40 + horizontalCoord * 30, (i + 1) * 20, 30, 20);
                    g.setColor(i % 2 == 0 ? Color.yellow : Color.orange);
                    g.fill(r);
                    g.setColor(Color.black);
                    g.draw(r);
                    String strVal = String.valueOf(dealsPerRound * j + k + 1);
                    double strWidth = g.getFont().getStringBounds(strVal, g.getFontRenderContext()).getWidth();
                    g.drawString(strVal, 40 + horizontalCoord * 30 + 15 - (int) (strWidth / 2.0D), (i + 2) * 20 - 10 + strHeight / 2);
                }
            }
        }
    }
}
