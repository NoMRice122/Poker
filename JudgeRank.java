public class JudgeRank {
    private final Hand hand;

    public JudgeRank(Hand hand) {
        this.hand = hand;
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
        if(isST(hand) && isFL(hand)){return "SF";}
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

    }

    //フラッシュ
    public boolean isFL(Hand hand){

    }

    //ストレート
    public boolean isST(Hand hand){

    }

    //フォーカード
    public boolean is4K(Hand hand){

    }

    //フルハウス
    public boolean isFH(Hand hand){

    }

    //スリーカード
    public boolean is3K(Hand hand){

    }

    //ツーペア
    public boolean is2P(Hand hand){

    }

    //ワンペア
    public boolean is1P(Hand hand){

    }
}