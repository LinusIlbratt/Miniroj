
public class Player {
    private String name;
    private int score;

    // Konstruktor för att skapa en ny spelare med namn
    public Player(String playerName) {
        name = playerName;
        score = 0; // Initialisera poängen till 0 (eller ett annat lämpligt startvärde)
    }

    // Getter för spelarens namn
    public String getName() {
        return name;
    }

    // Setter för spelarens namn
    public void setName(String playerName) {
        name = playerName;
    }

    // Getter för spelarens poäng
    public int getScore() {
        return score;
    }

    // Setter för spelarens poäng
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
