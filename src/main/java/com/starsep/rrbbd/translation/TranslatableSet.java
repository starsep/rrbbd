package com.starsep.rrbbd.translation;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains references to all translatable elements.
 */
public abstract class TranslatableSet {
    private static List<ITranslatable> translatableList;

    /**
     * Add element to set.
     * @param translatable element to be added
     */
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

    /**
     * Translate all elements in the set.
     */
    public static void translate() {
        init();
        for (ITranslatable t : translatableList) {
            t.translate();
        }
    }
}
