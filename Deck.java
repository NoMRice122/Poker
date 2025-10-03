import java.util.ArrayList;
import java.util.Collections;


public class Deck{
    ArrayList<Card> cardList = new ArrayList<>();

    public Deck(/*ArrayList<Card> cardList*/){
        String scdhStr = "scdh";
        String rankStr = "a23456789tjqk";
        for(int i=0; i<4; i++){
            String scdh = scdhStr.substring(i, i+1);
            for(int j=0; j<13; j++){
                String res = "";
                String rank = rankStr.substring(j, j+1);
                res += scdh;
                res += rank;
                
                cardList.add(Card.fromString(res));

            }
        }
        Collections.shuffle(cardList);
        this.cardList = cardList;
    }

    public Card draw(){
        return cardList.remove(0);
    }

}