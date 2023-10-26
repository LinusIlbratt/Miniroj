import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard; // gameBoard is a reference of the GameBoard class
    private Scanner scan;
    private Player player; // player is a reference of the Player class
    private String gameState;
    private String playerName; 

    public Game() {
        scan = new Scanner(System.in);
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs
      
        System.out.println("Enter your name: ");
        String playerName = scan.nextLine();
        this.player = new Player(playerName);

    }
}
