package com.javarush.mikhail.island.model;


import lombok.*;

import java.util.Map;

@Setter
@Getter
public abstract class Animal {

    private final String type;
    private final double weight;
    private final double maxSatiety;
    private final int speed;
    private final int maxCount;
    private final Map<String, Integer> eatingChances;
    private double satiety;
    private boolean alive;
    private boolean hasReproducedThisTurn;

    public Animal(String type, double weight, double maxSatiety, int speed, int maxCount, Map<String, Integer> eatingChances) {
        this.type = type;
        this.weight = weight;
        this.maxSatiety = maxSatiety;
        this.speed = speed;
        this.maxCount = maxCount;
        this.satiety = maxSatiety;
        this.alive = true;
        this.hasReproducedThisTurn = false;
        this.eatingChances = eatingChances;
    }
}
