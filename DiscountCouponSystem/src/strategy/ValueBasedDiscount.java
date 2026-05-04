package strategy;

import entities.Cart;
import entities.Coupon;

public class ValueBasedDiscount implements DiscountCouponStrategy{
    @Override
    public int calcDiscount(Coupon coupon, Cart cart) {
        int totalPrice = cart.getTotalPrice();
        double discount = Math.min(coupon.getDiscountValue(),coupon.getMaxDiscountAmount());
        return (int)Math.ceil(discount);
    }
}
