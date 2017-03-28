package com.starsep.rrbridge_bidding_data.bidding.call;

class Invalid extends StringCall {
    Invalid(String s) {
        super("INVALID(" + s + ")", "INVALID(" + s + ")");
    }
}
