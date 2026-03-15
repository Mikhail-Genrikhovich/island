package com.javarush.mikhail.island.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Getter
public class Location {

    private final int x;
    private final int y;

    private final Plant plant;

    private final Map<Class<? extends Animal>, List<Animal>> animalsByType;


    private static final int MAP_INITIAL_CAPACITY = 15;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.plant = new Plant();
        this.animalsByType = new ConcurrentHashMap<>(MAP_INITIAL_CAPACITY);
    }

    public void addAnimal(Animal animal) {

        animalsByType.computeIfAbsent(animal.getClass(),
                k -> new CopyOnWriteArrayList<>(new ArrayList<>(animal.getMaxCount()))
        );

        List<Animal> list = animalsByType.get(animal.getClass());

        if (list.size() >= animal.getMaxCount()) {
            return;
        }

        list.add(animal);
    }

    public void removeAnimal(Animal animal) {
        List<Animal> list = animalsByType.get(animal.getClass());
        if (list != null) {
            list.remove(animal);
        }
    }

    public List<Animal> getAnimalsByType(Class<? extends Animal> animalClass) {
        return animalsByType.getOrDefault(animalClass, List.of());
    }

    public List<Animal> getAllAnimals() {
        List<Animal> all = new ArrayList<>();
        for (List<Animal> list : animalsByType.values()) {
            all.addAll(list);
        }
        return all;
    }

    public int getTotalAnimalsCount() {
        return animalsByType.values().stream().mapToInt(List::size).sum();
    }
}