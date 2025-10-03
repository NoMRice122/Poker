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

    public boolean isAlive(){
        return this.alive;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void showHand(){
        String text = "";
        Card[] cards = hand.getCards();
        text += "<<";
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