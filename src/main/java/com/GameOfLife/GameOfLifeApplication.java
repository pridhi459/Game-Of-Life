package com.GameOfLife;

import com.GameOfLife.Exceptions.NeverEndingCycleException;
import com.GameOfLife.entities.Grid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfLifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameOfLifeApplication.class, args);

        try {
            Grid grid = new Grid(5, 5, 50);
            grid.printGrid();
            while (true) {
                Grid newGrid = grid.nextGeneration();
                newGrid.printGrid();
                if (grid.countAliveCells() == 0) {
                    System.out.println("All Cells are Dead");
                    break;
                }
                if (newGrid.equals(grid)) {
                    throw new NeverEndingCycleException("Infinite Loop Detected in");
                } else {
                    grid = newGrid;
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException | NeverEndingCycleException e) {
            e.printStackTrace();
        }
    }

}
