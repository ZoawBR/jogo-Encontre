package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.Chefao;

public class ControleChefao {


	protected float xMover, yMover;
	protected ArrayList<String> direcoes;
	
	private Random r;

	
	private Chefao chefao;
	private Game game;
	
	public ControleChefao(Game game, Chefao chefao) {
		this.game = ControladorDeObjetos.getGame();
		this.chefao = chefao;
		direcoes = new ArrayList<String>();
		direcoes.add("x");
		direcoes.add("-x");
		direcoes.add("y");
		direcoes.add("-y");
		r = new Random();
	}
	

	public void input(String direcao) {
		xMover = 0;
		yMover = 0;
	
		if (direcao.equals("-x") && ControladorDeColisoes.colisaoPlayer(colisao("-x")) == true) {
			xMover = 0;
			atacar();
			chefao.setAparencia(chefao.getAparencia()+1);
			
		}
		else if (direcao.equals("-x") && ControladorDeColisoes.colisaoParede(colisao("-x")) == false) {
			xMover = -chefao.getVelocidade();
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		else if (direcao.equals("-x") && ControladorDeColisoes.colisaoParede(colisao("-x")) == true ) {
//			xMover = +inimigo.getVelocidade();
			chefao.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		
		if (direcao.equals("x") && ControladorDeColisoes.colisaoPlayer(colisao("x")) == true) {
			xMover = 0;
			atacar();
			chefao.setAparencia(chefao.getAparencia()+1);
			
		}
		else if (direcao.equals("x") && ControladorDeColisoes.colisaoParede(colisao("x")) == false ) {
			xMover = +chefao.getVelocidade();

			chefao.setAparencia(chefao.getAparencia()+1);

		}
		else if (direcao.equals("x") && ControladorDeColisoes.colisaoParede(colisao("x")) == true) {
//			xMover = -inimigo.getVelocidade();
			chefao.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		
		if (direcao.equals("-y") && ControladorDeColisoes.colisaoPlayer(colisao("-y")) == true) {
			yMover = 0;
			atacar();
			chefao.setAparencia(chefao.getAparencia()+1);
			
		}
		else if (direcao.equals("-y") && ControladorDeColisoes.colisaoParede(colisao("-y")) == false ) {
			yMover = -chefao.getVelocidade();
			chefao.setAparencia(chefao.getAparencia()+1);

		}else if (direcao.equals("-y") && ControladorDeColisoes.colisaoParede(colisao("-y")) == true ) {
//			yMover = +inimigo.getVelocidade();
			chefao.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		
		if (direcao.equals("y") && ControladorDeColisoes.colisaoPlayer(colisao("y")) == true) {
			yMover = 0;
			atacar();
			chefao.setAparencia(chefao.getAparencia()+1);
			
		}
		else if (direcao.equals("y") && ControladorDeColisoes.colisaoParede(colisao("y")) == false ) {
			yMover = +chefao.getVelocidade();
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		else if (direcao.equals("y") && ControladorDeColisoes.colisaoParede(colisao("y")) == true ) {
//			yMover = -inimigo.getVelocidade();
			chefao.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			chefao.setAparencia(chefao.getAparencia()+1);

		}
		
		mover();
	}
	
	public void tick() {
		verificarseMorreu();
		input(chefao.getDirecao());
	
	}
	
	public void verificarseMorreu() {
		if (chefao.getHealth() <= 0) {
			System.exit(0);
		}
	}
	
	public void mover() {
		
		chefao.setPosX(chefao.getPosX() + (int)xMover);
		chefao.setPosY(chefao.getPosY() + (int)yMover);
//		chefao.animar();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(chefao.getPosX(), chefao.getPosY()-5, 119, 3);
		g.setColor(Color.GREEN);
		g.fillRect(chefao.getPosX(), chefao.getPosY()-5, (chefao.getHealth()*119)/1000, 3);
		g.drawImage(chefao.getSprites()[0], chefao.getPosX(),
				chefao.getPosY(), chefao.getHeight(), chefao.getWidth(), null);
		
	}
	
	public void atacar() {
		if (ControladorDeObjetos.getPlayer().getHealth() - chefao.getDano() <= 0) {
			ControladorDeObjetos.getPlayer().setHealth(0);
		}else {
			ControladorDeObjetos.getPlayer().setHealth(ControladorDeObjetos.getPlayer().getHealth()-chefao.getDano());
		}
	}
	
	public Rectangle colisao(String direcao) {
		Rectangle rec = null;
		switch (direcao) {
		case "x":
			 rec = new Rectangle(chefao.getPosX() + (int) (xMover+chefao.getVelocidade())+10, chefao.getPosY()+9, chefao.getWidth()-20, chefao.getHeight()-9);
			break;
		case "-x":
			 rec = new Rectangle(chefao.getPosX() + (int) (xMover-chefao.getVelocidade())+10, chefao.getPosY()+9, chefao.getWidth()-20, chefao.getHeight()-9);
			break;
		case "y":
			 rec = new Rectangle(chefao.getPosX()+10, chefao.getPosY() + (int) (yMover+chefao.getVelocidade())+9, chefao.getWidth()-20, chefao.getHeight()-9);
			break;
		case "-y":
			 rec = new Rectangle(chefao.getPosX()+10, chefao.getPosY() + (int) (yMover-chefao.getVelocidade())+9, chefao.getWidth()-20, chefao.getHeight()-9);
			break;

		default:
			break;
		}
		return rec;
	}
	
}
