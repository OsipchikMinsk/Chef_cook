package service.implementations;

import entity.Salad;
import entity.Vegetable;
import service.interfaces.CalculatingService;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;


public class CalculatingServiceImpl implements CalculatingService {
    public double calculateKiloCalories(Salad salad) {
        double kiloCalories = 0;
        for (Map.Entry<Vegetable, Integer> product : salad.getProducts().entrySet()) {
            System.out.println(product.getKey() + "/" + product.getValue());
            kiloCalories += product.getValue();
        }
        return kiloCalories;
    }

    public  List<Vegetable> sortByKiloCalories(Salad salad) {
        List<Vegetable> products =  new ArrayList<>();
        products.addAll(salad.getProducts().keySet());
        products.forEach( prod -> {
            System.out.println("PRODUCT: " + prod);
        });
        return products.stream().sorted(Comparator.comparing(Vegetable::getKiloCaloriesInG)).collect(Collectors.toList());
    }

    public  List<Vegetable> sortByKiloCaloriesAndKeepingTime(Salad salad) {
        List<Vegetable> products =  new ArrayList<>();
        products.addAll(salad.getProducts().keySet());
        products.forEach( prod -> {
            try {
                System.out.println("PRODUCT: " + prod.getClass().getDeclaredField("KEEPING_TIME"));
                Field field = prod.getClass().getDeclaredField("KEEPING_TIME");
                field.setAccessible(true);
                try {
                    Object value = field.get(prod);
                    System.out.println("FILED: " + value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        });
        return products.stream().sorted(Comparator.comparing(Vegetable::getKiloCaloriesInG).
                thenComparing(Comparator.comparing(Vegetable::getKeepingTime))).collect(Collectors.toList());

    }
}
