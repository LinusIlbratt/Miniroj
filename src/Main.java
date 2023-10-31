import java.util.Scanner;

public class Main {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Minesweeper\n"
                    + "1. New Game\n"
                    + "2. Highscore\n"
                    + "3. Exit");
            String input = scan.nextLine();
            int num;
            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            switch (num) {
                case 1:
                    selectDifficulty();
                    break;
                case 2:
                    // Enter highscore
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void selectDifficulty() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Which level do you want to play?");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");

            String input = scan.nextLine();
            int num;
            try {
                num = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            GameBoard gameBoard;
            switch (num) {
                case 1:
                    gameBoard = new GameBoard(5, 5); // Easy Settings
                    break;
                case 2:
                    gameBoard = new GameBoard(8, 10); // Medium Settings
                    break;
                case 3:
                    gameBoard = new GameBoard(12, 25); // Hard Settings
                    break;
                default:
                    System.out.println("Wrong input, try again");
                    continue;
            }
            Game game = new Game(gameBoard);
            continuePlaying = game.startGame();
        }
    }

}
