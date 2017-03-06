package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.translation.Translation;

class Console {
    static void launch() {
        if (!Arguments.checkNumberOfArguments()) {
            System.err.println(Translation.get().insufficientArgumentsNumberError());
            System.exit(1);
        }
        new Runner().run();
    }
}
