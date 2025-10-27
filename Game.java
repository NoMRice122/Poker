import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Game{
    Scanner sc = new Scanner(System.in);
    Player player;
    Dealer dealer;
    CPU cpu;
    JudgeWinner judgeWinner;
    int betAmount;

    public void startGame(){
        player = new Player(1000);
        System.out.println("========== New Game ==========");
        while(player.isAlive()){
            playRound();
        }
        endGame();

    }

    public void playRound(){
        dealer = new Dealer();
        cpu = new CPU();
        judgeWinner = new JudgeWinner();
        betAmount = 0;
        
        System.out.println("現在の所持金: $" + player.getMoney());

        boolean invalidInput = true;
        while(invalidInput){
            System.out.print("ベットする金額を入力: ");
            betAmount = sc.nextInt();
            sc.nextLine();
            
            if(0 < betAmount && betAmount <= player.getMoney()){
                //ベットする金額を所持金から引く 
                player.decreaseMoney(betAmount);
                invalidInput = false;
            } else {
                System.out.println("不正な金額です。もう一度入力してください。");
            }
        }

        dealer.dealHand(cpu);
        dealer.dealHand(player);
        
        System.out.println("------------------------------");
        player.showHand();

        System.out.print("交換するカードを入力: ");
        String input = sc.nextLine();
        ArrayList<String> changeCards = new ArrayList<>(Arrays.asList(input.split(" ")));

        //交換するカードがある場合
        if(!changeCards.contains("")){
            for(int i=0; i<changeCards.size(); i++){
                dealer.swapCard(player, changeCards.get(i));
            }
        }

        //役を表示
        System.out.println("------------------------------");
        player.showHand();
        System.out.println("あなたの役: " + player.getHand().getRank());

        System.out.println("------------------------------");
        cpu.showHand();
        System.out.println("CPUの役: " + cpu.getHand().getRank());

        //勝敗判定の結果を表示してマネー関係の処理をする
        System.out.println("------------------------------");
        switch(judgeWinner.doJudge(player.getHand(), cpu.getHand())){
            //プレイヤーの勝利
            case 1: 
                System.out.println("プレイヤーの勝利！");

                //役に応じて払い戻し
                int tmp = calcRefund(betAmount);
                player.giveMoney(tmp);
                System.out.println("$" + tmp + "獲得！");

                System.out.println("==============================");
                break;
            //CPUの勝利
            case -1:
                System.out.println("CPUの勝利！");

                if(player.getMoney() == 0){
                    player.setAlive(false);                    
                    break;
                }

                System.out.println("==============================");
                break;
            //引き分け
            case 0:
                System.out.println("引き分け！");
                player.giveMoney(betAmount);
                System.out.println("賭け金が返ってきました！");

                System.out.println("==============================");
                break;
            case 999:
                System.out.println("エラー: Game.java:80");
                break;
        }
        


        
    }

    public void endGame(){
        System.out.println("プレイヤーは　賞金として　$0　支払った……");
        System.out.println("プレイヤーは　めのまえが　まっくらに　なった！");
    }

    //役に応じた払い戻し金を計算するメソッド
    //引数: 賭け金 ↑refund
    public int calcRefund(int betAmount){
        int ret = betAmount;
        switch(player.getHand().getRank().substring(0,2)){
            case "RF": ret *= 10000; break;
            case "SF": ret *= 300; break;
            case "4K": ret *= 100; break;
            case "FH": ret *= 75; break;
            case "FL": ret *= 50; break;
            case "ST": ret *= 35; break;
            case "3K": ret *= 25; break;
            case "2P": ret *= 10; break;
            case "1P": ret *= 5; break;
            case "HC": ret *= 2; break;
            default: System.out.println("不正な役名です");
        }
        return ret;
    }
}