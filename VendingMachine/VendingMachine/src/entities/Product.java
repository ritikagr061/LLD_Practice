package entities;

import java.util.ArrayList;
import java.util.List;

public class Product {
    public String code;
    public Integer price;
    public String name;

    public Product(String code, Integer price, String name) {
        this.code = code;
        this.price = price;
        this.name = name;
    }
}
