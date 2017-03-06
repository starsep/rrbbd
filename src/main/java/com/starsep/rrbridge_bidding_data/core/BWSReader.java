package com.starsep.rrbridge_bidding_data.core;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

import java.io.File;
import java.io.IOException;

public class BWSReader {
    private final static String BIDDING_TABLE = "BiddingData";
    private final File bws;

    public BWSReader(File file) throws IOException {
        bws = file;
        Table table = DatabaseBuilder.open(bws).getTable(BIDDING_TABLE);
        for (Row row : table) {
            if (row.getShort("Board") == 1) {
                System.err.println(row);
            }
        }
    }
}
