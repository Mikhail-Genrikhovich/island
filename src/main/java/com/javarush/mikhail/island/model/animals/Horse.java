package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Horse extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Horse() {
        super("Лошадь", 400, 60, 4, 20, CHANCES);
    }
}