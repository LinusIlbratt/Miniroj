import java.util.Random;
import java.util.Scanner;

public class Game {
    private GameBoard gameBoard; // gameBoard is a reference of the GameBoard class    
    private Scanner scan;
    private Player player; // player is a reference of the Player class
    private String playerName;
    private String gameState;
    private GameTimer gameTimer;


    public Game() {
        scan = new Scanner(System.in);
        gameTimer = new GameTimer();
        gameBoard = new GameBoard(8, 10); // 8x8 with 10 bombs
        gameState = "RUNNING";


        System.out.println("Enter your name: ");
        String playerName = scan.nextLine();
        this.player = new Player(playerName);



        while (true) {
            System.out.println("Enter your name: ");
            String playerName = scan.nextLine();
            if (player.isValidName()) {                
                System.out.println("Name set to " + playerName);
                break;
            } else {
                System.out.println("This is not a valid name, please select another one.");
            }
        }
    }

    public void startGame() {
        String reset = "yes";
        while (reset.equalsIgnoreCase("yes")) {
            System.out.println("welcome to minesweeper");
            gameBoard.resetBoard();
            gameBoard.generateBombs();
            gameState = "RUNNING";
            while (gameState.equals("RUNNING")) {
                gameBoard.displayGameBoard();
                System.out.println(player.getName() + " enter your move (Exemple A5)");
                String safeMove = scan.nextLine().toUpperCase();
                if (check(safeMove)) {
                    try {     // converting safeMove to row and col
                        int rowRad = safeMove.charAt(0) - 'A';
                        int colKol = Integer.parseInt(safeMove.substring(1)) - 1;
                        gameBoard.revealCell(rowRad, colKol);
                        updateGameState(rowRad, colKol);
                    } catch (NumberFormatException e) {
                        System.out.println("Oj då! Kom ihåg att skriva in ditt drag i formatet 'bokstav+siffra', till exempel 'a4'.");
                    }
                } else {
                    System.out.println("Oj då! Kom ihåg att skriva in ditt drag i formatet 'bokstav+siffra', till exempel 'a4'.");
                }
            }
            if (gameState.equals("WON")) {
                System.out.println(player.getName() + ": YOU WON THE GAME");
                gameBoard.displayGameBoard();
                System.out.println("do you want to play again? (Yes/No)");
                reset = scan.nextLine().toLowerCase();

            } else if (gameState.equals("LOST")) {
                System.out.println(player.getName() + ": Game over");
                gameBoard.displayGameBoard();
                System.out.println("do you want to play again? (Yes/No)");
                reset = scan.nextLine().toLowerCase();
            }

        }

    }

    public boolean check(String input) {
        if (Character.isLetter(input.charAt(0)) && Character.isDigit(input.charAt(1))) {
            return true;
        }
        return false;
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
