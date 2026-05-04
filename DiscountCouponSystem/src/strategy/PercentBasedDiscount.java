package strategy;

import entities.Cart;
import entities.Coupon;

public class PercentBasedDiscount implements DiscountCouponStrategy{

    @Override
    public int calcDiscount(Coupon coupon, Cart cart) {
        int totalPrice = cart.getTotalPrice();
        double discount = totalPrice*1.00*coupon.getDiscountValue()/100;
        discount = Math.min(discount,coupon.getMaxDiscountAmount());
        return (int)Math.ceil(discount);
    }
}
