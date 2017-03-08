package com.starsep.rrbridge_bidding_data.core;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.starsep.rrbridge_bidding_data.bidding.Bid;
import com.starsep.rrbridge_bidding_data.bidding.Bidding;
import com.starsep.rrbridge_bidding_data.bidding.BiddingSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BWSReader {
    private final static String BIDDING_TABLE = "BiddingData";
    private final static String ROUND_TABLE = "RoundData";
    private final File bws;

    public BWSReader(File file) throws IOException {
        bws = file;
    }

    private List<RoundDataEntry> roundDataEntryList(Database database) throws IOException {
        List<RoundDataEntry> result = new ArrayList<>();
        Table roundDataTable = database.getTable(ROUND_TABLE);
        for (Row row : roundDataTable) {
            int section = row.getShort("Section");
            int round = row.getShort("Round");
            int table = row.getShort("Table");
            int NS = row.getShort("NSPair");
            int EW = row.getShort("EWPair");
            result.add(new RoundDataEntry(section, round, table, NS, EW));
        }
        return result;
    }

    public BiddingSet getBiddingSet() throws Exception {
        BiddingSet result = new BiddingSet();
        Database database = DatabaseBuilder.open(bws);
        List<RoundDataEntry> roundData = roundDataEntryList(database);
        Table biddingTable = database.getTable(BIDDING_TABLE);
        for (Row row : biddingTable) {
            Bid bid = bidFromRow(row);
            Bidding bidding = biddingFromRow(row);
            result.addBid(bidding, bid);
        }
        result.applyRoundData(roundData);
        return result;
    }

    public Bid bidFromRow(Row row) {
        int id = row.getShort("Counter");
        String bid = row.getString("Bid");
        char bidder= row.getString("Direction").charAt(0);
        return new Bid(id, bid, bidder);
    }

    public Bidding biddingFromRow(Row row) {
        int section = row.getShort("Section");
        int board = row.getShort("Board");
        int table = row.getShort("Table");
        int round = row.getShort("Round");
        return new Bidding(section, board, table, round);
    }
}
