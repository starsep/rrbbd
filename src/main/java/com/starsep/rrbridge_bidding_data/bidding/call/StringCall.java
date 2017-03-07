package com.starsep.rrbridge_bidding_data.bidding.call;

import j2html.tags.DomContent;

import static j2html.TagCreator.td;

class StringCall implements Call {
    private String call;

    StringCall(String s) {
        call = s;
    }

    @Override
    public DomContent html() {
        return td(call);
    }
}
