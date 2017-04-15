package com.starsep.rrbbd.bidding.call;

class HeartsCall extends ContractCall {
    HeartsCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/hearts.gif";
    }

    @Override
    protected String forumColor() {
        return "h";
    }
}
