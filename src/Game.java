import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard;
    private Scanner scan;
    private Player player;
    private String gameState; // ska utvecklas senare med metoden startGame() med olika souts och vid running (printBoard();), won (isWon) eller lost (revealAll)

    public Game() {
        scan = new Scanner(System.in);
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs


    }
}
