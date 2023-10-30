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

