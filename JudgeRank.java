import java.util.ArrayList;
import java.util.Collections;

public class JudgeRank {
    private final Hand hand;
    private final Card[] cards;

    public JudgeRank(Hand hand) {
        this.hand = hand;
        this.cards = hand.getCards();
    }

    /*
     * 方針
     * 
     * 強い役から順に成立するか検証し、成立する場合returnで役を確定する。
     * 最後まで成立しない場合ノーペアとする。
     */
    public String doJudge() {
        // TODO: 役判定ロジックを実装
        if(isRF(hand)){return "RF";}
        if(isSF(hand)){return "SF";}
        if(is4K(hand)){return "4K";}
        if(isFH(hand)){return "FH";}
        if(isFL(hand)){return "FL";}
        if(isST(hand)){return "ST";}
        if(is3K(hand)){return "3K";}
        if(is2P(hand)){return "2P";}
        if(is1P(hand)){return "1P";}

        return "HC";
    }


    //役判定に必要な条件

    //ロイヤルストレートフラッシュ(完成)
    public boolean isRF(Hand hand){
        //フラッシュが成立しないならfalseを返す
        if(!isFL(hand)){return false;}
        //A~Tが含まれていないならfalseを返す
        if(!hand.contains(Rank.ACE)){return false;}
        if(!hand.contains(Rank.KING)){return false;}
        if(!hand.contains(Rank.QUEEN)){return false;}
        if(!hand.contains(Rank.JACK)){return false;}
        if(!hand.contains(Rank.TEN)){return false;}

        return true;
    }

    //ストレートフラッシュ(完成)
    public boolean isSF(Hand hand){
        if(isST(hand) && isFL(hand)){
            return true;
        }
        return false;
    }

    //フラッシュ(完成)
    public boolean isFL(Hand hand){
        //1つ目のカードのスートを基準にして、他のカードも同じか検証する
        Suit criterion = cards[0].getSuit();
        for(int i=1; i<cards.length; i++){
            if(cards[i].getSuit() != criterion){
                return false;
            }
        }
        return true;
    }

    //ストレート
    public boolean isST(Hand hand){
        //Aが含まれているかどうかで動作を変える
        //Aが含まれている場合:
        //Aが含まれるストレートはA2345 or TJQKAの2種類だけだから
        //地道に各カードが含まれるか調べる
        //
        //Aが含まれていない場合:
        //カードの数字をintとして取り出し
        //連続しているか検証する

        //Aを含むかどうか
        if(hand.contains(Rank.ACE)){
            //最弱ストレートかどうか
            if(hand.contains(Rank.TWO)){
                if(!hand.contains(Rank.THREE)){return false;}
                if(!hand.contains(Rank.FOUR)){return false;}
                if(!hand.contains(Rank.FIVE)){return false;}

                return true;
            }
            //最強ストレートかどうか
            if(hand.contains(Rank.TEN)){
                if(!hand.contains(Rank.JACK)){return false;}
                if(!hand.contains(Rank.QUEEN)){return false;}
                if(!hand.contains(Rank.KING)){return false;}

                return true;
            }
        }

        //Aを含まないとき
        //ArrayListに数字をRank型からInteger型にして入れる
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < cards.length; i++) {
            switch (cards[i].getRank()) {//もしかしたらエラー出るかも
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
            }
        }
        //最小値を基準にする
        int criterion = Collections.min(num);
        for(int i=1; i<5; i++){
            if(!num.contains(criterion + i)){return false;}
        }

        return true;
    }

    //フォーカード
    public boolean is4K(Hand hand){

        return false;
    }

    //フルハウス
    public boolean isFH(Hand hand){

        return false;
    }

    //スリーカード
    public boolean is3K(Hand hand){

        return false;
    }

    //ツーペア
    public boolean is2P(Hand hand){

        return false;
    }

    //ワンペア
    public boolean is1P(Hand hand){

        return false;
    }
}