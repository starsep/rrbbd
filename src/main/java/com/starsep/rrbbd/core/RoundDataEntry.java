package com.starsep.rrbbd.core;

public class RoundDataEntry {
    public final int section;
    public final int round;
    public final int table;
    public final int ns;
    public final int ew;

    /**
     * Create RoundDataEntry.
     * @param section number of section
     * @param round number of round
     * @param table number of table
     * @param ns number of ns pair
     * @param ew number of ew pair
     */
    public RoundDataEntry(int section, int round, int table, int ns, int ew) {
        this.section = section;
        this.round = round;
        this.table = table;
        this.ns = ns;
        this.ew = ew;
    }
}
