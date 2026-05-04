package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {
    private String code;
    private DiscountType discountType;
    private LocalDateTime expiry;
    private int maxDiscountAmount;
    private int minCartValue;
    private List<Category> applicableCategories;
    private int discountValue;
}
