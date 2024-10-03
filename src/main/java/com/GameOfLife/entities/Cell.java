package com.GameOfLife.entities;

import com.GameOfLife.enums.CellState;

public class Cell {

    private CellState state;

    public Cell() {
        this.state = CellState.DEAD;
    }

    public void cellNextGeneration(int aliveNeighbours) {
        if (this.isAlive()) {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                this.kill();
            }
        } else {
            if (aliveNeighbours == 3) {
                this.makeAlive();
            }
        }
    }

    public void kill() {
        this.state = CellState.DEAD;
    }

    public void makeAlive() {
        this.state = CellState.ALIVE;
    }

    public boolean isAlive() {
        return this.state == CellState.ALIVE;
    }

    public char printCell() {
        return state.getSymbol();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return state == cell.state;
    }
}
