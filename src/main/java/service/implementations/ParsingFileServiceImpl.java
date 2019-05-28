package service.implementations;

import entity.Vegetable;
import entity.vagetables.FruitVegetable;
import entity.vagetables.GreenVegetable;
import entity.vagetables.RootVegetable;
import service.interfaces.ParsingFileService;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

public class ParsingFileServiceImpl implements ParsingFileService {
    @Override
    public ArrayList<ArrayList> getSalads(String path) {
        System.out.println("PATH: " + path);
        ArrayList<ArrayList> salads = new ArrayList<ArrayList>();
        File tempFile = new File(path); //"recipes.txt";
        try {
            Scanner scanner = new Scanner(tempFile);
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(",");

                ArrayList<String> salad = new ArrayList<>();
                int size = line.length;
                for (int i = 1; i < size; i++) {
                    salad.add(line[i].substring(1, line[i].length()).toUpperCase());
                }

                if (salad.size() > 0) {
                    salads.add(salad);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return salads;
    }

    @Override
    public HashMap<Vegetable, Integer> getProductFromSaladLine(ArrayList<String> productsWithCalories) {
        System.out.println("INCOMING: " + productsWithCalories);
        int prodSize = productsWithCalories.size();
        HashMap<Vegetable, Integer> products = new HashMap<>();

        for (int i = 0; i < prodSize; i++) {
            String[] prod = productsWithCalories.get(i).split("\\s+");
            String name = prod[0].toUpperCase();
            Vegetable vegetable;
            switch (name) {
                case "TOMATO":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name(),20);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "PEPPER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.PEPPER.name(),30);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "CUCUMBER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.CUCUMBER.name(),10);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "PARSLEY":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.PARSLEY.name(),15);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "LETTUCE":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name(),30);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "ARAGULA":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.ARAGULA.name(),40);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "POTATOES":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "CARROT":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.CARROT.name(),50);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                case "ONION":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.ONION.name(),11);
                    setKeepingTimeForVegetable(vegetable);
                    break;
                default:
                    vegetable = null;
            }
            if (vegetable != null) {
                products.put(vegetable, Integer.parseInt(prod[1]));


            }
        }

    return products;
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
