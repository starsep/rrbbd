package com.starsep.rrbridge_bidding_data.bidding;

import com.starsep.rrbridge_bidding_data.io.Saver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BiddingSet {
    public static final String FILENAME = "bid_index.json";

    private List<Bidding> biddingList;

    public BiddingSet() {
        biddingList = new ArrayList<>();
    }

    public String filename() {
        return FILENAME;
    }

    public void addBid(Bidding bidding, Bid bid) {
        for (Bidding b : biddingList) {
            if (b.sameBidding(bidding)) {
                b.bids.add(bid);
                return;
            }
        }
        bidding.bids.add(bid);
        biddingList.add(bidding);
    }

    private List<String> index() {
        List<String> result = new ArrayList<>();
        for (Bidding bidding : biddingList) {
            result.add(bidding.filename());
        }
        return result;
    }

    public void save() throws FileNotFoundException {
        for (Bidding bidding : biddingList) {
            bidding.save();
        }
    }
}
