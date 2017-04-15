package com.starsep.rrbbd.bidding.call;

class Invalid extends StringCall {
    Invalid(String s) {
        super("INVALID(" + s + ")", "INVALID(" + s + ")");
    }
}
