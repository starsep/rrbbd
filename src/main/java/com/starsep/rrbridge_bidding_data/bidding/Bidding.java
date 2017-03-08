package com.starsep.rrbridge_bidding_data.bidding;

import com.starsep.rrbridge_bidding_data.io.Saver;
import j2html.tags.DomContent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


import static j2html.TagCreator.*;

public class Bidding {
    public static final String FILENAME_PREFIX = "bid";
    public static final String FILENAME_EXTENSION = ".html";

    public int section;
    public int board;
    public int table;
    public int round;
    public int NS;
    public int EW;
    public List<Bid> bids;

    public Bidding(int section, int board, int table, int round) {
        this.section = section;
        this.board = board;
        this.table = table;
        this.round = round;
        NS = -1;
        EW = -1;
        bids = new ArrayList<>();
    }

    private String filenameNS() {
        return FILENAME_PREFIX + "-" + board +  "-" + NS + FILENAME_EXTENSION;
    }

    private String filenameEW() {
        return FILENAME_PREFIX + "-" + board +  "-" + EW + FILENAME_EXTENSION;
    }

    public boolean sameBidding(Bidding bidding) {
        return board == bidding.board && table == bidding.table;
    }

    private void addEmptyCalls(ArrayList<DomContent> list) {
        if (bids.size() > 0) {
            switch (bids.get(0).bidder) {
                case 'S':
                    list.add(td());
                case 'E':
                    list.add(td());
                case 'N':
                    list.add(td());
                case 'W':
                    break;
                default:
                    try {
                        throw new Exception("Invalid bidder!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public DomContent html() {
        ArrayList<DomContent> rows = new ArrayList<>();
        ArrayList<DomContent> lastRow = new ArrayList<>();
        addEmptyCalls(lastRow);
        for (Bid bid : bids) {
            if (lastRow.size() >= 4) {
                rows.add(tr().with(lastRow));
                lastRow = new ArrayList<>();
            }
            lastRow.add(bid.html());
        }
        if (!lastRow.isEmpty()) {
            rows.add(tr().with(lastRow));
        }
        return table().with(tr().with(th("W"), th("N"), th("E"), th("S"))).with(rows);
    }



    public void save() throws FileNotFoundException {
        Saver.save(html().toString(), filenameNS());
        Saver.save(html().toString(), filenameEW());
    }
}
