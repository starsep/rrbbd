package com.starsep.rrbbd.bidding;

import com.starsep.rrbbd.bidding.call.Call;
import com.starsep.rrbbd.bidding.call.CallFactory;
import j2html.tags.DomContent;

/**
 * Bid corresponds to single bid in bidding.
 */
public class Bid implements IHtml {
    public int id;
    public Call call;
    public char bidder;

    /**
     * Creates bid from id, bid and bidder.
     * @param id number of bid in bidding
     * @param bid from BWS
     * @param bidder letter of bidder
     */
    public Bid(int id, String bid, char bidder) {
        this.id = id;
        this.call = CallFactory.create(bid);
        this.bidder = bidder;
    }

    @Override
    public DomContent biddingHtml() {
        return call.biddingHtml();
    }

    @Override
    public DomContent forumHtml() {
        return call.forumHtml();
    }
}
