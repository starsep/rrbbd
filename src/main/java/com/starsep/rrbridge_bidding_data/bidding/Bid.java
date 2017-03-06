package com.starsep.rrbridge_bidding_data.bidding;

public class Bid {
    public int id;
    public String bid;
    public char bidder;

    public Bid(int id, String bid, char bidder) {
        this.id = id;
        this.bid = bid;
        this.bidder = bidder;
    }
}
