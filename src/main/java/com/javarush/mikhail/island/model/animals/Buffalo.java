package com.javarush.mikhail.island.model.animals;



import com.javarush.mikhail.island.model.Herbivore;

import java.util.Map;

public class Buffalo extends Herbivore {

    private static final Map<String, Integer> CHANCES = Map.of("Plant", 100);

    public Buffalo() {
        super("Буйвол", 700, 100, 3, 10, CHANCES);
    }
}
