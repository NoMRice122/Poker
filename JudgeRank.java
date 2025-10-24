import java.util.ArrayList;
import java.util.Collections;

public class JudgeRank {
    private final Hand hand;
    private final Card[] cards;
    private String highJudge = "";

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
        if(isRF(hand)){return "RF";}    //RF
        if(isSF(hand)){return "SF" + hand.getSortStrInit();}    //SF9
        if(is4K(hand)){return "4K" + highJudge;}    //4K85
        if(isFH(hand)){return "FH" + highJudge;}    //FH97  //3枚組になっている数字が優先される
        if(isFL(hand)){return "FL" + hand.getSortStr();}    //FLT8642
        if(isST(hand)){return "ST" + highJudge;}    //ST9
        if(is3K(hand)){return "3K" + highJudge;}    //3KAKQ
        if(is2P(hand)){return "2P" + highJudge;}    //2P97
        if(is1P(hand)){return "1P" + get1Pcode(hand);}    //1PK962

        return "HC" + hand.getSortStr();    //HCT8642
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

    //ストレート(完成)
    public boolean isST(Hand hand){
        highJudge = "";
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
                highJudge += "5";

                return true;
            }
            //最強ストレートかどうか
            if(hand.contains(Rank.TEN)){
                if(!hand.contains(Rank.JACK)){return false;}
                if(!hand.contains(Rank.QUEEN)){return false;}
                if(!hand.contains(Rank.KING)){return false;}
                highJudge += "A";

                return true;
            }
        }

        //Aを含まないとき
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
            }
        }
        //最小値を基準にする
        int criterion = Collections.min(num);
        for(int i=1; i<5; i++){
            if(!num.contains(criterion + i)){return false;}
        }

        highJudge += hand.getSortStrInit();

        return true;
    }

    //フォーカード(完成)
    public boolean is4K(Hand hand){
        highJudge = "";
        //4枚組の数字があるか調べる
        //ハンドの2枚目まで調べて4枚組の数字がなかった場合フォーカードはありえないのでi<2にしている
        for(int i=0; i<2; i++){
            if(hand.count(cards[i].getRank()) == 4){
                highJudge += cards[i].getRank().getSymbol().toUpperCase();
                for(int j=0; j<5; j++){
                    if(cards[j].getRank() != cards[i].getRank()) {
                        highJudge += cards[j].getRank().getSymbol().toUpperCase();
                        break;
                    }
                }
                return true;
            }
        }        
        return false;
    }

    //フルハウス(完成)
    public boolean isFH(Hand hand){
        highJudge = "";
        //1枚目を基準にする
        Rank criterion = cards[0].getRank();
        //1枚目の数字がFHの2枚組の数字だった場合
        if(hand.count(criterion) == 2){
            String temp = criterion.getSymbol().toUpperCase();
            //3枚組の数字があるか検証する
            for(int i=1; i<5; i++){
                if(hand.count(cards[i].getRank()) == 3){
                    highJudge += cards[i].getRank().getSymbol().toUpperCase();
                    highJudge += temp;
                    return true;
                }
            }
        }
        //1枚目の数字がFHの3枚組の数字だった場合
        if(hand.count(criterion) == 3){
            highJudge += criterion.getSymbol().toUpperCase();
            //2枚組の数字があるか検証する
            for(int i=1; i<5; i++){
                if(hand.count(cards[i].getRank()) == 2){
                    highJudge += cards[i].getRank().getSymbol().toUpperCase();
                    return true;
                }
            }
        }
        return false;
    }

    //スリーカード(完成)
    public boolean is3K(Hand hand){
        highJudge = "";
        //3枚組の数字があるか調べる
        //ハンドの3枚目まで調べて3枚組の数字がなかった場合スリーカードはありえないのでi<3にしている
        for(int i=0; i<3; i++){
            if(hand.count(cards[i].getRank()) == 3){
                highJudge += cards[i].getRank().getSymbol().toUpperCase();

                ArrayList<Rank> list = new ArrayList<Rank>();
                for(int j=0; j<cards.length; j++){
                    if(cards[j].getRank() != cards[i].getRank()){
                        list.add(cards[j].getRank());
                    }
                }
                //3枚組以外の2つの数字を入れたリストから二つ取り出して大きさ比較して大きいほうからhighJudgeに入れていく
                highJudge += hand.inttoStr(Math.max(hand.strtoInt(list.get(0).getSymbol().toUpperCase()), hand.strtoInt(list.get(1).getSymbol().toUpperCase())));
                highJudge += hand.inttoStr(Math.min(hand.strtoInt(list.get(0).getSymbol().toUpperCase()), hand.strtoInt(list.get(1).getSymbol().toUpperCase())));
                return true;
            }
        }        
        return false;
    }

    //ツーペア(完成)
    public boolean is2P(Hand hand){
        highJudge = "";
        //ハンドを全て調べてhand.count() == 2が4回出ればツーペアになる
        //4回出るか数える変数
        int counter = 0;
        ArrayList<Rank> list = new ArrayList<Rank>();

        for(int i=0; i<5; i++){
            if(hand.count(cards[i].getRank()) == 2){
                if(!list.contains(cards[i].getRank())) list.add(cards[i].getRank());
                counter += 1;
            }
        }
        if(counter == 4){
            highJudge += hand.inttoStr(Math.max(hand.strtoInt(list.get(0).getSymbol().toUpperCase()), hand.strtoInt(list.get(1).getSymbol().toUpperCase())));
            highJudge += hand.inttoStr(Math.min(hand.strtoInt(list.get(0).getSymbol().toUpperCase()), hand.strtoInt(list.get(1).getSymbol().toUpperCase())));
            for(int i=0; i<5; i++){
                if(!list.contains(cards[i].getRank())) highJudge += cards[i].getRank().getSymbol().toUpperCase();
            }
            return true;
        }

        return false;
    }

    //ワンペア(完成)
    public boolean is1P(Hand hand){
        //ハンドの4枚目まで調べてペアがなかった場合ワンペアはありえないのでi<4にしている
        for(int i=0; i<4; i++){
            if(hand.count(cards[i].getRank()) == 2){
                return true;
            }
        } 
        return false;
    }

    public String get1Pcode(Hand hand){
        String ret = "";
        Rank pairRank = null;
        for(int i=0; i<5; i++){
            if(hand.count(cards[i].getRank()) == 2){
                pairRank = cards[i].getRank();
                ret += pairRank.getSymbol().toUpperCase();
                break;
            }
        }

        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<5; i++){
            //役に関係しないカードの場合
            if(cards[i].getRank() != pairRank){
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
        }

        Collections.sort(num, Collections.reverseOrder());
        for(int i=0; i<3; i++){
            ret += hand.inttoStr(num.get(i));
        }
        return ret;
    }
}