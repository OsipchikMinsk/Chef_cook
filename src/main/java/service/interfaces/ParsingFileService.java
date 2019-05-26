package service.interfaces;

import entity.Vegetable;

import java.util.ArrayList;
import java.util.HashMap;

public interface ParsingFileService {
    public ArrayList<ArrayList> getSalads(String path);
    public HashMap<Vegetable, Integer> getProductFromSaladLine(ArrayList<String>  productsWithCalories);
}
