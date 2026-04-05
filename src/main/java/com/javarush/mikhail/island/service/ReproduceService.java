package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Animal;
import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ReproduceService {

    private final Island island;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public ReproduceService(Island island) {
        this.island = island;
    }

    public void reproduce() {
        int width = island.getWidth();
        int height = island.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = island.getLocation(x, y);
                List<Animal> animals = new ArrayList<>(location.getAllAnimals());

                for (Animal animal : animals) {
                    if (!animal.isAlive() || animal.isHasReproducedThisTurn()) continue;

                    int chance = random.nextInt(100);
                    if (chance < 50) {
                        try {
                            Animal baby = animal.getClass().getDeclaredConstructor().newInstance();
                            if (location.getAllAnimals().size() < animal.getMaxCount()) {
                                location.addAnimal(baby);

                                double newSatiety = Math.max(0, animal.getSatiety() * 0.7);
                                animal.setSatiety(newSatiety);
                                animal.setHasReproducedThisTurn(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}