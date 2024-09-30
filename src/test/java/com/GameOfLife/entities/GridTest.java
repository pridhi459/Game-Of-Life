package com.GameOfLife.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @Test
    void testGridCreation() {
        Grid grid = new Grid(3, 3);
        grid.printGrid();
    }

    @Test
    void testSeedingGridFor5PercentPopulation(){
        Grid grid = new Grid(10, 10);
        grid = grid.randomSeeding(50);
        int seedCount= grid.countAliveCells();

        assertEquals(50, seedCount);
    }

    @Test
    void testSeedingGridForNegativePopulation(){
        Grid grid = new Grid(10, 10);
        grid = grid.randomSeeding(-200);
        int seedCount= grid.countAliveCells();
        grid.printGrid();

        assertEquals(0, seedCount);
    }

    @Test
    void testGridEquality(){
        Grid grid = new Grid(10, 10);
        Grid newGrid = new Grid(10, 10);
        assertEquals(grid, newGrid);
    }

    @Test
    void testGridInequalityAfterSeeding(){
        Grid grid = new Grid(10, 10);
        grid.randomSeeding(50);
        Grid newGrid = new Grid(5, 5);
        assertNotEquals(grid, newGrid);
    }

    @Test
    void testGridFor50PercentNextGeneration(){
        Grid grid = new Grid(10, 10);
        grid.randomSeeding(50);
        Grid newGrid = grid.nextGeneration();
        assertNotEquals(grid, newGrid);
    }

    @Test
    void testNumberOfAliveCellsInGrid10x10After20PercentSeeding(){
        Grid grid = new Grid(10, 10);
        grid.randomSeeding(20);
        int aliveCells = grid.countAliveCells();
        assertEquals(20, aliveCells);
    }



}