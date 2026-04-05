package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Animal;
import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class InitialPopulationService {

    private final Island island;
    private final List<Class<? extends Animal>> animalTypes;

    public InitialPopulationService(Island island, List<Class<? extends Animal>> animalTypes) {
        this.island = island;
        this.animalTypes = animalTypes;
    }

    public void populate(int totalAnimals) {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for (int i = 0; i < totalAnimals; i++) {

            int x = random.nextInt(island.getWidth());
            int y = random.nextInt(island.getHeight());
            Location location = island.getLocation(x, y);

            Class<? extends Animal> type = animalTypes.get(random.nextInt(animalTypes.size()));

            try {
                Animal animal = type.getDeclaredConstructor().newInstance();

                if (location.getAllAnimals().size() < animal.getMaxCount()) {
                    location.addAnimal(animal);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}