import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard;
    private Scanner scan;
    private Player player;
    private String gameState; // ska utvecklas senare med metoden startGame() med olika souts och vid running (printBoard();), won (isWon) eller lost (revealAll)
    private String playerName; // Namnet på spelare.

    public Game() {
        scan = new Scanner(System.in);
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs
        System.out.println("inter your naem ");
        String playerName = scan.nextLine();
        this.player = new Player(playerName);

    }
}
