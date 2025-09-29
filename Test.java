import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("トランプのカードを5つ入力: ");
        String card1 = sc.next();
        String card2 = sc.next();
        String card3 = sc.next();
        String card4 = sc.next();
        String card5 = sc.next();

        Hand hand = new Hand(
            Card.fromString(card1),
            Card.fromString(card2),
            Card.fromString(card3),
            Card.fromString(card4),
            Card.fromString(card5)
        );

        System.out.println("役: " + hand.getRank());

        sc.close();
    }
}