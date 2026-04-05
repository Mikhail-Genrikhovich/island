package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Duck extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Caterpillar", 90,
            "Plant",      100
    );

    public Duck() {
        super("Утка", 1, 0.15, 5, 200, CHANCES);
    }
}