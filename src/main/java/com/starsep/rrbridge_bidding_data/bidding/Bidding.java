package com.starsep.rrbridge_bidding_data.bidding;

import com.starsep.rrbridge_bidding_data.io.Saver;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bidding {
    public static final String FILENAME_PREFIX = "bid";
    public static final String FILENAME_EXTENSION = ".json";

    public int board;
    public int table;
    public List<Bid> bids;

    public Bidding(int board, int table) {
        this.board = board;
        this.table = table;
        bids = new ArrayList<>();
    }

    public String filename() {
        return FILENAME_PREFIX + "-" + board +  "-" + table + FILENAME_EXTENSION;
    }

    public boolean sameBidding(Bidding bidding) {
        return board == bidding.board && table == bidding.table;
    }

    public void save() throws FileNotFoundException {
        Saver.save(toString(), filename());
    }
}
