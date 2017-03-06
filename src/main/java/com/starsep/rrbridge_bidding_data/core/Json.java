package com.starsep.rrbridge_bidding_data.core;

import com.google.gson.Gson;

public abstract class Json {
    private static Gson gson;

    private static void init() {
        gson = new Gson();
    }

    public static Gson get() {
        if (gson == null) {
            init();
        }
        return gson;
    }
}
