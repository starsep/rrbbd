package com.starsep.rrbbd.core;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import com.starsep.rrbbd.bidding.Bid;
import com.starsep.rrbbd.bidding.Bidding;
import com.starsep.rrbbd.bidding.BiddingSet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BWSReader {
    private static final String BIDDING_TABLE = "BiddingData";
    private static final String ROUND_TABLE = "RoundData";
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
            int ns = row.getShort("NSPair");
            int ew = row.getShort("EWPair");
            result.add(new RoundDataEntry(section, round, table, ns, ew));
        }
        return result;
    }

    /**
     * Create BiddingSet.
     * @return BiddingSet
     * @throws Exception on BWS file opening failure or round data missing
     */
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

    /**
     * Transform row to bid.
     * @param row one entry in database
     * @return Bid corresponding to given row
     */
    public Bid bidFromRow(Row row) {
        int id = row.getShort("Counter");
        String bid = row.getString("Bid");
        char bidder = row.getString("Direction").charAt(0);
        return new Bid(id, bid, bidder);
    }

    /**
     * Transform row to bidding.
     * @param row one entry in database
     * @return Empty bidding from row
     */
    public Bidding biddingFromRow(Row row) {
        int section = row.getShort("Section");
        int board = row.getShort("Board");
        int table = row.getShort("Table");
        int round = row.getShort("Round");
        return new Bidding(section, board, table, round);
    }
}
