package org.example.Behavioral.strategie.strategies;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayByPayPal implements PayStrategy{
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private String email;
    private String password;
    private boolean signedIn;
    Scanner scanner = new Scanner(System.in);
    static {
        DATA_BASE.put("amanda1985", "amanda@ya.com");
        DATA_BASE.put("qwerty", "john@amazon.eu");
    }

    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            while (!signedIn) {
                System.out.print("Enter the user's email: ");
                email = scanner.nextLine();

                System.out.print("Enter the password: ");
                password = scanner.nextLine();
                if (verify()) {
                    System.out.println("Data verification has been successful.");
                } else {
                    System.out.println("Wrong email or password!");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (signedIn) {
            System.out.println("Paying " + paymentAmount + " using PayPal.");
            return true;
        } else {
            return false;
        }
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}
