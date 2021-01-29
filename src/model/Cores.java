package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import controller.ControladorDeObjetos;
import controller.ControleCura;
import controller.ControleJpanel;
import controller.ControleCores;
import controller.Game;

public class Cores extends Sprite {
	
	private boolean cor_primaria;
	private String cor;
	private boolean cor_coletada;
	private boolean usado = false;
	
	private ControleCores controleMissaoCores;
	
	public Cores(String file, int aparencia, int columns, int rows, int posX, int posY, boolean cor_primaria, String cor) throws IOException {
		super(file, aparencia, columns, rows, posX, posY);
		this.cor_primaria = cor_primaria;
		this.cor = cor;
		controleMissaoCores = new ControleCores(this);
	}
	

	public boolean isCor_coletada() {
		return cor_coletada;
	}

	public boolean isCor_primaria() {
		return cor_primaria;
	}


	public ControleCores getControleMissaoCores() {
		return controleMissaoCores;
	}


	public void setControleMissaoCores(ControleCores controleMissaoCores) {
		this.controleMissaoCores = controleMissaoCores;
	}


	public boolean isUsado() {
		return usado;
	}


	public void setUsado(boolean usado) {
		this.usado = usado;
	}


	public void setCor_primaria(boolean cor_primaria) {
		this.cor_primaria = cor_primaria;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public boolean isMensagem() {
		return usado;
	}


	public void setMensagem(boolean mensagem) {
		this.usado = mensagem;
	}


	public void setCor_coletada(boolean cor_coletada) {
		this.cor_coletada = cor_coletada;
	}

}
