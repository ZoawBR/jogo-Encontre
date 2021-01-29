package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.Personagem;
import model.XML_dados_questoes;

public class ControlePersonagem extends Thread{
	private Personagem player;
	private Game game;
	
	private float xMover, yMover;
	private String ladoAtivo = null;
	
	private ControleTiro tiros; 
	private ControleBolaDeFogo bolas;
	
	public ControlePersonagem(Game game,Personagem player) {
		this.player = player;
		this.game = game;
		tiros = new ControleTiro(player);
		bolas = new ControleBolaDeFogo(player);
		start();

	}
	
	public void tick() {
		morrer();
		atirar();
		atirarEspecial();
		direcao();
		try {
			sleep(12);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void atirarEspecial() {
		if (ladoAtivo == "cima" && game.getKeyPrincipal().shootEspecial) {
			bolas.adicionarTiro("cima");
		}	
	
		if (ladoAtivo == "baixo" && game.getKeyPrincipal().shootEspecial) {
			bolas.adicionarTiro("baixo");
		}
		
		if (ladoAtivo == "esquerda" && game.getKeyPrincipal().shootEspecial) {
			bolas.adicionarTiro("esquerda");
		}
		
		if (ladoAtivo == "direita" && game.getKeyPrincipal().shootEspecial) {
			bolas.adicionarTiro("direita");
		}
		bolas.tick();
	}
	
	public void morrer() {
		if (player.getHealth() == 0 || player.getHealth() <= 1) {
			if (game.getChances() > 0) {
				ControladorDeObjetos.getSom().somMortePlayer();
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.setChances(game.getChances() - 1);
				game.setReiniciar(true);
		
			}else {
				///POR UMA JPANEL PRA MORTE///
				///GAME OVER///
				ControleJpanel.gameOver();
//				System.exit(0);
			}
		}
	}
	
	
	public void atirar() {
		if (ladoAtivo == "cima" && game.getKeyPrincipal().shoot) {
			tiros.adicionarTiro("cima");
		}	
	
		if (ladoAtivo == "baixo" && game.getKeyPrincipal().shoot) {
			tiros.adicionarTiro("baixo");
		}
		
		if (ladoAtivo == "esquerda" && game.getKeyPrincipal().shoot) {
			tiros.adicionarTiro("esquerda");
		}
		
		if (ladoAtivo == "direita" && game.getKeyPrincipal().shoot) {
			tiros.adicionarTiro("direita");

		}
		tiros.tick();
	}
	
	public void direcao() {
		xMover = 0;
		yMover = 0;
		
		
		// COLISAO COM PAREDE
		if (game.getKeyPrincipal().up && ControladorDeColisoes.colisaoParede(colisaoParede("-y")) == false) {
			yMover = -player.getVelocidade();
			ladoAtivo = "cima";
			player.setAparencia(player.getAparencia() + 1);
		}else if (game.getKeyPrincipal().up && ControladorDeColisoes.colisaoParede(colisaoParede("-y")) == true) {
			ladoAtivo = "cima";
			yMover = 0;
			player.setAparencia(player.getAparencia() + 1);
		}
		
		 if (game.getKeyPrincipal().down && ControladorDeColisoes.colisaoParede(colisaoParede("y")) == false) {
			yMover = +player.getVelocidade();
			ladoAtivo = "baixo";
			player.setAparencia(player.getAparencia() + 1);
		}else if (game.getKeyPrincipal().down && ControladorDeColisoes.colisaoParede(colisaoParede("y")) == true){
			yMover = 0;
			ladoAtivo = "baixo";
			player.setAparencia(player.getAparencia() + 1);

		}
		 if (game.getKeyPrincipal().left && ControladorDeColisoes.colisaoParede(colisaoParede("-x")) == false) {
			xMover = -player.getVelocidade();
			ladoAtivo = "esquerda";
			player.setAparencia(player.getAparencia() + 1);
		}else if (game.getKeyPrincipal().left && ControladorDeColisoes.colisaoParede(colisaoParede("-x")) == true) {
			xMover = 0;
			ladoAtivo = "esquerda";
			player.setAparencia(player.getAparencia() + 1);
		}
		 
		 if (game.getKeyPrincipal().right && ControladorDeColisoes.colisaoParede(colisaoParede("x")) == false) {
			xMover = player.getVelocidade();
			ladoAtivo = "direita";
			player.setAparencia(player.getAparencia() + 1);
		}else if (game.getKeyPrincipal().right && ControladorDeColisoes.colisaoParede(colisaoParede("x")) == true) {
			xMover = 0;
			ladoAtivo = "direita";
			player.setAparencia(player.getAparencia() + 1);
		}
		mover();
		
	}
	
	public void mover() {
	
		player.setPosX(player.getPosX() + (int)xMover);
		player.setPosY(player.getPosY() + (int)yMover);
		
		player.animar();

	}
	
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(player.getPosX(), player.getPosY()-5, 32, 3);
		g.setColor(Color.GREEN);
		g.fillRect(player.getPosX(), player.getPosY()-5, (player.getHealth()*32)/100, 3);
		g.drawImage(player.getSprites()[player.getAparencia()], player.getPosX(),
				player.getPosY(), player.getHeight(), player.getWidth(), null);
		
	}
	
	public Rectangle colisaoParede(String direcao) {
		Rectangle rec = null;
		switch (direcao) {
		case "x":
			 rec = new Rectangle(player.getPosX() + (int) (xMover+player.getVelocidade())+10, player.getPosY()+9, player.getWidth()-20, player.getHeight()-9);
			break;
		case "-x":
			 rec = new Rectangle(player.getPosX() + (int) (xMover-player.getVelocidade())+10, player.getPosY()+9, player.getWidth()-20, player.getHeight()-9);
			break;
		case "y":
			 rec = new Rectangle(player.getPosX()+10, player.getPosY() + (int) (yMover+player.getVelocidade())+9, player.getWidth()-20, player.getHeight()-9);
			break;
		case "-y":
			 rec = new Rectangle(player.getPosX()+10, player.getPosY() + (int) (yMover-player.getVelocidade())+9, player.getWidth()-20, player.getHeight()-9);
			break;

		default:
			break;
		}
		return rec;
	}

	public Personagem getPlayer() {
		return player;
	}

	public void setPlayer(Personagem player) {
		this.player = player;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ControleTiro getTiros() {
		return tiros;
	}

	public void setTiros(ControleTiro tiros) {
		this.tiros = tiros;
	}

	public String getLadoAtivo() {
		return ladoAtivo;
	}
	
	
	
}
