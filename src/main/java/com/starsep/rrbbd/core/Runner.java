package com.starsep.rrbbd.core;

import com.starsep.rrbbd.bidding.BiddingSet;
import com.starsep.rrbbd.io.ResourceFileCopy;

import java.io.File;
import java.io.IOException;

public class Runner implements Runnable {
    private void saveHTMLs() {
        try {
            BWSReader bwsReader = new BWSReader(Main.getBwsFile());
            BiddingSet biddingSet = bwsReader.getBiddingSet();
            biddingSet.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String JS_RESOURCE = "/js/bidding.js";
    private static final String JS_OUTPUT = File.separator + "bidding.js";
    private static final String CSS_RESOURCE = "/css/bidding.css";
    private static final String CSS_OUTPUT = File.separator + "bidding.css";
    private static final String LINK_RESOURCE = "/img/link.png";
    private static final String LINK_OUTPUT = File.separator + "img" + File.separator + "link.png";
    private static final String FORUM_RESOURCE = "/img/forum.png";
    private static final String FORUM_OUTPUT = File.separator + "img" + File.separator + "forum.png";

    private void copyResources() throws IOException {
        ResourceFileCopy.copyResourceFile(JS_RESOURCE, JS_OUTPUT);
        ResourceFileCopy.copyResourceFile(CSS_RESOURCE, CSS_OUTPUT);
        ResourceFileCopy.copyResourceFile(LINK_RESOURCE, LINK_OUTPUT);
        ResourceFileCopy.copyResourceFile(FORUM_RESOURCE, FORUM_OUTPUT);
    }


    @Override
    public void run() {
        try {
            copyResources();
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveHTMLs();
    }
}
