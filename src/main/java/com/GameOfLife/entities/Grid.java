package com.GameOfLife.entities;

import com.GameOfLife.Exceptions.InvalidSeedingPopulationException;
import com.GameOfLife.service.IOHelper;

public class Grid {

    private Cell[][] board;

    public Grid(int rows, int columns) {
        board = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Grid(int rows, int columns,int populationPercentage) {
        board = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Cell();
            }
        }
        randomSeeding(populationPercentage);
    }

    public Grid randomSeeding(int populationPercentage) {
        try {
            if (populationPercentage < 0 || populationPercentage > 100) {
                throw new InvalidSeedingPopulationException("Population percentage should be between 0 and 100");
            }
            int seededCells = (int) Math.ceil((populationPercentage / 100.0) * (board.length * board[0].length));

            for (int i = 0; i < seededCells; i++) {
                int row = (int) (Math.random() * this.board.length);
                int column = (int) (Math.random() * board[0].length);
                if (this.board[row][column].isAlive()) {
                    i--;
                    continue;
                }
                this.board[row][column].makeAlive();
            }
        } catch (InvalidSeedingPopulationException e) {
            System.out.println(e.getMessage());
        }
        return this;
    }

    public void printGrid() {
        IOHelper.print(this.board);
    }

    public int countAliveCells() {
        int aliveCells = 0;
        for (Cell[] cells : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (cells[j].isAlive()) {
                    aliveCells++;
                }
            }
        }
        return aliveCells;
    }

    public Grid nextGeneration() {
        Grid newGrid = new Grid(this.board.length, board[0].length);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int aliveNeighbours = countAliveNeighbours(i, j);
                newGrid.board[i][j].cellNextGeneration(aliveNeighbours);
            }
        }
       // printGrid();
        return newGrid;
    }

    private int countAliveNeighbours(int i, int j) {
        int aliveNeighbours = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !(x == i && y == j)) {
                    if (board[x][y].isAlive()) {
                        aliveNeighbours++;
                    }
                }
            }
        }
        return aliveNeighbours;
    }

    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid = (Grid) o;
        if (board.length != grid.board.length || board[0].length != grid.board[0].length) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!board[i][j].equals(grid.board[i][j])) return false;
            }
        }
        return true;
    }
}
