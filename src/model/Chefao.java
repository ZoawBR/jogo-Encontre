package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import controller.ControladorDeObjetos;
import controller.ControleChefao;
import controller.Game;

public class Chefao extends Sprite{
	
	
	private static float VELOCIDADE =  (float) 5.0;
	private static int  HEALTH = 1000;
	private static int  DANO = 20;
	
	private  int health;
	protected float velocidade;	
	protected String direcao = "x";
	private static int dano;

	private ControleChefao controleChefao;
	
	public Chefao(Game game, String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.health = HEALTH;
		this.velocidade = VELOCIDADE;
		this.dano = DANO;
		controleChefao = new ControleChefao(game,this);	
		}


	public ControleChefao getControleChefao() {
		return controleChefao;
	}

	public void setControleChefao(ControleChefao controleChefao) {
		this.controleChefao = controleChefao;
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public static int getDano() {
		return dano;
	}

	public static void setDano(int dano) {
		Chefao.dano = dano;
	}
	
	

}
