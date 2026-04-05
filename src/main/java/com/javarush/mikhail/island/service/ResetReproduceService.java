package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Animal;
import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;

import java.util.List;

public class ResetReproduceService {

    private final Island island;

    public ResetReproduceService(Island island) {
        this.island = island;
    }

    public void reset() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                Location location = island.getLocation(x, y);
                List<Animal> animals = location.getAllAnimals();

                for (Animal animal : animals) {
                    animal.setHasReproducedThisTurn(false);
                }
            }
        }
    }
}