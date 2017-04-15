package com.starsep.rrbbd.io;

import com.starsep.rrbbd.core.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.*;

public abstract class ResourceFileCopy {
    /**
     * Copy resource file.
     * @param resourceFilename filename of resource
     * @param dest destination filename
     * @throws IOException on copying failure
     */
    public static void copyResourceFile(String resourceFilename, String dest) throws IOException {
        File directory = Main.getWorkingDirectory();
        URL inputUrl = directory.getClass().getResource(resourceFilename);
        FileUtils.copyURLToFile(inputUrl, new File(directory.getAbsolutePath() + dest));
    }
}
