package entity;



public class Vegetable  {//
    private String name;
    private Double kiloCaloriesInG;//   1kKal in 1 gramm
    private int keepingTime;

    public Vegetable(){

    }

    public Vegetable(int keepingTime) {
        this.keepingTime = keepingTime;
    }

    public Vegetable(String name, Double kiloCaloriesInG, int keepingTime) {
        this.name = name;
        this.kiloCaloriesInG = kiloCaloriesInG;
        this.keepingTime = keepingTime;
    }

    public Vegetable(String name, double kiloCaloriesInG) {
        this.name = name;
        this.kiloCaloriesInG = kiloCaloriesInG;
    }

    public int getKeepingTime() {
        return keepingTime;
    }

    public void setKeepingTime(int keepingTime) {
        this.keepingTime = keepingTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKiloCaloriesInG() {
        return kiloCaloriesInG;
    }

    public void setKiloCaloriesInG(Double kiloCaloriesInG) {
        this.kiloCaloriesInG = kiloCaloriesInG;
    }

    @Override
    public String toString() {
        return "[name: " + this.name + "  kiloCalories: " + this.kiloCaloriesInG + " keepingTime: " + this.keepingTime + "]";
    }



}
