package com.javarush.mikhail.island.model;

import lombok.Getter;

@Getter
public class Island {
    private final Location[][] locations;
    private final int width;
    private final int height;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[width][height];
        initLocations();
    }

    private void initLocations() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                locations[x][y] = new Location(x, y);
            }
        }
    }

    public Location getLocation(int x, int y) {
        return locations[x][y];
    }
}

