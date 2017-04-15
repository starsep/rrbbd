package com.starsep.rrbbd.gui;

import com.starsep.rrbbd.core.Main;
import com.starsep.rrbbd.core.Runner;
import com.starsep.rrbbd.translation.ITranslatable;
import com.starsep.rrbbd.translation.TranslatableSet;
import com.starsep.rrbbd.translation.Translation;

import javax.swing.*;

public class RunPanel extends JPanel implements ITranslatable {
    private static final int[] DEFAULT_INTERVALS = new int[]{-1, 10, 20, 30, 45, 60, 120};
    private int[] intervals;
    private JButton runButton;
    private JComboBox<String> timeSelect;
    private Timer timer;

    private String[] timeSelectOptions() {
        String[] result = new String[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = intervals[i] <= 0
                    ? Translation.get().justOnce()
                    : Translation.get().everyNSeconds(intervals[i]);
        }
        return result;
    }

    private void initIntervals() {
        int time = Main.getWaitTime();
        for (int t : DEFAULT_INTERVALS) {
            if (t == time) {
                intervals = DEFAULT_INTERVALS.clone();
                return;
            }
        }
        intervals = new int[DEFAULT_INTERVALS.length + 1];
        intervals[0] = time;
        System.arraycopy(DEFAULT_INTERVALS, 0, intervals, 1, DEFAULT_INTERVALS.length);
    }

    private void initTimeSelect() {
        timeSelect = new JComboBox<>(timeSelectOptions());
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == Main.getWaitTime()) {
                timeSelect.setSelectedIndex(i);
                break;
            }
        }
        timeSelect.addActionListener(e -> Main.setWaitTime(intervals[timeSelect.getSelectedIndex()]));
        add(timeSelect);
    }

    /**
     * Constructor for RunPanel.
     */
    public RunPanel() {
        super();
        initIntervals();

        timer = new Timer(1000, e -> new Runner().run());

        initTimeSelect();

        runButton = new JButton();
        runButton.addActionListener(e -> run());
        add(runButton);

        TranslatableSet.add(this);
    }

    private void run() {
        timer.stop();
        if (Main.getWaitTime() <= 0) {
            new Runner().run();
        } else {
            timer.setDelay(1000 * Main.getWaitTime());
            timer.start();
        }
    }

    @Override
    public void translate() {
        runButton.setText(Translation.get().run());
        int index = timeSelect.getSelectedIndex();
        timeSelect.setModel(new DefaultComboBoxModel<>(timeSelectOptions()));
        timeSelect.setSelectedIndex(index);
    }
}
