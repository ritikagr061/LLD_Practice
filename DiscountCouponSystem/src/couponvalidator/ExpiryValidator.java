package couponvalidator;

import entities.Cart;
import entities.Coupon;
import entities.CouponInvalidType;

import java.time.LocalDateTime;

public class ExpiryValidator extends CouponValidator{
    @Override
    public boolean isValid(Cart cart, Coupon coupon) {
        if(coupon.getExpiry().isBefore(LocalDateTime.now())){
            invalidType = CouponInvalidType.Expired;
            return false;
        }

        if(nextValidator==null)
            return true;
        return nextValidator.isValid(cart,coupon);
    }
}
