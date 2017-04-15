package com.starsep.rrbbd.bidding.call;

class DiamondsCall extends ContractCall {
    DiamondsCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/diamonds.gif";
    }

    @Override
    protected String forumColor() {
        return "d";
    }
}
