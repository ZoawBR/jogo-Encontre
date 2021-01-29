package controller;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import model.Cura;
import model.Sprite;

public class ControleCura{

	private Cura cura;
	
	public ControleCura(Cura cura) {
		this.cura = cura;
	}
	
	public void tick() {
		verificarColisao();
	}
	
	public void verificarColisao() {
		if (ControladorDeColisoes.colisaoPlayer(colisaoPlayer())) {
			if (ControladorDeObjetos.getPlayer().getHealth() == 100) {
				/// JÁ TA COM 100 ENTAO NAO PEGA ///
				cura.setUsado(false);
			}else {
				if (ControladorDeObjetos.getPlayer().getHealth() + cura.getCura() > 100) {
					ControladorDeObjetos.getPlayer().setHealth(100);
					cura.setUsado(true);
				}else if (ControladorDeObjetos.getPlayer().getHealth() + cura.getCura() < 100) {
					ControladorDeObjetos.getPlayer().setHealth(ControladorDeObjetos.getPlayer().getHealth() + cura.getCura());
					cura.setUsado(true);
				}
			}
		}
	}
	
	public void draw(Graphics g) {
		g.drawImage(cura.getSprites()[cura.getAparencia()], cura.getPosX(),
				cura.getPosY(), cura.getHeight(), cura.getWidth(), null);
		
	}
	
	public Rectangle colisaoPlayer() {
		Rectangle thiscura = new Rectangle(cura.getPosX()+10, cura.getPosY()+10, 
				cura.getWidth()-20, cura.getHeight()-10);
		return thiscura;
		
	}
	
}
