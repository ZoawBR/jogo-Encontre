package model;

import java.io.IOException;

import controller.ControleDataIndependencia;

public class DataIndependencia extends Sprite{

	private boolean data_coletada = false;
	private boolean dataCorreta;
	private boolean usado = true;
	private int data;
	
	ControleDataIndependencia controleDataIndependencia;
	
	public DataIndependencia(String file, int aparencia, int columns, int rows, int posX, int posY, int data,boolean isDataCorreta) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.dataCorreta = isDataCorreta;
		this.data = data;
		this.controleDataIndependencia = new ControleDataIndependencia(this);
	}

	public boolean isData_coletada() {
		return data_coletada;
	}

	public void setData_coletada(boolean data_coletada) {
		this.data_coletada = data_coletada;
	}

	public boolean isDataCorreta() {
		return dataCorreta;
	}
	
	

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public void setDataCorreta(boolean dataCorreta) {
		this.dataCorreta = dataCorreta;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public ControleDataIndependencia getControleDataIndependencia() {
		return controleDataIndependencia;
	}	
	
	
	
}
