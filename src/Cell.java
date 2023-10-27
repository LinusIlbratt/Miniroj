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


    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }


    public boolean getHasBomb() {
        return hasBomb;
    }


    public boolean isRevealed() {
        return isRevealed;

    }

    public void setRevealed(boolean revealed) {

        isRevealed = revealed;
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    public int getNeighboringBombs() {
        return neighboringBombs;
    }
}

