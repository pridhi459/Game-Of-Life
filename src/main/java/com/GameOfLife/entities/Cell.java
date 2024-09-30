package com.GameOfLife.entities;

import com.GameOfLife.enums.cellState;

public class Cell {

    private cellState state;

    public Cell() {
        this.state = cellState.DEAD;
    }

    public void kill() {
        this.state = cellState.DEAD;
    }

    public void makeAlive() {
        this.state = cellState.ALIVE;
    }

    public boolean isAlive() {
        return this.state == cellState.ALIVE;
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
