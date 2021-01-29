package controller;

import model.Som;

public class ControleGame {
	Game game;
	public ControleGame() {
		game = new Game("Encontre!", 1024, 712);
		game.start();
	}
	public Game getGame() {
		return game;
	}
}
