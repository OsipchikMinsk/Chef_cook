package entity;



public class Vegetable  implements Comparable<Vegetable> {
    private String name;
    private Double kiloCaloriesInG;//   1kKal iin 1 gramm

    public Vegetable(){

    }

    public Vegetable(String name, double kiloCaloriesInG) {
        this.name = name;
        this.kiloCaloriesInG = kiloCaloriesInG;
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
        return "[name: " + this.name + "  kiloCalories: " + this.kiloCaloriesInG +"]";
    }


    @Override
    public int compareTo(Vegetable o) {
        return kiloCaloriesInG.compareTo(o.getKiloCaloriesInG());
    }
}
