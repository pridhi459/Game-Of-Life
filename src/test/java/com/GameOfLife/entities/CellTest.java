package com.GameOfLife.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testCellCreation() {
        Cell cell = new Cell();
        assertTrue(cell.isAlive());
    }

    @Test
    void testUpdateState() {
        Cell cell = new Cell();
        cell.makeAlive();
        assertTrue(cell.isAlive());
    }

    @Test
    void testKillCell() {
        Cell cell = new Cell();
        cell.kill();
        assertFalse(cell.isAlive());
    }

    @Test
    void testPrintDeadCell() {
        Cell cell = new Cell();
        assertEquals('-', cell.printCell());
    }

    @Test
    void testPrintAliveCell() {
        Cell cell = new Cell();
        cell.makeAlive();
        assertEquals('*', cell.printCell());
    }

    @Test
    void testCellEqualityForNewlyCreatedCell(){
        Cell cell = new Cell();
        Cell newCell = new Cell();
        assertEquals(cell, newCell);
    }

    @Test
    void testCellInequalityAfterStateChange(){
        Cell cell = new Cell();
        Cell newCell = new Cell();
        newCell.makeAlive();
        assertNotEquals(cell, newCell);
    }

    @Test
    void testDeadCellNextGenerationFor3Neighbours(){
        Cell cell = new Cell();
        cell.cellNextGeneration(3);
        assertTrue(cell.isAlive());
    }

    @Test
    void testAliveCellNextGenerationFor2Neighbours(){
        Cell cell = new Cell();
        cell.makeAlive();
        cell.cellNextGeneration(2);
        assertTrue(cell.isAlive());
    }
}