public class Cell {
    protected boolean hasBomb;
    protected boolean isRevealed;
    private int neighboringBombs;

    private boolean hasFlag;
    public Cell(){
        // Attributes already have their standard values.
    }
    public boolean hasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public boolean hasFlag() {
        return hasFlag;
    }
    public void setFlag(boolean hasFlag) {
        this.hasFlag = hasFlag;
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
        if (hasFlag) {
            return "F";
        }
        if (isRevealed) {
            if (hasBomb) {
                // Red color for the bomb
                return "\u001B[31mB\u001B[0m";
            } else {
                // color for the number 0-3 and Bomb(B)
                String color;
                if (neighboringBombs == 0) {
                    color = "\u001B[0m"; // the color of zero is white
                } else if (neighboringBombs == 1) {
                    color = "\u001B[34m"; // the color of the One is blue
                } else if (neighboringBombs == 2) {
                    color = "\u001B[32m"; // the color of the Two is green
                } else {
                    color = "\u001B[33m"; // Yellow color for other numbers
                }
                return color + neighboringBombs + "\u001B[0m";
            }
        } else {
            return " ";
        }
    }

}

