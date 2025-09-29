public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() { return suit; }
    public Rank getRank() { return rank; }

    @Override
    public String toString() {
        return suit.getSymbol() + rank.getSymbol();
    }

    // 入力（例: "ha", "st"）からCardを生成
    public static Card fromString(String input) {
        if (input.length() < 2) {
            throw new IllegalArgumentException("Invalid card: " + input);
        }
        //saの場合s->suitPart、a->rankPartに入れる
        String suitPart = input.substring(0, 1);
        String rankPart = input.substring(1);
        return new Card(Suit.fromSymbol(suitPart), Rank.fromSymbol(rankPart));
    }
}