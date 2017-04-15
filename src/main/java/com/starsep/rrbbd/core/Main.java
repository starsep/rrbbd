package com.starsep.rrbbd.core;

import com.starsep.rrbbd.gui.MainGUI;
import com.starsep.rrbbd.translation.TranslatableSet;
import com.starsep.rrbbd.translation.Translation;

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
    private static boolean showHelp = false;
    private static boolean showVersion = false;
    private static File workingDirectory = null;
    private static File bwsFile = null;
    private static int waitTime = DEFAULT_WAIT_TIME;

    /**
     * Program entry point.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Arguments.init(args);
        if (locale == null) {
            setLocale(new Locale("pl"));
        }
        if (showHelp) {
            printUsage();
            return;
        }
        if (showVersion) {
            System.out.println(PROGRAM_NAME + " v" + getVersion());
            return;
        }
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
    }

    private static void printUsage() {
        System.out.print(Translation.get().usage());
    }

    /**
     * Getter for locale.
     * @return current locale
     */
    public static Locale getLocale() {
        return locale;
    }

    private static void setLocale(Locale newLocale) {
        locale = newLocale;
        TranslatableSet.translate();
    }

    /**
     * Sets locale to English.
     */
    public static void setEnglish() {
        setLocale(new Locale("en"));
    }

    /**
     * Sets locale to Polish.
     */
    public static void setPolish() {
        setLocale(new Locale("pl"));
    }

    private static void initBuildProperties() {
        buildProperties = new Properties();
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

    /**
     * @return Program version in format MAJOR.MINOR.FIX
     */
    public static String getVersion() {
        if (buildProperties == null) {
            initBuildProperties();
        }
        return buildProperties.getProperty(VERSION_KEY);
    }

    static void disableGUI() {
        guiEnabled = false;
    }

    /**
     * @param directory will be set as working directory.
     */
    public static void setWorkingDirectory(File directory) {
        workingDirectory = directory;
    }

    /**
     * Getter for workingDirectory.
     * @return working directory
     */
    public static File getWorkingDirectory() {
        return workingDirectory;
    }

    /**
     * Setter for bwsFile.
     * @param file will be set as current BWS file
     */
    public static void setBWSFile(File file) {
        bwsFile = file;
    }

    /**
     * Getter for bwsFile.
     * @return current BWS file
     */
    public static File getBwsFile() {
        return bwsFile;
    }

    /**
     * Setter for waitTime.
     * @param time to wait in seconds, between Runner executions
     */
    public static void setWaitTime(int time) {
        waitTime = time;
    }

    /**
     * Getter for waitTime.
     * @return time in seconds to wait between Runner executions
     */
    public static int getWaitTime() {
        return waitTime;
    }

    /**
     * Stops program execution, shows help.
     */
    static void showHelp() {
        showHelp = true;
    }

    /**
     * Stops program execution, shows version.
     */
    static void showVersion() {
        showVersion = true;
    }
}
