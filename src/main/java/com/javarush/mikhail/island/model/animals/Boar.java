package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Boar extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Caterpillar", 90,
            "Mouse",       50,
            "Plant",      100
    );

    public Boar() {
        super("Кабан", 400, 50, 2, 50, CHANCES);
    }
}