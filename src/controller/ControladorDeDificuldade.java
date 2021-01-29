package controller;

import model.Cura;
import model.Inimigo;
import model.Municao;
import model.Tiro;

public class ControladorDeDificuldade {

	public static void modoFacil(){
		Inimigo.setVELOCIDADE(2);
		Inimigo.setDANO(2);
		Inimigo.setHEALTH(80);
		
		Tiro.setDANO(25);
		Tiro.setVELOCIDADE_TIRO(6);
		
		Cura.setCURA(25);
		
		Municao.setMUNICAO(15);
	}
	
	public static void modoMedio(){
		/// JÁ É MEDIO POR PADRAO ///
	}

	public static void modoDificil(){
		Inimigo.setVELOCIDADE(5);
		Inimigo.setDANO(4);
		Inimigo.setHEALTH(120);
		
		Tiro.setDANO(20);
		
		Cura.setCURA(15);
		
		Municao.setMUNICAO(8);
	}
}
