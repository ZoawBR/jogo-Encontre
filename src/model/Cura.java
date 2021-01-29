package model;

import java.io.File;
import java.io.IOException;

import controller.ControleCura;

public class Cura extends Sprite{

	private boolean usado;
	private static int CURA = 20;
	
	private int cura;
	
	private ControleCura controleCuraMapa;
	
	public Cura(String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.cura = CURA;
		controleCuraMapa = new ControleCura(this);
	}

	public static int getCURA() {
		return CURA;
	}

	public static void setCURA(int cURA) {
		CURA = cURA;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public int getCura() {
		return cura;
	}

	public void setCura(int cura) {
		this.cura = cura;
	}

	public ControleCura getControleCuraMapa() {
		return controleCuraMapa;
	}

	public void setControleCuraMapa(ControleCura controleCuraMapa) {
		this.controleCuraMapa = controleCuraMapa;
	}

}
