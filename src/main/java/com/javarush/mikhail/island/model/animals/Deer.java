package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Deer extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Deer() {
        super("Олень", 300, 50, 4, 20, CHANCES);
    }
}