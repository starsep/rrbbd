package com.starsep.rrbbd.bidding;

import com.starsep.rrbbd.core.RoundDataEntry;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent set of biddings.
 */
public class BiddingSet {
    public static final String FILENAME = "bid_index.json";

    private List<Bidding> biddingList;

    public BiddingSet() {
        biddingList = new ArrayList<>();
    }

    /**
     * Add bid to bidding.
     * Add bidding if not yet added.
     * Else add bid to existing bidding.
     * @param bidding bidding where add bid
     * @param bid bid to add
     */
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

    /**
     * Save bidding to file.
     * @throws FileNotFoundException if filename is incorrect
     */
    public void save() throws FileNotFoundException {
        for (Bidding bidding : biddingList) {
            bidding.save();
        }
    }

    /**
     * Add round data to biddings.
     * @param roundData data
     * @throws Exception if there is no data for some round
     */
    public void applyRoundData(List<RoundDataEntry> roundData) throws Exception {
        for (Bidding bidding : biddingList) {
            for (RoundDataEntry roundDataEntry : roundData) {
                if (bidding.section == roundDataEntry.section
                        && bidding.table == roundDataEntry.table
                        && bidding.round == roundDataEntry.round) {
                    bidding.ns = roundDataEntry.ns;
                    bidding.ew = roundDataEntry.ew;
                    break;
                }
            }
            if (bidding.ns == -1 || bidding.ew == -1) {
                throw new Exception("RoundData missing!");
            }
        }
    }
}
