package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.NumerosPrimos;

public class ControleNumeros {
	
	private NumerosPrimos numero;
	private boolean passou = false;
	private Rectangle rec;
	
	public ControleNumeros(NumerosPrimos numero) {
		this.numero = numero;
	}
	
	public void draw(Graphics g) {
		g.drawImage(numero.getSprites()[numero.getAparencia()], numero.getPosX(),
				numero.getPosY(), numero.getHeight(), numero.getWidth(), null);
		
	}
	
	public void tick() {
		verificarColisao();
	}
	
	public void verificarColisao() {
		ControlePorta.setTextoJlabelPorta(" numeros primos");
		rec = new Rectangle(numero.getPosX(), numero.getPosY(), numero.getWidth(), numero.getHeight());
		if (ControladorDeColisoes.colisaoPlayer(rec)) {
			if (numero.isPrimo()) {
				numero.setNum_coletada(true);
				switch (numero.getNum()) {
				case 3:
					ControleJpanel.mudarJpanelMissao3();
					break;
				case 5:
					ControleJpanel.mudarJpanelMissao5();
					break;
				case 7:
					ControleJpanel.mudarJpanelMissao7();
					break;
		
				default:
					break;
				}
				ControladorDeObjetos.getPlayer().setObjetivos(ControladorDeObjetos.getPlayer().getObjetivos() + 1);
				ControladorDeObjetos.getPorta().getControlePorta().setAvisoMostrou(false);
			}else if (numero.isPrimo() == false){

				if (numero.isUsado() == false) {
					ControleJpanel.mudarJpanelMissaoQst();
					numero.setUsado(true);
				}
			}

		}else{
		}
	}

	public NumerosPrimos getNumero() {
		return numero;
	}

	public boolean isPassou() {
		return passou;
	}
	
}
