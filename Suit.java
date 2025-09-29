enum Suit {
    SPADES("s"), HEARTS("h"), CLUBS("c"), DIAMONDS("d");
    private final String symbol;

    Suit(String symbol) { this.symbol = symbol; }
    public String getSymbol() { return symbol; }

    // 文字列からSuitを取得するための補助
    public static Suit fromSymbol(String s) {
        for (Suit suit : values()) {
            if (suit.symbol.equals(s)) return suit;
        }
        throw new IllegalArgumentException("Unknown suit: " + s);
    }
}