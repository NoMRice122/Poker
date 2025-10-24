import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Game{
    Scanner sc = new Scanner(System.in);
    Player player;
    Dealer dealer;
    CPU cpu;
    JudgeWinner judgeWinner;

    public void startGame(){
        player = new Player(1000);
        System.out.println("===== New Game =====");
        while(player.isAlive()){
            playRound();
        }
        endGame();

    }

    public void playRound(){
        dealer = new Dealer();
        cpu = new CPU();
        judgeWinner = new JudgeWinner();
        
        System.out.println("現在の所持金: " + player.getMoney());

        boolean invalidInput = true;
        while(invalidInput){
            System.out.print("ベットする金額を入力: ");
            int betAmount = sc.nextInt();
            sc.nextLine();
            //ベットする金額を所持金から引く
            player.decreaseMoney(betAmount);
            if(0 < betAmount && betAmount <= player.getMoney()){
                invalidInput = false;
            } else {
                System.out.println("不正な金額です。もう一度入力してください。");
            }
        }

        dealer.dealHand(cpu);
        dealer.dealHand(player);
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
        player.showHand();
        System.out.println("あなたの役: " + player.getHand().getRank());

        cpu.showHand();
        System.out.println("CPUの役: " + cpu.getHand().getRank());

        //勝敗判定の結果を表示してマネー関係の処理をする
        switch(judgeWinner.doJudge(player.getHand(), cpu.getHand())){
            //プレイヤーの勝利
            case 1: 
                System.out.println("プレイヤーの勝利！");
                break;
            //CPUの勝利
            case -1:
                System.out.println("CPUの勝利！");
                break;
            //引き分け
            case 0:
                System.out.println("引き分け！");
                break;
            case 999:
                System.out.println("エラー: Game.java:80");
                break;
        }
        
        


        
    }

    public void endGame(){

    }
}