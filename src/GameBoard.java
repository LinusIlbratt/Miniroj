import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
    Random bombsOnBoard = new Random();
    private int boardSize;
    private ArrayList<ArrayList<Cell>> gameBoard;
    private int bombCount;

    public GameBoard(int boardSize, int bombCount) {
        this.boardSize = boardSize;
        this.bombCount = bombCount;
        this.gameBoard = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            ArrayList<Cell> innerBox = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                innerBox.add(new Cell());
            }
            gameBoard.add(innerBox);
        }

    }

    public void generateBombs() {
        int placedBombs = 0;
        while (placedBombs < bombCount) {
            int randomRow = bombsOnBoard.nextInt(boardSize);
            int randomCol = bombsOnBoard.nextInt(boardSize);
            if (!gameBoard.get(randomRow).get(randomCol).getHasBomb()) {
                gameBoard.get(randomRow).get(randomCol).setHasBomb(true);


                placedBombs++;
            }

        }

    }
    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBombCount() {
        return bombCount;
    }

    public void setBombCount(int bombCount) {
        this.bombCount = bombCount;
    }

    public void displayGameBoard() {
        // 1. Print column numbers
        System.out.print("    "); // Initial spacing
        for (int i = 1; i <= boardSize; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        // 2. Print the top edge frame of the board
        System.out.println("  +-------------------------------+");

        // 3. Print rows
        for (int row = 0; row < boardSize; row++) {
            // Print row letter
            char rowLetter = (char) ('A' + row);
            System.out.print(rowLetter + " ");

            // Print cells and dividers
            for (int col = 0; col < boardSize; col++) {
                System.out.print("| " + gameBoard.get(row).get(col).toString() + " ");
            }
            System.out.println("|");

            // Print horizontal dividers
            if (row < boardSize - 1) {
                System.out.println("  +-------------------------------+");
            }
        }

        // Print the bottom edge frame of the board
        System.out.println("  +-------------------------------+");
    }
}
