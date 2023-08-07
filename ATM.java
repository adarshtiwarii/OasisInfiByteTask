import java.util.HashMap;
import java.util.Scanner;

class User {
    private String userId;
    private String userPin;
    private double balance;

    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class ATM {
    private static HashMap<String, User> users = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        users.put("user1", new User("user1", "1234", 5000));
        users.put("user2", new User("user2", "5678", 10000));

        showWelcomeScreen();
    }

    private static void showWelcomeScreen() {
        System.out.println("Welcome to the ATM!");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        if (authenticateUser(userId, userPin)) {
            showMainMenu(userId);
        } else {
            System.out.println("Invalid User ID or PIN. Please try again.");
            showWelcomeScreen();
        }
    }

    private static boolean authenticateUser(String userId, String userPin) {
        if (users.containsKey(userId)) {
            User user = users.get(userId);
            return user.getUserPin().equals(userPin);
        }
        return false;
    }

    private static void showMainMenu(String userId) {
        System.out.println("\nHello, " + userId + "! Choose an option:");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Quit");

        int option = scanner.nextInt();
        scanner.nextLine(); 

        switch (option) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
            
                break;
            case 4:
            
                break;
            case 5:
                System.out.println("Thank you for using the ATM. Goodbye!");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        showMainMenu(userId); 
    }
}
