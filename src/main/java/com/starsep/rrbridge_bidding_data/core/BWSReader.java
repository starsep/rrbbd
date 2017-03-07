package com.starsep.rrbridge_bidding_data.core;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.starsep.rrbridge_bidding_data.bidding.Bid;
import com.starsep.rrbridge_bidding_data.bidding.Bidding;
import com.starsep.rrbridge_bidding_data.bidding.BiddingSet;

import java.io.File;
import java.io.IOException;

public class BWSReader {
    private final static String BIDDING_TABLE = "BiddingData";
    private final File bws;

    public BWSReader(File file) throws IOException {
        bws = file;
    }

    public BiddingSet getBiddingSet() throws IOException {
        BiddingSet result = new BiddingSet();
        Table table = DatabaseBuilder.open(bws).getTable(BIDDING_TABLE);
        for (Row row : table) {
            Bid bid = bidFromRow(row);
            Bidding bidding = biddingFromRow(row);
            result.addBid(bidding, bid);
        }
        return result;
    }

    public Bid bidFromRow(Row row) {
        int id = row.getShort("Counter");
        String bid = row.getString("Bid");
        char bidder= row.getString("Direction").charAt(0);
        return new Bid(id, bid, bidder);
    }

    public Bidding biddingFromRow(Row row) {
        int board = row.getShort("Board");
        int table = row.getShort("Table");
        return new Bidding(board, table);
    }
}
