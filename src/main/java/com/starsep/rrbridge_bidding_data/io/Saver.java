package com.starsep.rrbridge_bidding_data.io;

import com.starsep.rrbridge_bidding_data.core.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Saver {
    public static void save(String text, String filename) throws FileNotFoundException {
        File directory = Main.getWorkingDirectory();
        filename = directory.getAbsolutePath() + File.separator + filename;
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(text);
        }
    }
}
