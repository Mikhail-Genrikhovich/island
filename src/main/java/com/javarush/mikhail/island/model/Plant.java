package com.javarush.mikhail.island.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Plant {
    public static final double MAX_WEIGHT = 200;
    private double weight;

    public Plant() {
        this.weight = 20.0;
    }

    public void grow(double amount) {
        weight = Math.min(MAX_WEIGHT, weight + amount);
    }

    public void decrease(double amount) {
        weight = Math.max(0, weight - amount);
    }

    public boolean isEaten() {
        return weight <= 0;
    }
}
