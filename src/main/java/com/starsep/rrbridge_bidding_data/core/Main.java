package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.translation.Translatable;
import com.starsep.rrbridge_bidding_data.translation.Translation;
import com.starsep.rrbridge_bidding_data.gui.MainGUI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class Main {
    private static final String PROGRAM_NAME = "RRBridge Bidding Data";

    private static Properties buildProperties;
    private static final String BUILD_PROPERTIES_FILENAME = "build.properties";
    private static final String VERSION_KEY = "version";

    private static final int DEFAULT_WAIT_TIME = 60;

    private static Locale locale;
    private static boolean guiEnabled = true;
    private static File workingDirectory = null;
    private static File bwsFile = null;
    private static int waitTime = DEFAULT_WAIT_TIME;

    public static void main(String[] args) {
        Arguments.init(args);
        if (locale == null) {
            setLocale(new Locale("pl"));
        }
        launch();
    }

    private static void launch() {
        launchingInfo();
        if (guiEnabled) {
            MainGUI.launchGUI();
        } else {
            Console.launch();
        }
    }

    private static void launchingInfo() {
        System.out.print(Translation.get().launching() + " " + PROGRAM_NAME + " v" + getVersion());
        System.out.println(" " + (guiEnabled ? Translation.get().guiMode() : Translation.get().consoleMode()));
        if (!locale.getLanguage().contains("en")) {
            System.out.println("For English use " + Arguments.ENGLISH_FLAG);
        }
        System.out.println("");
        printUsage();
    }

    private static void printUsage() {
        System.out.print(Translation.get().usage());
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

    private static void initBuildProperties() {
        buildProperties =  new Properties();
        InputStream input = null;

        try {
            input = Main.class.getClassLoader().getResourceAsStream(BUILD_PROPERTIES_FILENAME);
            buildProperties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getVersion() {
        if (buildProperties == null) {
            initBuildProperties();
        }
        return buildProperties.getProperty(VERSION_KEY);
    }

    static void disableGUI() {
        guiEnabled = false;
    }

    public static void setWorkingDirectory(File directory) {
        workingDirectory = directory;
    }

    public static File getWorkingDirectory() {
        return workingDirectory;
    }

    public static void setBWSFile(File file) {
        bwsFile = file;
    }

    public static File getBwsFile() {
        return bwsFile;
    }

    public static void setWaitTime(int time) {
        waitTime = time;
    }

    public static int getWaitTime() {
        return waitTime;
    }
}
