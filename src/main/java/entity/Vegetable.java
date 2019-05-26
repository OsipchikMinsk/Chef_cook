package entity;

public class Vegetable {
    private String name;
    private double kiloCaloriesInG;//   1kKal iin 1 gramm

    public Vegetable(){

    }

    public Vegetable(String name) {
        this.name = name;
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

    public void setKiloCaloriesInG(double kiloCaloriesInG) {
        this.kiloCaloriesInG = kiloCaloriesInG;
    }

    @Override
    public String toString() {
        return "[" + this.name + "]";
    }
}
