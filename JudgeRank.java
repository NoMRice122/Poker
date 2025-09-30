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

    //ロイヤルストレートフラッシュ
    public boolean isRF(Hand hand){

        return false;
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
        
        return false;
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