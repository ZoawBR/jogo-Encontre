package controller;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import model.Inimigo;
import model.Personagem;

public class ControleInimigo{

	protected float xMover, yMover;
	protected ArrayList<String> direcoes;
	
	private Random r;

	private Personagem player = ControladorDeObjetos.getPlayer();
	
	private Inimigo inimigo;
	private Game game;
	
	public ControleInimigo(Game game, Inimigo inimigo) {
		this.game = game;
		this.inimigo = inimigo;
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
	
		if (direcao.equals("-x") && ControladorDeColisoes.colisaoPlayer(colisao("-x")) == true && player.isRespondendo() == false) {
			xMover = 0;
			atacar();
			inimigo.setAparencia(inimigo.getAparencia()+1);
			
		}else if (direcao.equals("-x") && ControladorDeColisoes.colisaoPlayer(colisao("-x")) == true && player.isRespondendo() == true) {
			xMover = -inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);
		}
		else if (direcao.equals("-x") && ControladorDeColisoes.colisaoParede(colisao("-x")) == false) {
			xMover = -inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		else if (direcao.equals("-x") && ControladorDeColisoes.colisaoParede(colisao("-x")) == true ) {
//			xMover = +inimigo.getVelocidade();
			inimigo.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		
		if (direcao.equals("x") && ControladorDeColisoes.colisaoPlayer(colisao("x")) == true && player.isRespondendo() == false) {
			xMover = 0;
			atacar();
			inimigo.setAparencia(inimigo.getAparencia()+1);
			
		}else if(direcao.equals("x") && ControladorDeColisoes.colisaoPlayer(colisao("x")) == true && player.isRespondendo() == true){
			xMover = +inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);
		}else if (direcao.equals("x") && ControladorDeColisoes.colisaoParede(colisao("x")) == false ) {
			xMover = +inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		else if (direcao.equals("x") && ControladorDeColisoes.colisaoParede(colisao("x")) == true) {
//			xMover = -inimigo.getVelocidade();
			inimigo.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		
		if (direcao.equals("-y") && ControladorDeColisoes.colisaoPlayer(colisao("-y")) == true && player.isRespondendo() == false) {
			yMover = 0;
			atacar();
			inimigo.setAparencia(inimigo.getAparencia()+1);
			
		}else if (direcao.equals("-y") && ControladorDeColisoes.colisaoPlayer(colisao("-y")) == true && player.isRespondendo() == true) {
			yMover = -inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);
		}
		else if (direcao.equals("-y") && ControladorDeColisoes.colisaoParede(colisao("-y")) == false ) {
			yMover = -inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}else if (direcao.equals("-y") && ControladorDeColisoes.colisaoParede(colisao("-y")) == true ) {
//			yMover = +inimigo.getVelocidade();
			inimigo.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		
		if (direcao.equals("y") && ControladorDeColisoes.colisaoPlayer(colisao("y")) == true && player.isRespondendo() == false) {
			yMover = 0;
			atacar();
			inimigo.setAparencia(inimigo.getAparencia()+1);
			
		} else if (direcao.equals("y") && ControladorDeColisoes.colisaoPlayer(colisao("y")) == true && player.isRespondendo() == true) {
			yMover = +inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);
			
		}
		else if (direcao.equals("y") && ControladorDeColisoes.colisaoParede(colisao("y")) == false ) {
			yMover = +inimigo.getVelocidade();
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		else if (direcao.equals("y") && ControladorDeColisoes.colisaoParede(colisao("y")) == true ) {
//			yMover = -inimigo.getVelocidade();
			inimigo.setDirecao(direcoes.get(r.nextInt(direcoes.size())));
			inimigo.setAparencia(inimigo.getAparencia()+1);

		}
		
		mover();
	}
	
	public void tick() {
		input(inimigo.getDirecao());
	
	}
	
	public void mover() {
		
		inimigo.setPosX(inimigo.getPosX() + (int)xMover);
		inimigo.setPosY(inimigo.getPosY() + (int)yMover);
		inimigo.animar();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(inimigo.getPosX(), inimigo.getPosY()-5, 32, 3);
		g.setColor(Color.GREEN);
		g.fillRect(inimigo.getPosX(), inimigo.getPosY()-5, (inimigo.getHealth()*32)/100, 3);
		g.drawImage(inimigo.getSprites()[inimigo.getAparencia()], inimigo.getPosX(),
				inimigo.getPosY(), inimigo.getHeight(), inimigo.getWidth(), null);
		
	}
	
	public void atacar() {
		if (ControladorDeObjetos.getPlayer().getHealth() - inimigo.getDano() <= 0) {
			ControladorDeObjetos.getPlayer().setHealth(0);
		}else {
			ControladorDeObjetos.getPlayer().setHealth(ControladorDeObjetos.getPlayer().getHealth()-inimigo.getDano());
		}
	}
	
	public Rectangle colisao(String direcao) {
		Rectangle rec = null;
		switch (direcao) {
		case "x":
			 rec = new Rectangle(inimigo.getPosX() + (int) (xMover+inimigo.getVelocidade())+10, inimigo.getPosY()+9, inimigo.getWidth()-20, inimigo.getHeight()-9);
			break;
		case "-x":
			 rec = new Rectangle(inimigo.getPosX() + (int) (xMover-inimigo.getVelocidade())+10, inimigo.getPosY()+9, inimigo.getWidth()-20, inimigo.getHeight()-9);
			break;
		case "y":
			 rec = new Rectangle(inimigo.getPosX()+10, inimigo.getPosY() + (int) (yMover+inimigo.getVelocidade())+9, inimigo.getWidth()-20, inimigo.getHeight()-9);
			break;
		case "-y":
			 rec = new Rectangle(inimigo.getPosX()+10, inimigo.getPosY() + (int) (yMover-inimigo.getVelocidade())+9, inimigo.getWidth()-20, inimigo.getHeight()-9);
			break;

		default:
			break;
		}
		return rec;
	}
	
}
