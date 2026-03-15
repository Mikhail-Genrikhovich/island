package com.javarush.mikhail.island.model;

import java.util.Map;

public abstract class Predator extends Animal {
    public Predator(String type, double weight, double maxSatiety, int speed, int maxCount, Map<String, Integer> eatingChances) {
        super(type, weight, maxSatiety, speed, maxCount, eatingChances);
    }
}
