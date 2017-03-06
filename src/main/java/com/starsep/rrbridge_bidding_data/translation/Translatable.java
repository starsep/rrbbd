package com.starsep.rrbridge_bidding_data.translation;

import java.util.ArrayList;
import java.util.List;

public abstract class Translatable {
    private static List<ITranslatable> translatableList;

    public static void add(ITranslatable translatable) {
        init();
        translatableList.add(translatable);
        translatable.translate();
    }

    private static void init() {
        if (translatableList == null) {
            translatableList = new ArrayList<>();
        }
    }

    public static void translate() {
        init();
        for (ITranslatable t : translatableList) {
            t.translate();
        }
    }
}
