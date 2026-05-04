package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private List<Product> products;
    public int getTotalPrice(){
        int total = products.stream().mapToInt(p -> p.getPrice()).sum();
        return total;
    }
}
