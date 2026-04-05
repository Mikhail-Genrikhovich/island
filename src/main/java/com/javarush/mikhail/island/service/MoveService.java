package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Animal;
import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MoveService {

    private final Island island;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public MoveService(Island island) {
        this.island = island;
    }

    public void moveAnimals(int x, int y) {
        Location current = island.getLocation(x, y);
        List<Animal> animals = new ArrayList<>(current.getAllAnimals());

        for (Animal animal : animals) {
            tryMoveAnimal(animal, x, y);
        }
    }

    private void tryMoveAnimal(Animal animal, int currentX, int currentY) {

        int speed = animal.getSpeed();
        if (speed <= 0) return;

        int steps = random.nextInt(speed + 1);
        if (steps == 0) return;

        int direction = random.nextInt(4);
        int newX = currentX;
        int newY = currentY;

        switch (direction) {
            case 0 -> newY = Math.max(0, currentY - steps);
            case 1 -> newY = Math.min(island.getHeight() - 1, currentY + steps);
            case 2 -> newX = Math.max(0, currentX - steps);
            case 3 -> newX = Math.min(island.getWidth() - 1, currentX + steps);
        }

        if (newX == currentX && newY == currentY) return;

        Location oldLocation = island.getLocation(currentX, currentY);
        Location newLocation = island.getLocation(newX, newY);

        if (newLocation.getAllAnimals().size() < animal.getMaxCount()) {
            oldLocation.removeAnimal(animal);
            newLocation.addAnimal(animal);

            double loss = animal.getMaxSatiety() * 0.1;
            double newSatiety = Math.max(0, animal.getSatiety() - loss);
            animal.setSatiety(newSatiety);

            if (newSatiety <= 0) animal.setAlive(false);
        }
    }
}