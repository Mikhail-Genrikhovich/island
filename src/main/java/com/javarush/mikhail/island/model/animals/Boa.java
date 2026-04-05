package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Predator;

import java.util.Map;

public class Boa extends Predator {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Duck",  10,
            "Fox",   15,
            "Mouse", 40,
            "Rabbit",20
    );

    public Boa() {
        super("Удав", 15, 3, 1, 30,  CHANCES);
    }
}