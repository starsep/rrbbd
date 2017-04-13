package com.starsep.rrbridge_bidding_data.translation;

import com.starsep.rrbridge_bidding_data.core.Main;

public abstract class Translation {
    private static final Polish polish = new Polish();
    private static final English english = new English();

    public static ITranslation get() {
        if (Main.getLocale().getLanguage().contains("pl")) {
            return polish;
        } else {
            return english;
        }
    }
}
