import java.util.Scanner;

public class Main {
    private static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public static final String ORANGE = "\u001B[38;5;208m";
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        printWithDelay(titleMessage(), 8);

        while (true) {

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
                    ruleTitle();
                    printWithDelay(ruleText(), 8);
                    promptAnyKey();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static String ruleText() {
        return ORANGE + """
                Your goal: Safely clear the field without triggering any mines.
                            
                - Open a cell by typing its coordinate, like A1. Numbers in a cell shows the count of mines around the cell.
                - Cells with no adjacent mines automatically reveal their neighboring cells.
                - Mines can be in any of the 8 directions around a cell.
                - Think there's a mine nearby? Flag it with an 'F' (e.g., A1F) to mark or unmark.
                            

                Win by opening all safe cells. Good luck, and be careful!
                """ + RESET;

    }

    private static void ruleTitle() {
        System.out.println( ORANGE + """
                                                       ____         _          \s
                                                      |  _  \\_    _| | ___    ___\s
                                                      | |_) | |  | | |/ _ \\ / __|
                                                      |  _ <| |_ | | |  __/\\\\__ \\
                                                      |_| \\_\\ \\__,_|_|\\___| |___/              
                
                """ + RESET);
    }

    private static void promptAnyKey(){
        System.out.println("\nPress any key to get back....");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    private static void selectDifficulty() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            System.out.println("Which level do you want to play?");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.print("> ");

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


    public static String titleMessage() {
        return RED+ """
                     \s
                                     __  __ _              ____\s
                                    |  \\/  (_)_ __   ___  / ___|_      _____  ___ _ __   ___ _ __\s
                                    | |\\/| | | '_ \\ / _ \\ \\___ \\  \\ _ / / _ \\/ _ \\ '_ \\ / _ \\ '__|\s
                                    | |  | | | | | |  __/  ___) \\ V  V /  __/  __/ |_) |  __/ |\s
                                    |_|  |_|_|_| |_|\\___| |____/ \\_/\\_/ \\___|\\___| .__/ \\___|_|\s
                                                                                 |_|\s
                     \s
                    """ + RESET;
    }
    public static void printWithDelay(String message, long millisPerChar) {
        for (char ch : message.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(millisPerChar);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Interrupted!");
            }
        }
        System.out.println();
    }
}
