import java.util.ArrayList;

public class GameBoard  {
    private int boardSize;
    private ArrayList<ArrayList<Cell>> gameBoard;
    private int bombCount;

    public GameBoard(int boardSize,int bombCount) {
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
}
