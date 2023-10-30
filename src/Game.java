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
        System.out.println("Welcome to Minesweeper!");
        String gameReset = "yes";

        while (gameReset.equalsIgnoreCase("yes")) {
            gameBoard.resetBoard();
            gameBoard.generateBombs();
            gameState = "RUNNING";

            gameLoop(); // Run the game loop

            System.out.println("Do you want to play again? (Yes/No)");
            gameReset = scan.nextLine().toLowerCase();
        }
    }
    private void gameLoop() {
        while (gameState.equals("RUNNING")) {
            gameBoard.displayGameBoard();
            System.out.println(player.getName() + ", enter your move (Example: A5 or A5F for flagging)");

            try {
                String safeMove = scan.nextLine().toUpperCase().trim();

                if (safeMove.isEmpty()) {
                    System.out.println("Input cannot be empty. Please try again.");
                    continue;
                }

                if (safeMove.length() < 2 || !check(safeMove)) {
                    System.out.println("Invalid input. Remember to enter your move in the format 'letter+number' (e.g., 'A4' or 'A4F' for flagging).");
                    continue;
                }

                char action = safeMove.charAt(safeMove.length() - 1);
                int row = safeMove.charAt(0) - 'A';

                int col;
                if (action == 'F' && safeMove.length() > 2) {
                    col = Integer.parseInt(safeMove.substring(1, safeMove.length() - 1)) - 1;
                    gameBoard.placeFlag(row, col);
                } else {
                    col = Integer.parseInt(safeMove.substring(1)) - 1;

                    if (gameBoard.isFlagged(row, col)) {
                        System.out.println("This cell is flagged. Un-flag it first if you want to reveal it.");
                    }else {
                        gameBoard.revealCell(row, col);
                        updateGameState(row, col);
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Please ensure your move follows the format 'letter+number' or 'letter+number+F'.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

            if (gameState.equals("WON")) {
                System.out.println(player.getName() + ": YOU WON THE GAME");
                gameBoard.displayGameBoard();
                return; // Avslutar gameLoop
            } else if (gameState.equals("LOST")) {
                System.out.println(player.getName() + ": Game over");
                gameBoard.displayGameBoard();
                return; // Avslutar gameLoop
            }
        }
    }
    public boolean check(String input) {
        return Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1));
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
