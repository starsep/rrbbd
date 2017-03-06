package com.starsep.rrbridge_bidding_data.core;

import com.starsep.rrbridge_bidding_data.translation.Translation;

class Console {
    static void launch(final String[] args) {
        checkNumberOfArguments(args.length);
    }

    private static void checkNumberOfArguments(int number) {
        if (number < 3) {
            System.err.println(Translation.get().insufficientArgumentsNumberError());
            System.exit(1);
        }
    }
}
