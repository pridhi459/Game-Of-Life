package com.GameOfLife.enums;

public enum cellState {
    DEAD('-'), ALIVE('*');

    private char symbol;
    cellState(char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return this.symbol;
    }
}
