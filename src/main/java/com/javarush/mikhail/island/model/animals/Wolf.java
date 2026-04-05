package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Predator;

import java.util.Map;

public class Wolf extends Predator {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Boar",    15,
            "Buffalo", 10,
            "Deer",    15,
            "Duck",    40,
            "Goat",    60,
            "Horse",   10,
            "Mouse",   80,
            "Rabbit",  60,
            "Sheep",   70
    );

    public Wolf() {
        super("Волк", 50, 8, 3, 30,  CHANCES);
    }
}
