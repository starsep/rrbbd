package com.starsep.rrbbd.bidding.call;

public abstract class CallFactory {
    private static final String PASS = "PASS";
    private static final String DOUBLE = "X";
    private static final String REDOUBLE = "XX";

    private static final char CLUBS_CHAR = 'C';
    private static final char DIAMONDS_CHAR = 'D';
    private static final char HEARTS_CHAR = 'H';
    private static final char SPADES_CHAR = 'S';
    private static final char NO_TRUMP_CHAR = 'N';


    /**
     * Make call from database string.
     * @param s database call
     * @return Call object
     */
    public static Call create(String s) {
        switch (s) {
            case PASS:
                return new StringCall(s, "!pas");
            case DOUBLE:
                return new StringCall(s, "!x");
            case REDOUBLE:
                return new StringCall(s, "!xx");
        }
        if (s.length() >= 2 && Character.isDigit(s.charAt(0))) {
            int v = Character.getNumericValue(s.charAt(0));
            if (v >= 1 && v <= 7) {
                switch (Character.toUpperCase(s.charAt(1))) {
                    case CLUBS_CHAR:
                        return new ClubsCall(v);
                    case DIAMONDS_CHAR:
                        return new DiamondsCall(v);
                    case HEARTS_CHAR:
                        return new HeartsCall(v);
                    case SPADES_CHAR:
                        return new SpadesCall(v);
                    case NO_TRUMP_CHAR:
                        return new NoTrumpCall(v);
                }
            }
        }
        return new Invalid(s);
    }
}
