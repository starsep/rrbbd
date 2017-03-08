package com.starsep.rrbridge_bidding_data.io;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.starsep.rrbridge_bidding_data.core.Main;
import org.apache.commons.io.*;

public abstract class ResourceFileCopy {
    public static void copyResourceFile(String resourceFilename, String dest) throws IOException {
        File directory = Main.getWorkingDirectory();
        URL inputUrl = directory.getClass().getResource(resourceFilename);
        FileUtils.copyURLToFile(inputUrl, new File(directory.getAbsolutePath() + dest));
    }
}
