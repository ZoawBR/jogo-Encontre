package model;

import java.io.File;
import java.io.IOException;

import controller.ControleNumeros;

public class NumerosPrimos extends Sprite{

	private ControleNumeros controleMissaoNumeros;
	private boolean usado = false;
	private boolean num_coletada;
	private boolean isPrimo;
	private int num;
	
	public NumerosPrimos(int num,String file, int aparencia, int columns, int rows, int posX, int posY, boolean isPrimo)
			throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.isPrimo = isPrimo;
		this.num = num;
		this.controleMissaoNumeros = new ControleNumeros(this);
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public boolean isPrimo() {
		return isPrimo;
	}

	public boolean isNum_coletada() {
		return num_coletada;
	}

	public void setNum_coletada(boolean num_coletada) {
		this.num_coletada = num_coletada;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setPrimo(boolean isPrimo) {
		this.isPrimo = isPrimo;
	}

	public ControleNumeros getControleMissaoNumeros() {
		return controleMissaoNumeros;
	}

}
