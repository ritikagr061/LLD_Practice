package payment;

import java.util.Scanner;

public class UpiPaymentPortalStrategy implements PaymentPortalStrategy{
    @Override
    public void makePayment(int amount) {
        System.out.println("input the upi id");
        Scanner scanner = new Scanner(System.in);
        String upiId=scanner.nextLine();
        //do some processing
        System.out.println("payment Successful");
    }
}
