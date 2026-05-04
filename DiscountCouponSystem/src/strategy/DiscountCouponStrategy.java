package strategy;

import entities.Cart;
import entities.Coupon;

public interface DiscountCouponStrategy {
    public int calcDiscount(Coupon coupon, Cart cart);
}
