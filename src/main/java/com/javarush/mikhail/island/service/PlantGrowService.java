package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;
import com.javarush.mikhail.island.model.Plant;

public class PlantGrowService {

    private final Island island;

    public PlantGrowService(Island island) {
        this.island = island;
    }

    public void grow() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                Plant plant = location.getPlant();

                double newWeight = Math.min(Plant.MAX_WEIGHT, plant.getWeight() + 5);
                plant.setWeight(newWeight);
            }
        }
    }
}