package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import controller.ControladorDeObjetos;
import controller.ControlePorta;
import controller.Game;

public class Porta extends Sprite{
	private Game game;
	private ControlePorta controlePorta;
	
	public boolean entrou = false;
	
	public Porta(Game game, String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.game = game;
		controlePorta = new ControlePorta(this);
	}
	public boolean isEntrou() {
		return entrou;
	}
	public void setEntrou(boolean entrou) {
		this.entrou = entrou;
	}
	public ControlePorta getControlePorta() {
		return controlePorta;
	}
	

}
