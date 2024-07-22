package payment;

import java.util.Scanner;

public class DebitCardPaymentPortalStrategy implements PaymentPortalStrategy{
    @Override
    public void makePayment(int amount) {
        System.out.println("input debit card number and cvv no. in same line");
        Scanner scanner = new Scanner(System.in);
        String debitCardDetails=scanner.nextLine();
        //do some processing
        System.out.println("payment Successful");
    }
}