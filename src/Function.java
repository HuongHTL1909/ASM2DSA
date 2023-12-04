import java.util.Scanner;

public class Function {
    public static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("1. Add new message");
        System.out.println("2. Send message");
        System.out.println("3. Display received messages");
        System.out.println("4. Display all messages");
        System.out.println("5. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        int choice = 0;

        while (choice < 1 || choice > 5) {
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice < 1 || choice > 5) {
                    System.out.println("Error: Please enter an integer from 1 to 5. Try again.");
                    scanner.nextLine(); // Clear the buffer
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter an integer from 1 to 5. Try again.");
                scanner.nextLine(); // Clear the buffer
            }
        }

        return choice;
    }

    public static void handleUserInput(MessageSystem system, Scanner scanner, Option option) {
        switch (option) {
            case ADD_MESSAGE:
                addMessage(system, scanner);
                break;

            case SEND_MESSAGE:
                system.sendMessage();
                break;

            case DISPLAY_RECEIVED_MESSAGES:
                system.displayReceivedMessages();
                break;

            case DISPLAY_ALL_MESSAGES:
                system.displayAllMessages();
                break;

            case EXIT:
                System.out.println("Exiting the program.");
                break;
        }
    }

    private static void addMessage(MessageSystem system, Scanner scanner) {
        System.out.println("Enter a message. Type 'done' to finish:");
        String message = scanner.nextLine();
        if (!message.equals("done")) {
            system.addMessage(message);
        }
    }
}
