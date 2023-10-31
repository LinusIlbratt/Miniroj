
public class Player {
    private String name;
    private int score;

    // Constructor
    public Player(String playerName) {
        name = playerName;
        score = 0; // Initialize to 0
    }

    // Getter player name
    public String getName() {
        return name;
    }

    // Setter player name
    public void setName(String playerName) {
        name = playerName;
    }

    // Getter for player points
    public int getScore() {
        return score;
    }

    // Setter for player points
    public void setScore(int playerScore) {
        score = playerScore;
    }

    public boolean isValidName() {
        // Returns true if the name contains letters only, otherwise false
        return name.matches("^[a-zA-Z]+$");

    }

}
