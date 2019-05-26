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
            System.out.println("PROD :" + prod );
            String name = prod[0].toUpperCase();
            Vegetable vegetable;
            switch (name) {
                case "TOMATO":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.TOMATO.name());
                    break;
                case "PEPPER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.PEPPER.name());
                    break;
                case "CUCUMBER":
                    vegetable = new FruitVegetable(FruitVegetable.listOfFruitVegetable.CUCUMBER.name());
                    break;
                case "PARSLEY":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.PARSLEY.name());
                    break;
                case "LETTUCE":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.LETTUCE.name());
                    break;
                case "ARAGULA":
                    vegetable = new GreenVegetable(GreenVegetable.listOfGreenVegetable.ARAGULA.name());
                    break;
                case "POTATOES":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.POTATOES.name());
                    break;
                case "CARROT":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.CARROT.name());
                    break;
                case "ONION":
                    vegetable = new RootVegetable(RootVegetable.listOfRootVegetable.ONION.name());
                    break;
                default:
                    vegetable = null;
            }
           if (vegetable != null) {
                products.put(vegetable, Integer.parseInt(prod[1]));
                System.out.println("INSERT: " + vegetable.getName() + " : " + Integer.parseInt(prod[1]));
          }
        }
        System.out.println("AFTER:");
        System.out.println("------------------------------------------");
        for (Map.Entry<Vegetable, Integer> product : products.entrySet()) {
            System.out.println(product.getKey() + "/" + product.getValue());

        }
    return products;
    }
}
