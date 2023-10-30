import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard; // gameBoard is a reference of the GameBoard class
    private Scanner scan;
    private Player player; // player is a reference of the Player class
    private String gameState;
    private GameTimer gameTimer;

    public Game() {
        scan = new Scanner(System.in);
        gameTimer = new GameTimer();
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs
        gameState = "RUNNING";

        this.player = new Player("Default name");

        while (true) {
            System.out.println("Enter your name: ");
            String playerName = scan.nextLine();
            this.player.setName(playerName);

            if (player.isValidName()) {
                System.out.println("Name of the player is: " + playerName);
                break;
            } else {
                System.out.println("This is not a valid name, please select another one.");
            }
        }
    }
    public void startGame() {
        System.out.println("welcome to minesweeper");
        gameBoard.generateBombs();
        gameTimer.startTime();

        while (gameState.equals("RUNNING")) {
            gameBoard.displayGameBoard();
            System.out.println(player.getName() + " enter your move (Exemple A5)");
            String safeMove = scan.nextLine().toUpperCase();

            // converting safeMove to row and col
            int row = safeMove.charAt(0) - 'A';
            int col = Integer.parseInt(safeMove.substring(1)) - 1;
            gameBoard.revealCell(row, col);


        }
        if (gameState.equals("Win")) {
            gameTimer.stopTime();
            System.out.println("You Won the game :star_struck: ");
            System.out.println("Elapsed Time: " + gameTimer.elapsedTime());
        } else if (gameState.equals("lost")) {
            gameTimer.stopTime();
            System.out.println("GAME OVER :cry:");
            System.out.println("Elapsed Time: " + gameTimer.elapsedTime());

        }
    }
    private void updateGameState(int row, int col) {
        Cell currentCell = gameBoard.getCell(row, col);

        // 1. Check if the player hit a bomb
        if (currentCell.getHasBomb()) {
            gameState = "LOST";
            return;
        }

        // 2. Check if all non-bomb cells have been revealed
        int totalCells = gameBoard.getBoardSize() * gameBoard.getBoardSize();
        int revealedCells = 0;
        for (int i = 0; i < gameBoard.getBoardSize(); i++) {
            for (int j = 0; j < gameBoard.getBoardSize(); j++) {
                if (gameBoard.getCell(i, j).isRevealed()) {
                    revealedCells++;
                }
            }
        }

        if (totalCells - revealedCells == gameBoard.getBombCount()) {
            gameState = "WON";
        }
    }

}
