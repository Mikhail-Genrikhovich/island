package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Predator;

import java.util.Map;

public class Eagle extends Predator {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Duck",  80,
            "Fox",   10,
            "Mouse", 90,
            "Rabbit",90
    );

    public Eagle() {
        super("Орел", 6, 1, 3, 20,  CHANCES);
    }
}