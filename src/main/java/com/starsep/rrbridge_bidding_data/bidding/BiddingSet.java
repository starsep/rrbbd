package com.starsep.rrbridge_bidding_data.bidding;

import com.starsep.rrbridge_bidding_data.core.RoundDataEntry;
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

    public void save() throws FileNotFoundException {
        for (Bidding bidding : biddingList) {
            bidding.save();
        }
    }

    public void applyRoundData(List<RoundDataEntry> roundData) throws Exception {
        for (Bidding bidding : biddingList) {
            for (RoundDataEntry roundDataEntry : roundData) {
                if (bidding.section == roundDataEntry.section &&
                        bidding.table == roundDataEntry.table &&
                        bidding.round == roundDataEntry.round) {
                    bidding.NS = roundDataEntry.NS;
                    bidding.EW = roundDataEntry.EW;
                    break;
                }
            }
            if (bidding.NS == -1 || bidding.EW == -1) {
                throw new Exception("RoundData missing!");
            }
        }
    }
}
