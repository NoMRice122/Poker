public class Player{
    private int money;
    private boolean alive;
    private Hand hand;

    public Player(int money){
        this.money = money;
        this.alive = true;
    }

    public int getMoney(){
        return this.money;
    }

    public Hand getHand(){
        return this.hand;
    }

    //バストしていなければtrue
    public boolean isAlive(){
        return this.alive;
    }

    //ハンドを設定する
    public void setHand(Hand hand){
        this.hand = hand;
    }

    //ベットした金額だけ所持金を減らす
    public void decreaseMoney(int betAmount){
        this.money -= betAmount;
    }

    //あなたの手札<<a b c d e>>などと表示する
    public void showHand(){
        String text = "";
        Card[] cards = hand.getCards();
        text += "あなたの手札<<";
        for(int i=0; i<5; i++){
            text += cards[i].toString();
            if(i != 4){
                text += " ";
            }
        }
        text += ">>";
        System.out.println(text);
    }

    //ハンドのi番目のカードをcardに差し替える
    public void setCard(int i, Card card){
        Card[] cards = hand.getCards();
        cards[i] = card;
        Hand hand = new Hand(
            cards[0],
            cards[1],
            cards[2],
            cards[3],
            cards[4]
        );
        setHand(hand);
    }
}