package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Sheep extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Sheep() {
        super("Овца", 70, 15, 3, 140, CHANCES);
    }
}