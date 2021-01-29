package controller;

import java.awt.Rectangle;

import model.Inimigo;

public class ControladorDeColisoes {

	public static boolean colisaoParede(Rectangle rec) {
		for(Rectangle rectangle : ControladorDeObjetos.getColisao()) {
			if(rectangle.intersects(rec)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean colisaoPlayer(Rectangle rec) {
		
		if(new Rectangle(ControladorDeObjetos.getPlayer().getPosX(), ControladorDeObjetos.getPlayer().getPosY(),
				ControladorDeObjetos.getPlayer().getWidth(), ControladorDeObjetos.getPlayer().getHeight()).intersects(rec)){
			
			return true;
		}
		return false;
	}
	
	public static boolean colisaoMonstro(Rectangle rec) {
		
		for(Inimigo inimigo : ControladorDeObjetos.getInimigos()) {
			if(new Rectangle(inimigo.posX+10, inimigo.posY+9, 
					inimigo.getWidth()-20, inimigo.getHeight()-9).intersects(rec)){
				return true;
			}
		}
		return false;
	}
	
}
