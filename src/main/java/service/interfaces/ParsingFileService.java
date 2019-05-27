package service.interfaces;

import entity.Vegetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public interface ParsingFileService {
    public ArrayList<ArrayList> getSalads(String path);
    public HashMap<Vegetable, Integer> getProductFromSaladLine(ArrayList<String>  productsWithCalories);
}
