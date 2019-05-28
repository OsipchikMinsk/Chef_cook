package entity;

import service.implementations.CalculatingServiceImpl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Salad   {
    private String name;
    HashMap<Vegetable, Integer> products;

    public Salad(String name, HashMap<Vegetable, Integer> products) {
        this.name = name;
        this.products = products;
    }

    public HashMap<Vegetable, Integer> getProducts() {
        return products;
    }





}




