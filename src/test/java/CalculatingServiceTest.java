import entity.Salad;
import entity.Vegetable;
import entity.vagetables.FruitVegetable;
import entity.vagetables.GreenVegetable;
import entity.vagetables.RootVegetable;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import service.implementations.CalculatingServiceImpl;

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
    void sortSaladProductsByKiloCalories() {
        HashMap<Vegetable, Integer> products = new HashMap<>();
        Vegetable tomato = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name(),100);
        Vegetable potatoes = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
        Vegetable letucce = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name(),30);
        products.put(tomato, 50);
        products.put(potatoes, 100);
        products.put(letucce, 175);

        Salad salad = new Salad("KingSizeSalad", products);
        List<Vegetable> setProducts = calculatingService.sortByKiloCalories(salad);
        for (int i = 0; i < setProducts.size(); i++){
            System.out.println("pros: " + setProducts.get(i));
        }

    }

}
