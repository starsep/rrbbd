package com.starsep.rrbbd.bidding.call;

import static j2html.TagCreator.td;
import static j2html.TagCreator.text;

import j2html.tags.DomContent;

class StringCall implements Call {
    private String call;
    private String forum;

    StringCall(String s, String f) {
        call = s;
        forum = f;
    }

    @Override
    public DomContent biddingHtml() {
        return td(call);
    }

    @Override
    public DomContent forumHtml() {
        return text(forum);
    }
}
