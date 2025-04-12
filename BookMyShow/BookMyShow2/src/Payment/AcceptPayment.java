package Payment;

import java.util.Scanner;

public class AcceptPayment implements Payments{
    PaymentType pt;
    public AcceptPayment(){
        Scanner sc=new Scanner(System.in);
        System.out.println("chose your payment type 1.UPI,2.Credit,3.Debit ");
        String s=sc.next();
        if(s.equals("UPI"))
            pt=new UPI();
        else if(s.equals("Credit"))
            pt=new CreditCard();
        else pt=new DebitCard();
    }
    @Override
    public boolean doPayment(int amt) {
        if(pt.authenticate()){
            return pt.doPayment(amt);
        }
        else return false;
    }
}
