package couponvalidator;

import entities.Cart;
import entities.Coupon;
import entities.CouponInvalidType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class CouponValidator {
    protected CouponValidator nextValidator;
    protected CouponInvalidType invalidType;
    public void setNext(CouponValidator validator){
        nextValidator = validator;
    }
    public abstract boolean isValid(Cart cart, Coupon coupon);
}
