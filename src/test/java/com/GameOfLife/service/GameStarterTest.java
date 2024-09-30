package com.GameOfLife.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameStarterTest {

    @Test
    void testGameStarter() {
        GameStarter.beginGame(3,3,50);
        int aliveCells=0;
    }

}