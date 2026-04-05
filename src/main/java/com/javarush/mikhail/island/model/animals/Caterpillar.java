package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Caterpillar extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Caterpillar() {
        super("Гусеница", 0.01, 0, 0, 1000, CHANCES);
    }
}