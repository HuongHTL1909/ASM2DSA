import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageSystem system = new MessageSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Function.displayMenu();
            int choice = Function.getUserChoice(scanner);

            if (choice == Option.EXIT.ordinal() + 1) {
                System.out.println("Exiting the program.");
                break;
            }

            Function.handleUserInput(system, scanner, Option.values()[choice - 1]);
        }
    }
}
