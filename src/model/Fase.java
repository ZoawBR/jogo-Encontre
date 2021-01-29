package model;

import java.awt.Graphics;

import controller.Game;

public abstract class Fase {
	
	private static Fase faseAtual = null;

	public static Fase getFaseAtual() {
		return faseAtual;
	}
	public static void setFaseAtual(Fase faseAtual) {
		Fase.faseAtual = faseAtual;
	}
	
	protected Game game;
	
	public Fase(Game game) {
		this.game = game;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	
}
