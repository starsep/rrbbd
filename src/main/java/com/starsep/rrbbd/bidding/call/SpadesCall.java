package com.starsep.rrbbd.bidding.call;

class SpadesCall extends ContractCall {
    SpadesCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/spades.gif";
    }

    @Override
    protected String forumColor() {
        return "s";
    }
}
