package com.starsep.rrbbd.bidding;

import static j2html.TagCreator.*;

import com.starsep.rrbbd.io.Saver;
import j2html.tags.DomContent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


/**
 * Bidding represent bridge bidding from single board.
 */
public class Bidding implements IHtml {
    public static final String BIDDING_PREFIX = "bid";
    public static final String FORUM_PREFIX = "forum";
    public static final String FILENAME_EXTENSION = ".biddingHtml";

    public int section;
    public int board;
    public int table;
    public int round;
    public int ns;
    public int ew;
    public List<Bid> bids;

    /**
     * Creates bidding from board info.
     * @param section number of section
     * @param board number of board played
     * @param table number of table
     * @param round number of round
     */
    public Bidding(int section, int board, int table, int round) {
        this.section = section;
        this.board = board;
        this.table = table;
        this.round = round;
        ns = -1;
        ew = -1;
        bids = new ArrayList<>();
    }

    private String filenameNS() {
        return BIDDING_PREFIX + "-" + board + "-" + ns + FILENAME_EXTENSION;
    }

    private String filenameEW() {
        return BIDDING_PREFIX + "-" + board + "-" + ew + FILENAME_EXTENSION;
    }

    private String filenameForumNS() {
        return FORUM_PREFIX + "-" + board + "-" + ns + FILENAME_EXTENSION;
    }

    private String filenameForumEW() {
        return FORUM_PREFIX + "-" + board + "-" + ew + FILENAME_EXTENSION;
    }

    public boolean sameBidding(Bidding bidding) {
        return board == bidding.board && table == bidding.table;
    }

    private void addEmptyCalls(ArrayList<DomContent> list, DomContent empty) {
        if (bids.size() > 0) {
            switch (bids.get(0).bidder) {
                case 'S':
                    list.add(empty);
                case 'E':
                    list.add(empty);
                case 'N':
                    list.add(empty);
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

    @Override
    public DomContent biddingHtml() {
        ArrayList<DomContent> rows = new ArrayList<>();
        ArrayList<DomContent> lastRow = new ArrayList<>();
        addEmptyCalls(lastRow, td());
        for (Bid bid : bids) {
            if (lastRow.size() >= 4) {
                rows.add(tr().with(lastRow));
                lastRow = new ArrayList<>();
            }
            lastRow.add(bid.biddingHtml());
        }
        if (!lastRow.isEmpty()) {
            rows.add(tr().with(lastRow));
        }
        DomContent header = tr().with(th("W"), th("N"), th("E"), th("S"));
        return table().with(header).with(rows);
    }

    @Override
    public DomContent forumHtml() {
        ArrayList<DomContent> content = new ArrayList<>();
        addEmptyCalls(content, text("!nic"));
        int size = content.size();
        for (Bid bid : bids) {
            content.add(bid.forumHtml());
            size++;
            if (size % 4 == 0) {
                content.add(br());
            }
        }
        DomContent header = text("!top");
        return code().with(header).with(br()).with(content);
    }


    /**
     * Saves bidding to files.
     * @throws FileNotFoundException if incorrect filename
     */
    public void save() throws FileNotFoundException {
        Saver.save(biddingHtml().toString(), filenameNS());
        Saver.save(biddingHtml().toString(), filenameEW());
        Saver.save(forumHtml().toString(), filenameForumEW());
        Saver.save(forumHtml().toString(), filenameForumNS());
    }
}
