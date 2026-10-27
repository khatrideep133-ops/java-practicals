import java.util.Random;
import java.util.Scanner;

public class RPSLS {
    enum Move { ROCK, PAPER, SCISSORS, LIZARD, SPOCK }

    static int winner(Move a, Move b) {
        if (a == b) return 0;

        return switch (a) {
            case SCISSORS -> (b == Move.PAPER || b == Move.LIZARD) ? 1 : -1;
            case PAPER -> (b == Move.ROCK || b == Move.SPOCK) ? 1 : -1;
            case ROCK -> (b == Move.LIZARD || b == Move.SCISSORS) ? 1 : -1;
            case LIZARD -> (b == Move.SPOCK || b == Move.PAPER) ? 1 : -1;
            case SPOCK -> (b == Move.SCISSORS || b == Move.ROCK) ? 1 : -1;
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int you = 0, computer = 0;

        for (int round = 1; round <= 5; round++) {
            System.out.print("Enter ROCK/PAPER/SCISSORS/LIZARD/SPOCK: ");
            Move player = Move.valueOf(sc.next().toUpperCase());
            Move cpu = Move.values()[random.nextInt(Move.values().length)];

            int result = winner(player, cpu);
            System.out.println("You: " + player + "  Computer: " + cpu);

            if (result == 1) { you++; System.out.println("You win this round"); }
            else if (result == -1) { computer++; System.out.println("Computer wins this round"); }
            else System.out.println("Tie");
        }

        System.out.println("Final Score: You " + you + " - " + computer + " Computer");
        if (you > computer) System.out.println("You win!");
        else if (computer > you) System.out.println("Computer wins!");
        else System.out.println("Overall tie!");
    }
}
