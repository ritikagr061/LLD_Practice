package system;

import couponvalidator.CouponValidator;
import couponvalidator.ExpiryValidator;
import couponvalidator.MinCartValueValidator;
import couponvalidator.ProductCategoryValidator;
import entities.Cart;
import entities.Coupon;
import entities.CouponResult;
import entities.DiscountType;
import strategy.DiscountCouponStrategy;
import strategy.PercentBasedDiscount;
import strategy.ValueBasedDiscount;

import java.util.ArrayList;
import java.util.List;

public class DiscountCouponSystem {
    private List<Coupon> coupons;
    private CouponValidator validator;
    private DiscountCouponStrategy strategy;

    public DiscountCouponSystem(){
        coupons = new ArrayList<>();
        CouponValidator validator1 = new ProductCategoryValidator();
        CouponValidator validator2 = new MinCartValueValidator();
        validator2.setNext(validator1);
        CouponValidator validator3 = new ExpiryValidator();
        validator3.setNext(validator2);
        validator = validator3;
    }

    public void addCoupon(Coupon coupon){
        if(coupons.stream().anyMatch(c->c.getCode().equals(coupon.getCode())))
            return;
        coupons.add(coupon);
    }

    public CouponResult applyCoupon(String code, Cart cart){
        Coupon coupon = coupons.stream().filter(c->c.getCode().equals(code)).findFirst().orElse(null);
        CouponResult ans = new CouponResult();
        ans.setTotalItemPrice(cart.getTotalPrice());
        if(coupon==null){
            System.out.println("Coupon Not Found");
            ans.setTotalPayable(ans.getTotalItemPrice());
            return ans;
        }
        boolean isValid = validator.isValid(cart,coupon);
        if(!isValid){
            System.out.println("Failed to apply Coupon: "+validator.getInvalidType());
            ans.setTotalPayable(ans.getTotalItemPrice());
            return ans;
        }
        else{
            if(coupon.getDiscountType()== DiscountType.PercentBased)
                strategy = new PercentBasedDiscount();
            else strategy = new ValueBasedDiscount();
            ans.setDiscount(strategy.calcDiscount(coupon,cart));
            ans.setTotalPayable(ans.getTotalItemPrice()-ans.getDiscount());
            return ans;
        }
    }
}

