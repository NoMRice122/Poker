public class TestJudgeRank {
    public static void main(String[] args) {
        Hand hand;

        /*
         * コピー用
         * 

        System.out.println("のテスト<<>>");
        hand = new Hand(
            Card.fromString(""),
            Card.fromString(""),
            Card.fromString(""),
            Card.fromString(""),
            Card.fromString("")
        );
        System.out.println("期待値: ");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

         */

        //ロイヤルストレートフラッシュ
        System.out.println("ロイヤルストレートフラッシュのテスト<<sa sk sq sj st>>");
        hand = new Hand(
            Card.fromString("sa"),
            Card.fromString("sk"),
            Card.fromString("sq"),
            Card.fromString("sj"),
            Card.fromString("st")
        );
        System.out.println("期待値: RF");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("RF")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //ストレートフラッシュ
        System.out.println("ストレートフラッシュのテスト<<s5 s6 s7 s8 s9>>");
        hand = new Hand(
            Card.fromString("s5"),
            Card.fromString("s6"),
            Card.fromString("s7"),
            Card.fromString("s8"),
            Card.fromString("s9")
        );
        System.out.println("期待値: SF");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("SF")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //フォーカード
        System.out.println("フォーカードのテスト<<ck sk hk dk c5>>");
        hand = new Hand(
            Card.fromString("ck"),
            Card.fromString("sk"),
            Card.fromString("hk"),
            Card.fromString("dk"),
            Card.fromString("c5")
        );
        System.out.println("期待値: 4K");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("4K")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //フルハウス
        System.out.println("フルハウスのテスト<<s8 c8 h8 d5 s5>>");
        hand = new Hand(
            Card.fromString("s8"),
            Card.fromString("c8"),
            Card.fromString("h8"),
            Card.fromString("d5"),
            Card.fromString("s5")
        );
        System.out.println("期待値: FH");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("FH")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //フラッシュ
        System.out.println("フラッシュのテスト<<c2 c4 c6 c8 ct>>");
        hand = new Hand(
            Card.fromString("c2"),
            Card.fromString("c4"),
            Card.fromString("c6"),
            Card.fromString("c8"),
            Card.fromString("ct")
        );
        System.out.println("期待値: FL");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("FL")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //ストレート
        System.out.println("ストレートのテスト<<s5 c6 h7 d8 s9>>");
        hand = new Hand(
            Card.fromString("s5"),
            Card.fromString("c6"),
            Card.fromString("h7"),
            Card.fromString("d8"),
            Card.fromString("s9")
        );
        System.out.println("期待値: ST");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("ST")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //Aを含むストレート
        System.out.println("Aを含むストレートのテスト<<ca c2 c4 c6 c8>>");
        hand = new Hand(
            Card.fromString("ca"),
            Card.fromString("c2"),
            Card.fromString("c4"),
            Card.fromString("c6"),
            Card.fromString("c8")
        );
        System.out.println("期待値: FL");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("FL")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //スリーカード
        System.out.println("スリーカードのテスト<<sk ck hk d3 c8>>");
        hand = new Hand(
            Card.fromString("sk"),
            Card.fromString("ck"),
            Card.fromString("hk"),
            Card.fromString("d3"),
            Card.fromString("c8")
        );
        System.out.println("期待値: 3K");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("3K")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //ツーペア
        System.out.println("ツーペアのテスト<<sk ck h9 d9 s5>>");
        hand = new Hand(
            Card.fromString("sk"),
            Card.fromString("ck"),
            Card.fromString("h9"),
            Card.fromString("d9"),
            Card.fromString("s5")
        );
        System.out.println("期待値: 2P");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("2P")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //ワンペア
        System.out.println("ワンペアのテスト<<c9 s9 h8 d7 c2>>");
        hand = new Hand(
            Card.fromString("c9"),
            Card.fromString("s9"),
            Card.fromString("h8"),
            Card.fromString("d7"),
            Card.fromString("c2")
        );
        System.out.println("期待値: 1P");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("1P")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }

        //ノーペア
        System.out.println("ノーペアのテスト<<c2 s4 h6 d8 ct>>");
        hand = new Hand(
            Card.fromString("c2"),
            Card.fromString("s4"),
            Card.fromString("h6"),
            Card.fromString("d8"),
            Card.fromString("ct")
        );
        System.out.println("期待値: HC");
        System.out.println("検出値: " + hand.getRank());
        if(hand.getRank().equals("HC")){
            System.out.println("結果:o");
        }else{
            System.out.println("結果:x");
        }







    }
}