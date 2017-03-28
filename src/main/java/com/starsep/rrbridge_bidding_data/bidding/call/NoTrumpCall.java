package com.starsep.rrbridge_bidding_data.bidding.call;

class NoTrumpCall extends ContractCall {
    NoTrumpCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/notrump.gif";
    }

    @Override
    protected String forumColor() {
        return "nt";
    }
}
