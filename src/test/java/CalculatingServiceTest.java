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

public class CalculatingServiceTest {
    CalculatingServiceImpl calculatingService = new CalculatingServiceImpl();

    @Test
    void calculateProductKiloCalories() {
        HashMap<Vegetable, Integer> products = new HashMap<>();
        Vegetable tomato = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name());
        Vegetable potatoes = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name());
        Vegetable letucce = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name());
        products.put(tomato, 50);
        products.put(potatoes, 100);
        products.put(letucce, 75);

        Salad salad = new Salad("CheefSalad", products);
        Assert.assertEquals(calculatingService.calculateKiloCalories(salad), 225.0);


    }

}
