package com.starsep.rrbbd.core;

import com.starsep.rrbbd.translation.Translation;

class Console {
    static void launch() {
        if (!Arguments.checkNumberOfArguments()) {
            System.err.println(Translation.get().insufficientArgumentsNumberError());
            System.exit(1);
        }
        new Runner().run();
    }
}
