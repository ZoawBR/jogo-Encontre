package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import controller.ControladorDeObjetos;
import controller.ControleJpanel;
import controller.ControlePersonagem;
import controller.ControleTiro;
import controller.Game;


public class Personagem extends Sprite {
	
	private static final float VELOCIDADE =  (float) 4.0;
	private static final int HEALTH = 100;
	private static final int MUNICAO = 30;

	private int municao;
	private int health;
	private float velocidade;
	private int bolas;
		
	private boolean respondendo = false;
	
	private Game game;
	private ControlePersonagem controlePlayer;
	
	
	private int objetivos = 0;
		
	public Personagem(Game game, String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.game = game;
		health = HEALTH;
		velocidade = VELOCIDADE;
		municao = MUNICAO;
		controlePlayer = new ControlePersonagem(game, this);
		
	}
	
	public void animar() {
		if (game.getKeyPrincipal().up) {
			if(getAparencia() > 5 || getAparencia() < 3)
				setAparencia(3);
		}
		 if (game.getKeyPrincipal().down) {
			if(getAparencia() > 2)
				setAparencia(0);
		}
		 if (game.getKeyPrincipal().left) {
			if(getAparencia() > 8 || getAparencia() < 6)
				setAparencia(6);
		}
		 if (game.getKeyPrincipal().right) {
			if(getAparencia() > 11 || getAparencia() < 9)
				setAparencia(9);
		}
		if (game.getKeyPrincipal().up && game.getKeyPrincipal().left) {
			if(getAparencia() > 17 || getAparencia() < 15)
				setAparencia(15);
		}
		 if (game.getKeyPrincipal().up && game.getKeyPrincipal().right) {
			if(getAparencia() > 14 || getAparencia() < 12)
				setAparencia(12);
		}
		 if (game.getKeyPrincipal().down && game.getKeyPrincipal().left) {
			if(getAparencia() > 20 || getAparencia() < 18)
				setAparencia(18);
		}
		 if (game.getKeyPrincipal().down && game.getKeyPrincipal().right) {
			if(getAparencia() > 23 || getAparencia() < 21)
				setAparencia(21);
		}
	
	}
	
	
	public int getHealth() {
		return health;
	}

	public int getBolas() {
		return bolas;
	}

	public void setBolas(int bolas) {
		this.bolas = bolas;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isRespondendo() {
		return respondendo;
	}

	public void setRespondendo(boolean respondendo) {
		this.respondendo = respondendo;
	}

	public ControlePersonagem getControlePlayer() {
		return controlePlayer;
	}

	public float getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}


	public int getMunicao() {
		return municao;
	}


	public void setMunicao(int municao) {
		this.municao = municao;
	}


	public int getObjetivos() {
		return objetivos;
	}


	public void setObjetivos(int objetivos) {
		this.objetivos = objetivos;
	}
	
}


