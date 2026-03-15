package com.javarush.mikhail.island.simulation;

import com.javarush.mikhail.island.model.Island;
import com.javarush.mikhail.island.service.*;

import java.util.concurrent.*;

public class SimulationEngine {

    private static final int CORE_POOL_SIZE = 2;
    private static final int WORKER_THREADS = Runtime.getRuntime().availableProcessors();

    private final Island island;
    private final MoveService moveService;
    private final EatService eatService;
    private final ReproduceService reproduceService;
    private final ResetReproduceService resetService;
    private final DeathService deathService;
    private final PlantGrowService plantGrowService;
    private final StatisticsService statisticsService;

    private int tick = 0;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
    private final ExecutorService workerPool = Executors.newFixedThreadPool(WORKER_THREADS);

    public SimulationEngine(Island island) {
        this.island = island;
        moveService = new MoveService(island);
        eatService = new EatService(island);
        reproduceService = new ReproduceService(island);
        resetService = new ResetReproduceService(island);
        deathService = new DeathService(island);
        plantGrowService = new PlantGrowService(island);
        statisticsService = new StatisticsService(island);
    }

    public void start() {
        scheduler.scheduleAtFixedRate(this::tick, 0, 1, TimeUnit.SECONDS);
    }

    private void tick() {
        tick++;

        try {
            for (int x = 0; x < island.getWidth(); x++) {
                for (int y = 0; y < island.getHeight(); y++) {
                    int cx = x;
                    int cy = y;
                    workerPool.submit(() -> moveService.moveAnimals(cx, cy));
                }
            }
            workerPool.awaitTermination(100, TimeUnit.MILLISECONDS);

            // остальные сервисы
            eatService.eat();
            reproduceService.reproduce();
            resetService.reset();
            deathService.removeDead();
            plantGrowService.grow();

            statisticsService.printStatistics(tick);

            if (statisticsService.isAllAnimalsDead()) {
                System.out.println("Все животные вымерли");
                stop();
            }

            if (statisticsService.isIslandOverpopulated()) {
                System.out.println("Остров заполнен на 80%");
                stop();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void stop() {
        scheduler.shutdownNow();
        workerPool.shutdownNow();
    }
}