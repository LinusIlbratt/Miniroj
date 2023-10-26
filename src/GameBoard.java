import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
     protected Cell cell;
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
    public Cell getCell(int row, int col){
        ArrayList<Cell> getRow = gameBoard.get(row);
        Cell getCelInRow = getRow.get(col);
        return getCelInRow;


    }

    private void placeBomb(int row, int col) {
        gameBoard.get(row).get(col).setHasBomb(true);
    }
    public void generateBombs() {
        Random rand = new Random();
        int placedBombs = 0;
        while (placedBombs < bombCount) {
            int randomRow = rand.nextInt(boardSize);
            int randomCol = rand.nextInt(boardSize);
            Cell selectedCell = gameBoard.get(randomRow).get(randomCol);


            if (!selectedCell.getHasBomb()) {
                placeBomb(randomRow, randomCol);
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
    public void revealCell(int row, int col){
        // Check if the index is valid
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize){
            return;
        }

        Cell cell = gameBoard.get(row).get(col);

        // If the cell is already revealed then we return true
        if (cell.isRevealed()) {
            return;
        }

        // Reveal the cell
        cell.setRevealed(true);

        // If the cell has a bomb, then it's a loss
        if (cell.hasBomb()){
            // TODO This code will run if it has a bomb, implement a method for game over
            System.out.println("Game over!");
            return;
        }

        // If the cell doesn't have any neighboring bombs, reveal neighboring cells
        if (cell.getNeighboringBombs() == 0) {
            // 8 possible directions for neighboring cells
            int[] directionRow = {-1 ,-1 ,-1 ,0, -1 ,1 , 0, 1};
            int[] directionCol = {1 , -1 , 1 , 0 , 1 , 1, 0 ,-1};
            for (int i = 0; i < 8; i++){
                revealCell(row + directionRow[i], col + directionCol[i]);
            }
        }
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
