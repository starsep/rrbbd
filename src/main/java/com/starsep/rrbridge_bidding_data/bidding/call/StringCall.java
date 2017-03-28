package com.starsep.rrbridge_bidding_data.bidding.call;

import j2html.tags.DomContent;

import static j2html.TagCreator.td;
import static j2html.TagCreator.text;

class StringCall implements Call {
    private String call;
    private String forum;

    StringCall(String s, String f) {
        call = s;
        forum = f;
    }

    @Override
    public DomContent html() {
        return td(call);
    }

    @Override
    public DomContent forumHtml() {
        return text(forum);
    }
}
