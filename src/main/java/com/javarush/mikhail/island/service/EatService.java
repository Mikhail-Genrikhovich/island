package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EatService {

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();
    private final Island island;

    public EatService(Island island) {
        this.island = island;
    }

    public void eat() {
        int width = island.getWidth();
        int height = island.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Location location = island.getLocation(x, y);
                List<Animal> animals = location.getAllAnimals();

                for (Animal animal : animals) {
                    if (!animal.isAlive()) continue;

                    if (animal instanceof Predator) {
                        eatAnimals(animal, location);
                    } else if (animal instanceof Herbivore) {
                        eatPlants(animal, location.getPlant());
                    }
                }
            }
        }
    }

    private void eatAnimals(Animal predator, Location location) {
        Map<String, Integer> chances = predator.getEatingChances();

        for (Animal prey : location.getAllAnimals()) {
            if (!prey.isAlive() || prey == predator) continue;

            String preyType = prey.getClass().getSimpleName();
            Integer chance = chances.get(preyType);
            if (chance == null) continue;

            int roll = random.nextInt(100) + 1;
            if (roll <= chance) {
                location.removeAnimal(prey);
                prey.setAlive(false);

                double newSatiety = Math.min(predator.getMaxSatiety(),
                        predator.getSatiety() + prey.getMaxSatiety() / 2);
                predator.setSatiety(newSatiety);

                break;
            }
        }
    }

    private void eatPlants(Animal herbivore, Plant plant) {
        if (plant.getWeight() <= 0) return;

        double eatAmount = Math.min(plant.getWeight(), herbivore.getMaxSatiety() - herbivore.getSatiety());
        if (eatAmount <= 0) return;

        plant.setWeight(plant.getWeight() - eatAmount);
        herbivore.setSatiety(herbivore.getSatiety() + eatAmount);
    }
}