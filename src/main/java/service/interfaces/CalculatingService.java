package service.interfaces;

import entity.Salad;

public interface CalculatingService {
    public double calculateKiloCalories(Salad salad);
    public void sortByKiloCalories();
    public void sortByKiloCaloriesAndKeepingTime();
}
