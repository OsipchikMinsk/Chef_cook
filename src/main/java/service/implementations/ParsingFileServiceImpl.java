package service.implementations;

import entity.Vegetable;
import entity.vagetables.FruitVegetable;
import entity.vagetables.GreenVegetable;
import entity.vagetables.RootVegetable;
import service.interfaces.ParsingFileService;

import java.io.File;
import java.io.FileNotFoundException;
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
//                salad.addAll(Arrays.asList(line).subList(1, line.length));
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
                    break;
                case "PEPPER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.PEPPER.name(),30);
                    break;
                case "CUCUMBER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.CUCUMBER.name(),10);
                    break;
                case "PARSLEY":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.PARSLEY.name(),15);
                    break;
                case "LETTUCE":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name(),30);
                    break;
                case "ARAGULA":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.ARAGULA.name(),40);
                    break;
                case "POTATOES":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name(),60);
                    break;
                case "CARROT":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.CARROT.name(),50);
                    break;
                case "ONION":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.ONION.name(),11);
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
}
