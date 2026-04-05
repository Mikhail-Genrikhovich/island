package com.javarush.mikhail.island.model.animals;

import com.javarush.mikhail.island.model.Predator;

import java.util.Map;

public class Bear extends Predator {

    private static final Map<String, Integer> CHANCES = Map.of(
            "Boa",     80,
            "Boar",    50,
            "Buffalo", 20,
            "Deer",    80,
            "Duck",    10,
            "Goat",    70,
            "Horse",   40,
            "Mouse",   90,
            "Rabbit",  80,
            "Sheep",   70
    );

    public Bear() {
        super("Медведь", 500, 80, 2, 5,  CHANCES);
    }
}