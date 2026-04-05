package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Predator;

import java.util.Map;

public class Fox extends Predator {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Caterpillar", 40,
            "Duck",        60,
            "Mouse",       90,
            "Rabbit",      70
    );

    public Fox() {
        super("Лиса", 8, 2, 2, 30,  CHANCES);
    }
}