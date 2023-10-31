import java.util.ArrayList;
import java.util.Random;

public class GameBoard {
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

        // Update neighboring bomb counts for the 8 surrounding cells
        int[] directionRow = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] directionCol = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + directionRow[i];
            int newCol = col + directionCol[i];
            // Check boundary conditions
            if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                Cell neighborCell = gameBoard.get(newRow).get(newCol);
                neighborCell.setNeighboringBombs(neighborCell.getNeighboringBombs() + 1);
            }
        }
    }
    public void placeFlag(int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            System.out.println("Invalid coordinates.");
            return;
        }

        Cell cell = gameBoard.get(row).get(col);
        if(cell.isRevealed()) {
            System.out.println("Cannot place a flag on a revealed cell.");
            return;
        }

        if (cell.hasFlag()) {
            cell.setFlag(false);
            System.out.println("Flag removed.");
        } else {
            cell.setFlag(true);
            System.out.println("Flag placed.");
        }
    }
    public boolean isFlagged(int row, int col) {
        return gameBoard.get(row).get(col).hasFlag();
    }
    public void generateBombs() {
        Random rand = new Random();
        int placedBombs = 0;
        while (placedBombs < bombCount) {
            int randomRow = rand.nextInt(boardSize);
            int randomCol = rand.nextInt(boardSize);
            Cell selectedCell = gameBoard.get(randomRow).get(randomCol);


            if (!selectedCell.hasBomb()) {
                placeBomb(randomRow, randomCol);
                placedBombs++;
            }
        }
    }
    public int getBoardSize() {
        return boardSize;
    }
    public int getBombCount() {
        return bombCount;
    }
    public void revealCell(int row, int col){
        // Check if the index is valid
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize){
            return;
        }

        Cell cell = gameBoard.get(row).get(col);

        // If the cell is already revealed print a message for the user
        if (cell.isRevealed()) {
            System.out.println("The cell is already revealed, try again. 😊");
            return;
        }

        // Reveal the cell
        cell.setRevealed(true);

        // If the cell has a bomb, reveal all bombs
        if (cell.hasBomb()){
            revealAllBombs();
            return;
        }

        // If the number of adjacent-bomb is 0, reveal adjacent cells recursive
        if (cell.getNeighboringBombs() == 0) {
            revealAdjacentCells(row, col);
        }
    }

    public void revealAdjacentCells(int row, int col) {
        for (int directionX = -1; directionX <= 1; directionX++) {
            for (int directionY = -1; directionY <= 1; directionY++) {
                // Avoid revealing the cell again
                if (directionX == 0 && directionY == 0) continue;

                int newRow = row + directionX;
                int newCol = col + directionY;

                // Check the board boundaries
                if (newRow >= 0 && newRow < boardSize && newCol >= 0 && newCol < boardSize) {
                    Cell adjacantCell = gameBoard.get(newRow).get(newCol);

                    // Reveal the cell recursively if it's not revealed, doesn't have a bomb or is flagged
                    if (!adjacantCell.isRevealed() && !adjacantCell.hasBomb() && !adjacantCell.hasFlag()) {
                        revealCell(newRow, newCol);
                    }
                }
            }
        }
    }
    private void revealAllBombs() {
        for (int i = 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++){
                Cell cell = gameBoard.get(i).get(j);
                if (cell.hasBomb()) {
                    cell.setFlag(false);
                    cell.setRevealed(true);
                }
            }
        }
    }
    public void resetBoard() {
        for (ArrayList<Cell> row : gameBoard) {
            for (Cell cell : row) {
                // Resetting cell to its original state
                cell.setHasBomb(false);
                cell.setRevealed(false);
                cell.setNeighboringBombs(0);
            }
        }
    }
    public void displayGameBoard() {
        // Dynamic divider based on boardSize
        String horizontalDivider = "  +";
        for (int i = 0; i < boardSize; i++) {
            horizontalDivider += "----";
        }
        horizontalDivider += "+";

        // 1. Print column numbers
        System.out.print("    "); // Initial spacing
        for (int i = 1; i <= boardSize; i++) {
            if (i < 10) {
                // Additional space for single-digit numbers for alignment
                System.out.print(" " + i + "  ");
            } else {
                System.out.print(i + "  ");
            }
        }
        System.out.println();

        // 2. Print the top edge frame of the board
        System.out.println(horizontalDivider);

        // 3. Print rows
        for (int row = 0; row < boardSize; row++) {
            // Print row letter
            char rowLetter = (char) ('A' + row);
            System.out.print(rowLetter + " |");

            // Print cells
            for (int col = 0; col < boardSize; col++) {
                System.out.print(" " + gameBoard.get(row).get(col).toString() + " |");
            }
            System.out.println();

            // Print horizontal divider after each row except the last one
            if (row < boardSize - 1) {
                System.out.println(horizontalDivider);
            }
        }

        // Print the bottom edge frame of the board
        System.out.println(horizontalDivider);
    }


}
