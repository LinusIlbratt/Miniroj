public class Cell {
    protected boolean hasBomb;
    protected boolean isRevealed;
    private int neighboringBombs;

    public Cell(){
        // Attributes already have their standard values.
    }
    public boolean hasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public int getNeighboringBombs() {
        return neighboringBombs;
    }

    public void setNeighboringBombs(int neighboringBombs) {
        this.neighboringBombs = neighboringBombs;
    }

    public boolean getHasBomb() {
        return false;
    }

    @Override
    public String toString() {
        if (isRevealed) {
            if (hasBomb) {
                return "B";
            } else {
                return Integer.toString(neighboringBombs);
            }
        } else {
            return " ";
        }
    }

}

