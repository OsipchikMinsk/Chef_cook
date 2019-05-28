import entity.Salad;
import entity.Vegetable;
import entity.vagetables.FruitVegetable;
import entity.vagetables.GreenVegetable;
import entity.vagetables.RootVegetable;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.implementations.CalculatingServiceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class CalculatingServiceTest {
    CalculatingServiceImpl calculatingService = new CalculatingServiceImpl();

    @Test
    void calculateProductKiloCalories() {
        HashMap<Vegetable, Integer> products = new HashMap<>();
        Vegetable tomato = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name(),20);
        Vegetable potatoes = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
        Vegetable letucce = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name(),30);
        products.put(tomato, 50);
        products.put(potatoes, 100);
        products.put(letucce, 75);

        Salad salad = new Salad("CheefSalad", products);
        Assert.assertEquals(calculatingService.calculateKiloCalories(salad), 225.0);


    }

    @Test
    void sortSaladProductsByKiloCaloriesAndKeepingTime() {
        HashMap<Vegetable, Integer> products = new HashMap<>();
        Vegetable tomato = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name(),100);
        Vegetable potatoes = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
        Vegetable potatoes2 = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
        potatoes.setKeepingTime(100);
        Vegetable potatoes3 = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
        potatoes2.setKeepingTime(500);
        setKeepingTimeForVegetable(potatoes3);
        potatoes3.setKeepingTime(6);
        Vegetable letucce = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name(),30);
        products.put(tomato, 50);
        products.put(potatoes, 100);
        products.put(potatoes2, 100);
        products.put(potatoes3, 100);
        products.put(letucce, 175);

        Salad salad = new Salad("KingSizeSalad", products);
        List<Vegetable> listProducts = calculatingService.sortByKiloCaloriesAndKeepingTime(salad);
        listProducts.forEach( prod -> {
            System.out.println("PROD: " + prod);

        });

    }

    private void setKeepingTimeForVegetable(Vegetable vegetable) {
        try {
            Field keepingTime = vegetable.getClass().getDeclaredField("KEEPING_TIME");
            keepingTime.setAccessible(true);
            Object value = keepingTime.get(vegetable);
            vegetable.setKeepingTime(Integer.parseInt(value.toString()));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
