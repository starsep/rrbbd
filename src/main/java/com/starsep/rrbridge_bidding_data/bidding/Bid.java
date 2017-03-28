package com.starsep.rrbridge_bidding_data.bidding;

import com.starsep.rrbridge_bidding_data.bidding.call.Call;
import com.starsep.rrbridge_bidding_data.bidding.call.CallFactory;
import j2html.tags.DomContent;

public class Bid implements IHtml {
    public int id;
    public Call call;
    public char bidder;

    public Bid(int id, String bid, char bidder) {
        this.id = id;
        this.call = CallFactory.create(bid);
        this.bidder = bidder;
    }

    @Override
    public DomContent html() {
        return call.html();
    }

    @Override
    public DomContent forumHtml() {
        return call.forumHtml();
    }
}
