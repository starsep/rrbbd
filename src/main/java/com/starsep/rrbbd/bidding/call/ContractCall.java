package com.starsep.rrbbd.bidding.call;

import static j2html.TagCreator.img;
import static j2html.TagCreator.td;
import static j2html.TagCreator.text;

import j2html.tags.DomContent;

abstract class ContractCall implements Call {
    private final int value;

    ContractCall(int v) {
        value = v;
    }

    @Override
    public DomContent biddingHtml() {
        return td(String.valueOf(value) + " ").with(img().withSrc(imgSrc()));
    }

    @Override
    public DomContent forumHtml() {
        return text("!" + String.valueOf(value) + forumColor());
    }

    protected abstract String imgSrc();

    protected abstract String forumColor();
}
