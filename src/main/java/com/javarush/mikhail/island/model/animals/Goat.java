package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Goat extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Goat() {
        super("Коза", 60, 10, 3, 140, CHANCES);
    }
}