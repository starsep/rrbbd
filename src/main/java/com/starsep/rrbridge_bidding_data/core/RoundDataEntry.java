package com.starsep.rrbridge_bidding_data.core;

public class RoundDataEntry {
    public final int section;
    public final int round;
    public final int table;
    public final int NS;
    public final int EW;

    public RoundDataEntry(int section, int round, int table, int NS, int EW) {
        this.section = section;
        this.round = round;
        this.table = table;
        this.NS = NS;
        this.EW = EW;
    }
}
