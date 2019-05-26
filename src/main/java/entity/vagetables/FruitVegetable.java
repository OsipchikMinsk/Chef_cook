package entity.vagetables;

import entity.Vegetable;

public class FruitVegetable extends Vegetable {
    final private int KEEPING_TIME = 20;

    public FruitVegetable(String name) {
        super(name);
    }
    public FruitVegetable(){

    }

    public int getKeepingTime() {
        return KEEPING_TIME;
    }

  public  enum listOfFruitVegetable {
        TOMATO,
        PEPPER,
        CUCUMBER
    }

}


