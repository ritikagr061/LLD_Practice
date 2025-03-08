package payment;

import java.util.Scanner;

public class CardPaymentPortalStrategy implements PaymentPortalStrategy{
    @Override
    public boolean Authentication() {
        System.out.println("input card number and cvv no. in same line");
        Scanner scanner = new Scanner(System.in);
        String debitCardDetails=scanner.nextLine();
        System.out.println("input card expiry date in MM/YY format");
        String expDate=scanner.next();
        System.out.println("Processing Card Authentication ...");
        return true;
    }

    @Override
    public void makePayment(int amount) {

        //do some processing
        System.out.println("processing payment for amount "+amount);
        System.out.println("payment Successful");
    }
}