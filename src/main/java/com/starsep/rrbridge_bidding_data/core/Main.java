package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;
import com.starsep.rrbridge_bidding_data.gui.MainGUI;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final String PROGRAM_NAME = "RRBridge Bidding Data";

    public static final String NO_GUI_FLAG = "--no-gui";
    public static final String ENGLISH_FLAG = "--english";
    public static final String POLISH_FLAG = "--polish";

    private static Locale locale;
    private static boolean guiEnabled;

    public static void main(String[] args) {
        guiEnabled = true;
        eraseFlags(args);
        if (locale == null) {
            setLocale(new Locale("pl"));
        }
        launchingInfo();
        if (guiEnabled) {
            MainGUI.launchGUI();
        } else {
            Console.launch(args);
        }
    }

    private static void launchingInfo() {
        System.out.print(Translation.get().launching() + " " + PROGRAM_NAME + " v" + getVersion());
        System.out.println(" " + (guiEnabled ? Translation.get().guiMode() : Translation.get().consoleMode()));
        if (!locale.getLanguage().contains("en")) {
            System.out.println("For English use " + ENGLISH_FLAG);
        }
        System.out.println("");
        printUsage();
    }

    private static void printUsage() {
        System.out.print(Translation.get().usage());
    }

    private static void checkFlag(String flag) {
        switch (flag) {
            case NO_GUI_FLAG:
                guiEnabled = false;
                break;
            case ENGLISH_FLAG:
                setEnglish();
                break;
            case POLISH_FLAG:
                setPolish();
                break;
        }
    }

    private static void eraseFlags(String[] args) {
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

    public static Locale getLocale() {
        return locale;
    }

    private static void setLocale(Locale newLocale) {
        locale = newLocale;
        Translatable.translate();
    }

    public static void setEnglish() {
        setLocale(new Locale("en"));
    }

    public static void setPolish() {
        setLocale(new Locale("pl"));
    }

    public static String getVersion() {
        return "0.0.1";
    }
}
