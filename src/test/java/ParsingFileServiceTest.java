import entity.Vegetable;
import entity.vagetables.FruitVegetable;
import entity.vagetables.GreenVegetable;
import entity.vagetables.RootVegetable;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.implementations.ParsingFileServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class ParsingFileServiceTest {
    private ParsingFileServiceImpl parsingFileService = new ParsingFileServiceImpl();

    @Test
    void getProductsFromFileTest() {
        ArrayList<ArrayList<String>> testSaladsList = new ArrayList<>();
        ArrayList testSalad1 = new ArrayList();
        testSalad1.add("POTATOES 20");
        testSalad1.add("PARSLEY 5");
        testSalad1.add("TOMATO 50");
        testSalad1.add("LETTUCE 100");
        testSalad1.add("PEPPER 55");

        System.out.println("test1 :" + testSalad1);
        ArrayList testSalad2 = new ArrayList();
        testSalad2.add("CUCUMBER 51");
        testSalad2.add("ARAGULA 2");
        testSalad2.add("CARROT 48");
        testSalad2.add("PEPPER 89");
        System.out.println("tesr2: " + testSalad2);
        testSaladsList.add(testSalad1);
        testSaladsList.add(testSalad2);

        System.out.println("FROM FILE: " + parsingFileService.getSalads("C:\\Users\\ARTos\\IdeaProjects\\chef_cook\\src\\main\\resources\\recipes.txt"));
        Assert.assertEquals(parsingFileService.getSalads("C:\\Users\\ARTos\\IdeaProjects\\chef_cook\\src\\main\\resources\\recipes.txt"), testSaladsList);
    }

    @Test
    void getProductFromSaladLine() throws AssertionError {
        ArrayList<String> testSalad1 = new ArrayList();
        testSalad1.add("POTATOES 20");
        testSalad1.add("PARSLEY 5");
        testSalad1.add("TOMATO 50");
        testSalad1.add("LETTUCE 100");
        testSalad1.add("PEPPER 55");
        HashMap<Vegetable, Integer> testProducts = new HashMap<>();
        testProducts.put(new RootVegetable("POTATOES", 60), 20); //PATATO
        testProducts.put( new GreenVegetable("PARSLEY",15), 5); //PARSLEY
        testProducts.put( new FruitVegetable("TOMATO",20), 50); //TOMATO
        testProducts.put( new GreenVegetable("LETTUCE",30), 100); //LETTUCE
        testProducts.put( new FruitVegetable("PEPPER",30), 55); //PEPPER

        Assert.assertEquals(parsingFileService.getProductFromSaladLine(testSalad1), testProducts);
    }
}


