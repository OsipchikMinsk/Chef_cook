package service.implementations;

import entity.Salad;
import entity.Vegetable;
import service.interfaces.CalculatingService;

import java.util.Map;


public class CalculatingServiceImpl implements CalculatingService {
    public double calculateKiloCalories(Salad salad) {
        double kiloCalories = 0;
        for (Map.Entry<Vegetable, Integer> product : salad.getProducts().entrySet()) {
            System.out.println(product.getKey() + "/" + product.getValue());
            kiloCalories += product.getValue();
        }
        return kiloCalories;//salad.getProducts().stream().mapToDouble(Vegetable::getKiloCaloriesInG).sum();
    }

    public void sortByKiloCalories() {

    }

    public void sortByKiloCaloriesAndKeepingTime() {

    }
}
