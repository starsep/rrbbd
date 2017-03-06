package com.starsep.rrbridge_bidding_data.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Arguments {
    public static final String NO_GUI_FLAG = "--no-gui";
    public static final String ENGLISH_FLAG = "--english";
    public static final String POLISH_FLAG = "--polish";
    private static final int ARGUMENTS_NUMBER = 3;

    private static String[] args;

    static void init(String[] a) {
        args = a;
        eraseFlags();
        parseArguments();
    }

    private static void parseArguments() {
        if (args.length >= 1) {
            Main.setWorkingDirectory(args[0]);
        }
        if (args.length >= 2) {
            Main.setBWSFilename(args[1]);
        }
        if (args.length >= 3) {
            int time = Integer.decode(args[2]);
            Main.setWaitTime(time);
        }
    }

    static boolean checkNumberOfArguments() {
        return args.length == ARGUMENTS_NUMBER;
    }

    private static void checkFlag(String flag) {
        switch (flag) {
            case NO_GUI_FLAG:
                Main.disableGUI();
                break;
            case ENGLISH_FLAG:
                Main.setEnglish();
                break;
            case POLISH_FLAG:
                Main.setPolish();
                break;
        }
    }

    private static void eraseFlags() {
        List<String> nonFlagArguments = new ArrayList<>();
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                nonFlagArguments.add(arg);
            } else {
                checkFlag(arg);
            }
        }
        args = new String[nonFlagArguments.size()];
        for (int i = 0; i < args.length; i++) {
            args[i] = nonFlagArguments.get(i);
        }
    }
}
