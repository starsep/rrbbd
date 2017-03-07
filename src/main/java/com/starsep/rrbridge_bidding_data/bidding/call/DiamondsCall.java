package com.starsep.rrbridge_bidding_data.bidding.call;

class DiamondsCall extends ContractCall {
    DiamondsCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/diamonds.gif";
    }
}
