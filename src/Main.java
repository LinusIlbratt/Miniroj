import java.util.Scanner;

public class Main {
    private static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print(RED+ """

                     +------------------------------------------------------------------------------------------+\s
                     |                __  __ _              ____                                                |\s
                     |               |  \\/  (_)_ __   ___  / ___|_      _____  ___ _ __   ___ _ __              |\s
                     |               | |\\/| | | '_ \\ / _ \\ \\___ \\  \\ _ / / _ \\/ _ \\ '_ \\ / _ \\ '__|             |\s
                     |               | |  | | | | | |  __/  ___) \\ V  V /  __/  __/ |_) |  __/ |                |\s
                     |               |_|  |_|_|_| |_|\\___| |____/ \\_/\\_/ \\___|\\___| .__/ \\___|_|                |\s
                     |                                                            |_|                           |\s
                     +------------------------------------------------------------------------------------------+\s
                    """ + RESET);
            

            System.out.println("""
                    Welcome! Make your choice:\s
                    1. New Game
                    2. Read rules
                    3. Exit""");
            System.out.print("> ");
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
