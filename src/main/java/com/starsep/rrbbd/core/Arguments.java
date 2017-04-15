package com.starsep.rrbbd.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Arguments {
    public static final String NO_GUI_FLAG = "--no-gui";
    public static final String ENGLISH_FLAG = "--english";
    public static final String POLISH_FLAG = "--polish";
    public static final String HELP_FLAG = "--help";
    public static final String VERSION_FLAG = "--version";
    private static final int ARGUMENTS_NUMBER = 3;

    private static String[] args;

    static void init(String[] a) {
        args = a;
        eraseFlags();
        parseArguments();
    }

    private static void parseArguments() {
        Main.setWorkingDirectory(new File(args.length >= 1 ? args[0] : ""));
        Main.setBWSFile(new File(args.length >= 2 ? args[1] : ""));
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
            case HELP_FLAG:
                Main.showHelp();
                break;
            case VERSION_FLAG:
                Main.showVersion();
                break;
            default:
                System.err.println(String.format("Unknown flag %s", flag));
                break;
        }
    }

    private static void eraseFlags() {
        List<String> nonFlagArguments = new ArrayList<>();
        for (String arg : args) {
            if (!arg.startsWith("--")) {
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
