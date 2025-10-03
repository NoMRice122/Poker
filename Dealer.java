import java .util.Objects;
//一度dealしたカードは2度とdealしないようにしたい
public class Dealer{
    Deck deck;

    public Dealer(){
        this.deck = new Deck();
    }

    public void dealHand(Player player){
        Hand hand = new Hand(
            //ランダムに配れるようにする予定
            deck.draw(),
            deck.draw(),
            deck.draw(),
            deck.draw(),
            deck.draw()
        );
        player.setHand(hand);
    }

    public void swapCard(Player player, String symbol){
        Card[] cards = player.getHand().getCards();
        Card target = Card.fromString(symbol);
        for(int i=0; i<5; i++){
            if(Objects.equals(target, cards[i])){//この比較がうまくいってないぽい 
                player.setCard(i, deck.draw());
                break;
            }
            if(i == 4){System.out.println("エラー");}
        }
    }
}