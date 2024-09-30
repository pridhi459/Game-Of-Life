package com.GameOfLife.service;

import com.GameOfLife.Exceptions.NeverEndingCycleException;
import com.GameOfLife.entities.Grid;

public class GameStarter {

    public static void beginGame(int rows, int columns, int seedingPercentage){
        Grid grid = new Grid(rows, columns);
        int gridLoopCount = 0;

        try{
            grid = grid.randomSeeding(seedingPercentage);
            grid.printGrid();
            while(true){
                Grid newGrid = grid.nextGeneration();
                newGrid.printGrid();
                if(newGrid.equals(grid) && gridLoopCount <5){
                    gridLoopCount++;
                    continue;
                }
                else if (gridLoopCount >= 5){
                    throw new NeverEndingCycleException("Infinite Loop Detected in");
                }
                else{
                    grid=newGrid;
                }
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (NeverEndingCycleException e){
            e.printStackTrace();
        }
    }
}
