package com.GameOfLife.enums;

public enum CellState {
    DEAD('-'), ALIVE('*');

    private char symbol;
    CellState(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
