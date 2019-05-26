package service.implementations;

import entity.Salad;
import entity.Vegetable;
import service.interfaces.CookingService;

import java.util.HashMap;
import java.util.List;

public class CookingServiceImpl implements CookingService {


    public Salad prepareSalad(String name, HashMap<Vegetable, Integer> products) {
        Salad salad = new Salad(name, products);
        return salad;
    }
}
