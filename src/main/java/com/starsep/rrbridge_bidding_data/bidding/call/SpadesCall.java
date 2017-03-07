package com.starsep.rrbridge_bidding_data.bidding.call;

class SpadesCall extends ContractCall {
    SpadesCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/spades.gif";
    }
}
