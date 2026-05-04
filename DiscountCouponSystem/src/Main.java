import entities.*;
import strategy.DiscountCouponStrategy;
import system.DiscountCouponSystem;

import java.time.LocalDateTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DiscountCouponSystem system = new DiscountCouponSystem();
        system.addCoupon(new Coupon(
                "FLAT200",
                DiscountType.ValueBased,
                LocalDateTime.of(2026,06,30,0,0,0),
                200,
                1000,
                List.of(Category.bags,Category.accessories),
                200
        ));

        Cart cart = new Cart(
                List.of(new Product("Lauki",1,10000,List.of(Category.grocery)))
        );

        System.out.println(system.applyCoupon("FLAT200",cart));
    }
}