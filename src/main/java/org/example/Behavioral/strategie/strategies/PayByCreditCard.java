package org.example.Behavioral.strategie.strategies;

import java.util.Scanner;

public class PayByCreditCard implements PayStrategy{
    Scanner scanner = new Scanner(System.in);
    private CreditCard card;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
        try {
            System.out.print("Enter the card number: ");
            String number = scanner.nextLine();
            System.out.print("Enter the card expiration date 'mm/yy': ");
            String date = scanner.nextLine();
            System.out.print("Enter the CVV code: ");
            String cvv = scanner.nextLine();
            card = new CreditCard(number, date, cvv);

            // Validate credit card number...

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
        if (cardIsPresent()) {
            System.out.println("Paying " + paymentAmount + " using Credit Card.");
            card.setAmount(card.getAmount() - paymentAmount);
            return true;
        } else {
            return false;
        }
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
