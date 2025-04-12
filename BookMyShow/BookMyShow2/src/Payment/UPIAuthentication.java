package Payment;

import java.util.Scanner;

public class UPIAuthentication implements AuthenticationStrategy{
    @Override
    public boolean authenticate() {
        Scanner sc=new Scanner(System.in);
        System.out.println("input your upi details...");
        String cardInfor=sc.next();
        System.out.println("Authentication in progres....");
        return true;
    }

}
