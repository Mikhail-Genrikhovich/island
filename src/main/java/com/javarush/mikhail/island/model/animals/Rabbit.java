package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Rabbit extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Rabbit() {
        super("Кролик", 2, 0.45, 2, 150, CHANCES);
    }
}