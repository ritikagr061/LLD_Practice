package Payment;

public class DebitCard implements PaymentType{
    AuthenticationStrategy as;
    public DebitCard(){
        as=new CardAuthentication();
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
