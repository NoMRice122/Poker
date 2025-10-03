//一度dealしたカードは2度とdealしないようにしたい
public class Dealer{
    public void dealHand(Player player){
        Hand hand = new Hand(
            Card.fromString("ca"),
            Card.fromString("ck"),
            Card.fromString("cq"),
            Card.fromString("cj"),
            Card.fromString("ct")
        );
        player.setHand(hand);
    }
}