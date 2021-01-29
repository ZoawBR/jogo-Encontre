package model;

import java.io.File;
import java.io.IOException;

import controller.ControleBau;
import controller.Game;

public class Bau extends Sprite{
	
	private ControleBau controleBau;
	
	private boolean bauAberto = false;
	private BolaDeFogo poder;
	
	public Bau(Game game, String file, int aparencia, int columns, int rows, int posX, int posY) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		controleBau = new ControleBau(game, this);
	}
	
	
	public void animar() {
		if (bauAberto == true) {
			setAparencia(1);
		}
	}


	public boolean isBauAberto() {
		return bauAberto;
	}


	public void setBauAberto(boolean bauAberto) {
		this.bauAberto = bauAberto;
	}


	public ControleBau getControleBau() {
		return controleBau;
	}
	
}
