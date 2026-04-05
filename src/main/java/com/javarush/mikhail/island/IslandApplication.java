package com.javarush.mikhail.island;

import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.service.InitialPopulationService;
import com.javarush.mikhail.island.model.animals.*;
import com.javarush.mikhail.island.simulation.SimulationEngine;

import java.util.List;

public class IslandApplication {

    public static void main(String[] args) throws InterruptedException {

        Island island = new Island(100, 100);

        List<Class<? extends com.javarush.mikhail.island.model.Animal>> animalTypes = List.of(
                Bear.class,
                Boa.class,
                Boar.class,
                Buffalo.class,
                Caterpillar.class,
                Deer.class,
                Duck.class,
                Eagle.class,
                Fox.class,
                Goat.class,
                Horse.class,
                Mouse.class,
                Rabbit.class,
                Sheep.class,
                Wolf.class
        );

        InitialPopulationService popService = new InitialPopulationService(island, animalTypes);
        popService.populate(300);

        SimulationEngine engine = new SimulationEngine(island);
        engine.start();
    }
}