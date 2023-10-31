
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
        // Use a regular expression to check if the name contains only letters
        boolean valid = name.matches("^[a-zA-Z]+$");

        if (!valid) {
            System.out.println("The name is not okay. It should consist of letters only.");
        }
        return valid;
    }

}
