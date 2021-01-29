package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import controller.ControleInimigo;
import controller.Game;

public class Inimigo extends Sprite{
	private static float VELOCIDADE =  (float) 4.0;
	private static int  HEALTH = 100;
	private static int  DANO = 3;

	
	private Game game;
	private Thread thread;
	
	private  int health;
	protected float velocidade;	
	protected String direcao;
	
	private ControleInimigo controleInimigo;
	
	public Inimigo(String direcao, Game game, String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.game = game;
		this.health = HEALTH;
		this.direcao = direcao;
		this.velocidade = VELOCIDADE;
		controleInimigo = new ControleInimigo(game, this);
		
	}

	public void animar() {
		if (direcao.equals("-x")) {
		
			if(getAparencia() > 8 || getAparencia() < 6)
				setAparencia(6);
			
		}
			
		if (direcao.equals("x")) {
	
			if(getAparencia() > 11 || getAparencia() < 9)
				setAparencia(9);
				
			
		}
		if (direcao.equals("-y")) {
			if(getAparencia() > 5 || getAparencia() < 3)
				setAparencia(3);
			
		}
		
		if (direcao.equals("y")) {
			
			if(getAparencia() > 2 || getAparencia() < 0)
				setAparencia(0);
			
			
		}
		
	}
	
	
	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}


	public static int getDano() {
		return DANO;
	}
	

	public static float getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(float vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public static int getHEALTH() {
		return HEALTH;
	}

	public static void setHEALTH(int hEALTH) {
		HEALTH = hEALTH;
	}

	public static int getDANO() {
		return DANO;
	}

	public static void setDANO(int dANO) {
		DANO = dANO;
	}

	public ControleInimigo getControleInimigo() {
		return controleInimigo;
	}

	public void setControleInimigo(ControleInimigo controleInimigo) {
		this.controleInimigo = controleInimigo;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public String getDirecao() {
		return direcao;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

}
