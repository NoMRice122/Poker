import java.util.Scanner;

public class Game{
    Scanner sc = new Scanner(System.in);
    Player player;
    Dealer dealer;

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
        System.out.println("現在の所持金: " + player.getMoney());

        boolean invalidInput = true;
        while(invalidInput){
            System.out.print("ベットする金額を入力: ");
            int betAmount = sc.nextInt();
            if(0 < betAmount && betAmount <= player.getMoney()){
                invalidInput = false;
            } else {
                System.out.println("不正な金額です。もう一度入力してください。");
            }
        }

        dealer.dealHand(player);
        player.showHand();

        System.out.print("交換するカードを入力: ");
        
    }

    public void endGame(){

    }
}