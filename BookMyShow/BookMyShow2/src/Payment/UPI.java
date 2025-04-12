package Payment;

public class UPI implements PaymentType{
    AuthenticationStrategy as;
    public UPI(){
        as=new UPIAuthentication();
    }
    @Override
    public boolean authenticate() {
        return as.authenticate();
    }

    @Override
    public boolean doPayment(int amnt) {
        System.out.println("Payment of rs. "+amnt+" is in progress...");
        System.out.println("Payment succesful");
        return true;
    }

}
