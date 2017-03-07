package com.starsep.rrbridge_bidding_data.bidding.call;

import j2html.tags.DomContent;

import static j2html.TagCreator.img;
import static j2html.TagCreator.td;

abstract class ContractCall implements Call {
    private final int value;

    ContractCall(int v) {
        value = v;
    }

    @Override
    public DomContent html() {
        return td(String.valueOf(value) + " ").with(img().withSrc(imgSrc()));
    }

    protected abstract String imgSrc();
}
