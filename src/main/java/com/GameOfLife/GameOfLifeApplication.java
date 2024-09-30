package com.GameOfLife;

import com.GameOfLife.service.GameStarter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameOfLifeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOfLifeApplication.class, args);

		 GameStarter.beginGame(5,5,20);
	}

}
