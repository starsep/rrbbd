package com.starsep.rrbridge_bidding_data;

import com.starsep.rrbridge_bidding_data.gui.MainGUI;
import com.starsep.rrbridge_bidding_data.translation.Translatable;

import java.util.Locale;

public class Main {
    private static final String NO_GUI_ARG = "--no-gui";
    private static Locale locale;

    public static void main(String[] args) {
        setLocale(new Locale("pl"));
        if (checkGUI(args)) {
            MainGUI.launchGUI();
        }
    }

    private static boolean checkGUI(final String[] args) {
        boolean result = true;
        for (String arg : args) {
            if (arg.equals(NO_GUI_ARG)) {
                result = false;
            }
        }
        return result;
    }

    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale newLocale) {
        locale = newLocale;
        Translatable.translate();
    }

    public static String getVersion() {
        return "0.0.1";
    }
}
