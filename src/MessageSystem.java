import java.util.ArrayList;
import java.util.List;

public class MessageSystem {
    private static final int MAX_MESSAGE_LENGTH = 250;
    private static final int MAX_MESSAGES_TO_SEND = 10;

    private List<String> outbox;
    private List<String> inboxStack;

    public MessageSystem() {
        this.outbox = new ArrayList<>();
        this.inboxStack = new ArrayList<>();
    }

    public void addMessage(String message) {
        try {
            validateMessage(message);

            if (outbox.size() < MAX_MESSAGES_TO_SEND) {
                outbox.add(message);
                System.out.println("Message added successfully.");
            } else {
                System.out.println("Error: Sending queue is full.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void sendMessage() {
        if (!outbox.isEmpty()) {
            inboxStack.addAll(outbox);
            outbox.clear();
            System.out.println("Message sent successfully.");
        } else {
            System.out.println("Sending queue is empty. No messages to send.");
        }
    }

    public void displayReceivedMessages() {
        if (!inboxStack.isEmpty()) {
            System.out.println("Received messages:");
            for (String message : inboxStack) {
                System.out.println(message);
            }
        } else {
            System.out.println("No messages received yet.");
        }
    }

    public void displayAllMessages() {
        System.out.println("All messages:");
        for (String message : outbox) {
            System.out.println(message);
        }
        for (String message : inboxStack) {
            System.out.println(message);
        }
    }

    private void validateMessage(String message) throws Exception {
        if (message.isEmpty()) {
            throw new Exception("Message cannot be empty.");
        }

        if (message.length() > MAX_MESSAGE_LENGTH) {
            throw new Exception("Message exceeds the maximum length of 250 characters.");
        }
    }
}
