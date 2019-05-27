package entity.vagetables;

import entity.Vegetable;

public class RootVegetable extends Vegetable implements Comparable<Vegetable> {
    final private int KEEPING_TIME = 180;



    public RootVegetable(String name,double kiloCalories) {

        super(name,kiloCalories);
    }
    public RootVegetable(){

    }

    public int getKeepingTime() {
        return KEEPING_TIME;
    }

  public   enum listOfRootVegetable{
        POTATOES,
        CARROT,
        ONION
    }
}
