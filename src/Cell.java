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
                // Röd färg för bomber
                return "\u001B[31mB\u001B[0m";
            } else {
                // Färgkod för siffrorna beroende på antalet grannbomber
                String color;
                if (neighboringBombs == 0) {
                    color = "\u001B[0m"; // Vit färg för noll
                } else if (neighboringBombs == 1) {
                    color = "\u001B[34m"; // Blå färg för ett
                } else if (neighboringBombs == 2) {
                    color = "\u001B[32m"; // Grön färg för två
                } else {
                    color = "\u001B[33m"; // Gul färg för andra siffror
                }
                return color + neighboringBombs + "\u001B[0m";
            }
        } else {
            return " ";
        }
    }

}

