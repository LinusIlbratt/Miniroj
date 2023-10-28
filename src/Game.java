import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard; // gameBoard is a reference of the GameBoard class
    private String gameState;
    private Scanner scan;
    private Player player; // player is a reference of the Player class

    private String playerName;

    public Game() {
        scan = new Scanner(System.in);
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs
        gameState = "RUNNING";
        System.out.println("Enter your name: ");
        String playerName = scan.nextLine();
        this.player = new Player(playerName);

    }
    public void startGame() {
        System.out.println("welcome to minesweeper");
        gameBoard.generateBombs();
        while (gameState.equals("RUNNING")) {
            gameBoard.displayGameBoard();
            System.out.println(player.getName() + " enter your move (Exemple A5)");
            String safeMove = scan.nextLine().toUpperCase();

            // converting safeMove to row and col
            int rowRad = safeMove.charAt(0) - 'A';
            int colKol = Integer.parseInt(safeMove.substring(1)) - 1;
            gameBoard.revealCell(rowRad, colKol);
            updateGameState(rowRad,colKol);


        }
        if (gameState.equals("LOST")){
            System.out.println( player.getName() + ": Game over");
            gameBoard.displayGameBoard();
        } else if (gameState.equals("WON")) {
            System.out.println( player.getName() + ": YOU WON THE GAME");
            gameBoard.displayGameBoard();
        }

    }
    private void updateGameState(int row, int col) {
        Cell currentCell = gameBoard.getCell(row, col);

        // 1. Check if the player hit a bomb
        if (currentCell.hasBomb()) {
            gameState = "LOST";
            currentCell.setRevealed(true);
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
