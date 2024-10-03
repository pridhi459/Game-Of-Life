package com.GameOfLife.service;

import com.GameOfLife.entities.Cell;

public class IOHelper {

    public static void print(Cell[][] board){
        for (Cell[] cells : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(cells[j].printCell() + " ");
            }
            System.out.println();
        }
    }
}
