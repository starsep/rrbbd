package com.starsep.rrbbd.io;

import com.starsep.rrbbd.core.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Saver {
    /**
     * Save text to file.
     * @param text content to save
     * @param filename output file name
     * @throws FileNotFoundException on PrintWriter ctor failure
     */
    public static void save(String text, String filename) throws FileNotFoundException {
        File directory = Main.getWorkingDirectory();
        filename = directory.getAbsolutePath() + File.separator + filename;
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(text);
        }
    }
}
