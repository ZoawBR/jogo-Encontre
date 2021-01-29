package controller;

import java.awt.Graphics;
import java.awt.Rectangle;

import model.DataIndependencia;

public class ControleDataIndependencia {
	
	private DataIndependencia dataIndependencia;
	private Rectangle rec;

	public ControleDataIndependencia(DataIndependencia dataIndependencia) {
		this.dataIndependencia = dataIndependencia;
	}

	public void tick() {
		verificarColisao();
	}
	
	public void verificarColisao() {
		ControlePorta.setTextoJlabelPorta(" data(s)");
		rec = new Rectangle(dataIndependencia.getPosX(), dataIndependencia.getPosY(), dataIndependencia.getWidth(), dataIndependencia.getHeight());
		if (ControladorDeColisoes.colisaoPlayer(rec)) {
			if (dataIndependencia.isDataCorreta()) {
				dataIndependencia.setData_coletada(true);
				if (dataIndependencia.getData() == 7) {
					ControleJpanel.mudarJpanelMissaoDataDia();
				}
				if (dataIndependencia.getData() == 9) {
					ControleJpanel.mudarJpanelMissaoDataMes();
				}
			
				ControladorDeObjetos.getPlayer().setObjetivos(ControladorDeObjetos.getPlayer().getObjetivos() + 1);
				ControladorDeObjetos.getPorta().getControlePorta().setAvisoMostrou(false);
			}else if (dataIndependencia.isDataCorreta() == false){

				if (dataIndependencia.isUsado() == true) {
					ControleJpanel.mudarJpanelMissaoQst();
					dataIndependencia.setUsado(false);
				}
			}

		}else{
			ControleJpanel.mudarJpanelMissaoData();
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(dataIndependencia.getSprites()[dataIndependencia.getAparencia()], dataIndependencia.getPosX(),
				dataIndependencia.getPosY(), dataIndependencia.getHeight(), dataIndependencia.getWidth(), null);
	}
}
