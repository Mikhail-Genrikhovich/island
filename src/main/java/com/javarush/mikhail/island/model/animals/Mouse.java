package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Mouse extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Caterpillar", 90,
            "Plant",      100
    );

    public Mouse() {
        super("Мышь", 0.05, 0.01, 1, 500, CHANCES);
    }
}