package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.bidding.BiddingSet;
import com.starsep.rrbridge_bidding_data.io.Saver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Runner implements Runnable {
    private static String javascriptCode;

    private void updateJSONs() {
        try {
            BWSReader bwsReader = new BWSReader(Main.getBwsFile());
            BiddingSet biddingSet = bwsReader.getBiddingSet();
            biddingSet.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String JAVASCRIPT_RESOURCE_FILENAME = "/js/bidding.js";
    private static final String JAVASCRIPT_OUTPUT_FILENAME = File.separator + "bidding.js";

    private void initJavascript() {
        StringBuilder builder = new StringBuilder("");

        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(JAVASCRIPT_RESOURCE_FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                builder.append(line).append("\n");
            }
        }
        javascriptCode = builder.toString();
    }

    private void copyJavascript() throws FileNotFoundException {
        if (javascriptCode == null) {
            initJavascript();
        }
        Saver.save(javascriptCode, JAVASCRIPT_OUTPUT_FILENAME);
    }


    @Override
    public void run() {
        try {
            copyJavascript();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        updateJSONs();
    }
}
