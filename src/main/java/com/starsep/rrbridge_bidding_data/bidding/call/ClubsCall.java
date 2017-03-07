package com.starsep.rrbridge_bidding_data.bidding.call;

class ClubsCall extends ContractCall {
    ClubsCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/clubs.gif";
    }
}
