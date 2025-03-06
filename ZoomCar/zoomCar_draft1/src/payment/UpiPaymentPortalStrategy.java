package payment;

import java.util.Scanner;

public class UpiPaymentPortalStrategy implements PaymentPortalStrategy{
    @Override
    public boolean Authentication() {
        System.out.println("input the upi id");
        Scanner scanner = new Scanner(System.in);
        String upiId=scanner.nextLine();
        System.out.println("input the upi password");
        String upiPass=scanner.nextLine();

        //authentication code
        return true;
    }

    @Override
    public void makePayment(int amount) {

        //do some processing
        System.out.println("payment Successful");
    }
}
