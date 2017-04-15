package com.starsep.rrbbd.bidding.call;

class ClubsCall extends ContractCall {
    ClubsCall(int v) {
        super(v);
    }

    @Override
    protected String imgSrc() {
        return "img/clubs.gif";
    }

    @Override
    protected String forumColor() {
        return "c";
    }
}
