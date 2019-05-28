package entity;

import java.util.HashMap;
import java.util.List;

public class Salad {
    private String name;
    HashMap<Vegetable, Integer> products; //

    public Salad(String name, HashMap<Vegetable, Integer> products) {
        this.name = name;
        this.products = products;
    }

    public HashMap<Vegetable, Integer> getProducts() {
        return products;
    }
}
