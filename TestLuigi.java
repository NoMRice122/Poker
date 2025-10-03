import java.util.Scanner;

/*

現在の所持金: $ooo
ベットする金額を入力: xxx

あなたの手札<<hoge1 hoge2 hoge3 hoge4 hoge5>>
交換するカードを入力: hoge4 hoge5

あなたの手札<<hoge1 hoge2 hoge3 hoge6 hoge7>>
役: HOGE

CPUの手札<<hoge hoge hoge hoge hoge>>
役: HOGE

(あなた/CPU)の勝利
$ooo獲得！


↑を目指す
必要そうなクラス
Dealer: ランダムなカードを重複なくdeal
JudgeWinner: 役の強さの判定。JudgeRankを改造して同じ役でも勝敗を決められるようにする必要あり
player: 所持金の管理、バストしていないかの管理など

*/
public class TestLuigi{
    public static void main(String[] args){
        Game game = new Game();
        game.startGame();
    }
}