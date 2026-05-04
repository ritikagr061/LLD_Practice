package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CouponResult {
    int totalItemPrice;
    int discount=0;
    int totalPayable;
}
