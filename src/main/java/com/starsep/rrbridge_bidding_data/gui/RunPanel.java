package com.starsep.rrbridge_bidding_data.gui;

import com.starsep.rrbridge_bidding_data.core.Main;
import com.starsep.rrbridge_bidding_data.core.Runner;
import com.starsep.rrbridge_bidding_data.translation.ITranslatable;
import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;

import javax.swing.*;
import java.util.Arrays;

public class RunPanel extends JPanel implements ITranslatable {
    private final int[] DEFAULT_INTERVALS = new int[]{-1, 10, 20, 30, 45, 60, 120};
    private int[] intervals;
    private JButton runButton;
    private JComboBox<String> timeSelect;

    private String[] timeSelectOptions() {
        String[] result = new String[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = intervals[i] < 0 ? Translation.get().justOnce() : Translation.get().everyNSeconds(intervals[i]);
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

    public RunPanel() {
        super();
        initIntervals();

        timeSelect = new JComboBox<>(timeSelectOptions());
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == Main.getWaitTime()) {
                timeSelect.setSelectedIndex(i);
                break;
            }
        }
        timeSelect.addActionListener(e -> Main.setWaitTime(intervals[timeSelect.getSelectedIndex()]));
        add(timeSelect);

        runButton = new JButton();
        runButton.addActionListener(e -> new Runner().run());
        add(runButton);

        Translatable.add(this);
    }

    @Override
    public void translate() {
        runButton.setText(Translation.get().run());
        int index = timeSelect.getSelectedIndex();
        timeSelect.setModel(new DefaultComboBoxModel<>(timeSelectOptions()));
        timeSelect.setSelectedIndex(index);
    }
}
