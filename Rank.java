enum Rank {
    TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
    SEVEN("7"), EIGHT("8"), NINE("9"), TEN("t"),
    JACK("j"), QUEEN("q"), KING("k"), ACE("a");

    private final String symbol;

    Rank(String symbol) { this.symbol = symbol; }
    public String getSymbol() { return symbol; }

    public static Rank fromSymbol(String s) {
        for (Rank rank : values()) {
            if (rank.symbol.equals(s)) return rank;
        }
        throw new IllegalArgumentException("Unknown rank: " + s);
    }
}