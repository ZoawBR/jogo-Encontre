package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import controller.ControladorDeObjetos;
import controller.ControleMunicao;
import controller.Game;

public class Municao extends Sprite{
	private ControleMunicao controleMunicaoMapa;
	private boolean usado= false;
	
	private static int MUNICAO = 10;
	
	private int municao;
	
	public Municao(String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.municao = MUNICAO;
		controleMunicaoMapa = new ControleMunicao(this);
	}
	
	public boolean isUsado() {
		return usado;
	}
	

	public static int getMUNICAO() {
		return MUNICAO;
	}

	public static void setMUNICAO(int mUNICAO) {
		MUNICAO = mUNICAO;
	}

	public int getMunicao() {
		return municao;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public ControleMunicao getControleMunicaoMapa() {
		return controleMunicaoMapa;
	}
	
}
