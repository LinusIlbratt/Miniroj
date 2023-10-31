import java.util.Scanner;

public class Main {

    static Scanner s;

    public static void main(String[] args) {


        int num;
        do {
            System.out.println("Welcome to Game Menu\n"
                    + "1.Play\n"
                    + "2.Exit\n");
            s = new Scanner(System.in);
            num = s.nextInt();

            switch (num) {
                case 1:
                    play();
                    break;
                case 2:
                    exit();
                    break;
                default:
                    break;
            }
        }
        while (num != 0);
    }

    private static void play() {
        int num;
        do {
            System.out.println("Which level do you want to play?");
            System.out.println("1. Easy");
            System.out.println("2. Difficult");
            s = new Scanner(System.in);
            num = s.nextInt();

            switch (num) {
                case 1:
                    System.out.println("You choosed easy");
                    Game miniroj = new Game();
                    miniroj.startGame();
                    break;
                case 2:
                    System.out.println("You choosed difficult");
                    break;
                default:  System.out.println("Wrong input, try again");
                    break;
            }
        }
        while (num != 0);

    }
    private static void exit() {
    }
}
