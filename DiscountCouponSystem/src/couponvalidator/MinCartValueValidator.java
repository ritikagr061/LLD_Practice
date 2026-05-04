package couponvalidator;

import entities.Cart;
import entities.Coupon;
import entities.CouponInvalidType;

public class MinCartValueValidator extends CouponValidator{
    @Override
    public boolean isValid(Cart cart, Coupon coupon) {
        if(cart.getTotalPrice()<coupon.getMinCartValue()){
            invalidType = CouponInvalidType.MinCartValueNotFulfilled;
            return false;
        }

        if(nextValidator==null)
            return true;
        return nextValidator.isValid(cart,coupon);
    }
}
