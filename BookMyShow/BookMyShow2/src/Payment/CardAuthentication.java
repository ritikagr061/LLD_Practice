package Payment;

import java.util.Scanner;

public class CardAuthentication implements AuthenticationStrategy{
    @Override
    public boolean authenticate() {
        Scanner sc=new Scanner(System.in);
        System.out.println("input your card info, first cardnumber,cvv,expery");
        String cardInfor=sc.next();
        System.out.println("Authentication in progres....");
        return true;
    }
}
