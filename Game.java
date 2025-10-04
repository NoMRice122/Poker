import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Game{
    Scanner sc = new Scanner(System.in);
    Player player;
    Dealer dealer;
    CPU cpu;

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
        
        System.out.println("現在の所持金: " + player.getMoney());

        boolean invalidInput = true;
        while(invalidInput){
            System.out.print("ベットする金額を入力: ");
            int betAmount = sc.nextInt();
            sc.nextLine();
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

        player.showHand();
        System.out.println("あなたの役: " + player.getHand().getRank());

        cpu.showHand();
        System.out.println("CPUの役: " + cpu.getHand().getRank());
        
        


        
    }

    public void endGame(){

    }
}