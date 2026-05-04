package couponvalidator;

import entities.Cart;
import entities.Category;
import entities.Coupon;
import entities.CouponInvalidType;

import java.util.List;

public class ProductCategoryValidator extends CouponValidator{
    @Override
    public boolean isValid(Cart cart, Coupon coupon) {
        List<Category> allProductCategories = cart.getProducts().stream().flatMap(p->p.getCategoryList().stream()).toList();
        for(Category category:coupon.getApplicableCategories()){
            if(allProductCategories.contains(category)){
                if(nextValidator==null)
                    return true;
                return nextValidator.isValid(cart,coupon);
            }
        }
        invalidType = CouponInvalidType.CategoryNotMatched;
        return false;
    }
}
