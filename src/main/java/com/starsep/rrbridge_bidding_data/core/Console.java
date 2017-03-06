package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.translation.Translation;

import java.io.File;
import java.io.IOException;

class Console {
    static void launch() {
        if (!Arguments.checkNumberOfArguments()) {
            System.err.println(Translation.get().insufficientArgumentsNumberError());
            System.exit(1);
        }
        try {
            new BWSReader(new File(Main.getBwsFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
