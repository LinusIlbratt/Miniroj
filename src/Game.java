import java.util.Random;
import java.util.Scanner;

public class Game {
    private board GameBoard;
    private Scanner scan;

    private player;
    String gameState; // ska utvecklas senare med metoden startGame() med olika souts och vid running (printBoard();), won (isWon) eller lost (revealAll)

    public Game() {
        scan = new Scanner(System.in);
        GameBoard = new GameBoard(8, 8); // Om spelplanen skulle vara 8?


    }
}
