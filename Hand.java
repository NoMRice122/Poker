public class Hand {
    private final Card[] cards = new Card[5];

    public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
        cards[0] = c1;
        cards[1] = c2;
        cards[2] = c3;
        cards[3] = c4;
        cards[4] = c5;
    }

    public Card[] getCards() { return cards; }

    // 役の判定はここから呼び出すイメージ
    public String getRank() {
        JudgeRank judge = new JudgeRank(this);
        return judge.doJudge();
    }
}