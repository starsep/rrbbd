package com.starsep.rrbbd.translation;

import com.starsep.rrbbd.core.Main;

/**
 * Program translation.
 */
public abstract class Translation {
    private static Polish polish;
    private static English english;

    /**
     * Init translation instances.
     */
    private static void init() {
        if (polish == null) {
            polish = new Polish();
            english = new English();
        }
    }

    /**
     * Returns translation in current language.
     * @return translation
     */
    public static Translation get() {
        init();
        if (Main.getLocale().getLanguage().contains("pl")) {
            return polish;
        } else {
            return english;
        }
    }

    /**
     * Returns BWS file description translation.
     * @return BWS file description translation
     */
    public abstract String bwsDescription();

    /**
     * Returns version translation.
     * @return version translation
     */
    public abstract String version();

    /**
     * Returns language translation.
     * @return language translation
     */
    public abstract String language();

    /**
     * Returns choose translation.
     * @return choose translation
     */
    public abstract String choose();

    /**
     * Returns BWS file label translation.
     * @return BWS file label translation
     */
    public abstract String bwsLabel();

    /**
     * Returns working directory translation.
     * @return working directory translation
     */
    public abstract String directory();

    /**
     * Returns usage help translation.
     * @return usage help translation
     */
    public abstract String usage();

    /**
     * Returns message at launching translation.
     * @return message at launching translation
     */
    public abstract String launching();

    /**
     * Returns GUI mode translation.
     * @return GUI mode translation
     */
    public abstract String guiMode();

    /**
     * Returns console mode translation.
     * @return console mode translation
     */
    public abstract String consoleMode();

    /**
     * Returns error with insufficient arguments translation.
     * @return error with insufficient arguments translation
     */
    public abstract String insufficientArgumentsNumberError();

    /**
     * Returns error translation.
     * @return error translation
     */
    public abstract String error();

    /**
     * Returns run translation.
     * @return run translation
     */
    public abstract String run();

    /**
     * Returns every n second translation.
     * @param n number of seconds
     * @return every n second translation
     */
    public abstract String everyNSeconds(int n);

    /**
     * Returns just once translation.
     * @return just once translation
     */
    public abstract String justOnce();
}
