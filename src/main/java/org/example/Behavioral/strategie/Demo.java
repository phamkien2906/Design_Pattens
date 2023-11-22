package org.example.Behavioral.strategie;

import org.example.Behavioral.strategie.order.Order;
import org.example.Behavioral.strategie.strategies.PayByCreditCard;
import org.example.Behavioral.strategie.strategies.PayByPayPal;
import org.example.Behavioral.strategie.strategies.PayStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();

    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = scanner.nextInt();
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count =  scanner.nextInt();
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice =  scanner.nextLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = scanner.nextLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Đây là truyền tham chiếu nên khi truyền strategy để chạy hàm processOrder thì
            //các trường của đối tượng này sẽ được khởi tạo và chạy
            order.processOrder(strategy);
            //Sử dụng hàm bên trên thay vì gọi trực tiếp strategy.collectPaymentDetails() để tránh
            //có sự phụ thuộc vào Páytrategy

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = scanner.nextLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}
