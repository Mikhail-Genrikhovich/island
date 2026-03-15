package com.javarush.mikhail.island.service;

import com.javarush.mikhail.island.model.Animal;
import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.model.Location;

import java.util.HashMap;
import java.util.Map;

public class StatisticsService {

    private final Island island;

    public StatisticsService(Island island) {
        this.island = island;
    }

    public void printStatistics(int tick) {

        Map<String, Integer> stats = new HashMap<>();
        int totalAnimals = 0;
        double plants = 0;

        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {

                Location location = island.getLocation(x, y);

                plants += location.getPlant().getWeight();

                for (Animal animal : location.getAllAnimals()) {
                    String type = animal.getClass().getSimpleName();
                    stats.put(type, stats.getOrDefault(type, 0) + 1);
                    totalAnimals++;
                }
            }
        }

        System.out.println("\n===== ТАКТ " + tick + " =====");

        for (var entry : stats.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("Всего животных: " + totalAnimals);
        System.out.println("Растения: " + plants);
    }

    public boolean isAllAnimalsDead() {
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                if (!island.getLocation(x, y).getAllAnimals().isEmpty()) return false;
            }
        }
        return true;
    }

    public boolean isIslandOverpopulated() {
        int animals = 0;
        for (int x = 0; x < island.getWidth(); x++) {
            for (int y = 0; y < island.getHeight(); y++) {
                animals += island.getLocation(x, y).getAllAnimals().size();
            }
        }
        int cells = island.getWidth() * island.getHeight();
        return animals > cells * 20;
    }
}