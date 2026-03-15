package com.javarush.mikhail.island.model;

import java.util.Map;

public abstract class Herbivore extends Animal {
    public Herbivore(String type, double weight, double maxSatiety, int speed, int maxCount, Map<String, Integer> eatingChances) {
        super(type, weight, maxSatiety, speed, maxCount, eatingChances);
    }
}
