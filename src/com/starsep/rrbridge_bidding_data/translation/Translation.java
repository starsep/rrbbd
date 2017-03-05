package com.starsep.rrbridge_bidding_data.translation;

import com.starsep.rrbridge_bidding_data.Main;

public abstract class Translation {
    public static ITranslation get() {
        if (Main.getLocale().getLanguage().contains("pl")) {
            return new Polish();
        } else {
            return new English();
        }
    }
}
