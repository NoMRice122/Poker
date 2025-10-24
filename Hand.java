import java.util.ArrayList;
import java.util.Collections;

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

    //指定した数字がハンドに含まれるか調べるメソッド
    public boolean contains(Rank rank){
        for(int i=0; i<getCards().length; i++){
            if(cards[i].getRank() == rank){
                return true;
            }
        }
        return false;
    }

    //指定した数字がハンドに何枚含まれるか調べるメソッド
    public int count(Rank rank){
        int ret=0;
        for(int i=0; i<getCards().length; i++){
            if(rank == cards[i].getRank()){
                ret += 1;
            }
        }
        return ret;
    }

    // 役の判定はここから呼び出すイメージ
    public String getRank() {
        JudgeRank judge = new JudgeRank(this);
        return judge.doJudge();
    }

    public ArrayList<Integer> sort(){
        //ArrayListに数字をRank型からInteger型にして入れる
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < cards.length; i++) {
            switch (cards[i].getRank()) {
                case TWO:   num.add(2); break;
                case THREE: num.add(3); break;
                case FOUR:  num.add(4); break;
                case FIVE:  num.add(5); break;
                case SIX:   num.add(6); break;
                case SEVEN: num.add(7); break;
                case EIGHT: num.add(8); break;
                case NINE:  num.add(9); break;
                case TEN:   num.add(10); break;
                case JACK:  num.add(11); break;
                case QUEEN: num.add(12); break;
                case KING:  num.add(13); break;
                case ACE:   num.add(14); break;
            }
        }
        Collections.sort(num, Collections.reverseOrder());

        return num;
    }

    public String inttoStr(int num){
        if(num==2) return "2";
        if(num==3) return "3";
        if(num==4) return "4";
        if(num==5) return "5";
        if(num==6) return "6";
        if(num==7) return "7";
        if(num==8) return "8";
        if(num==9) return "9";
        if(num==10) return "T";
        if(num==11) return "J";
        if(num==12) return "Q";
        if(num==13) return "K";
        if(num==14) return "A";
        else {
            return "404 not found";
        }
    }

    public int strtoInt(String str){
        if(str.equals("2")) return 2;
        if(str.equals("3")) return 3;
        if(str.equals("4")) return 4;
        if(str.equals("5")) return 5;
        if(str.equals("6")) return 6;
        if(str.equals("7")) return 7;
        if(str.equals("8")) return 8;
        if(str.equals("9")) return 9;
        if(str.equals("T")) return 10;
        if(str.equals("J")) return 11;
        if(str.equals("Q")) return 12;
        if(str.equals("K")) return 13;
        if(str.equals("A")) return 14;
        
        else {
            System.out.println("404 not found");
            return 4545;
        }
    }

    public String getSortStr(){
        String ret = "";

        ArrayList<Integer> sortList = sort();

        for(int i=0; i<sortList.size(); i++){
            ret += inttoStr(sortList.get(i).intValue());
        }

        return ret;
    }

    public String getSortStrInit(){
        return getSortStr().substring(0,1);
    }

}