public class CPU{
    private Hand hand;

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public Hand getHand(){
        return this.hand;
    }

    //CPUの手札<<a b c d e>>などと表示する
    public void showHand(){
        String text = "";
        Card[] cards = hand.getCards();
        text += "CPUの手札<<";
        for(int i=0; i<5; i++){
            text += cards[i].toString();
            if(i != 4){
                text += " ";
            }
        }
        text += ">>";
        System.out.println(text);
    }

}