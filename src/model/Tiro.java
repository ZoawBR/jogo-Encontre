package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import controller.ControladorDeObjetos;

public class Tiro extends Sprite {

	private static int DANO =  22;
	private static int VELOCIDADE_TIRO =  6;
	
	private int dano, velocidade_tiro;
	
	protected String caminho = "parar";
	protected boolean movendo = false;
	protected int direcao = 3;
	
	protected int municao = 10;
	
	private Chefao chefao;
			
	public Tiro(String caminho) throws IOException {
		super("itens.png", 4, 5, 1, ControladorDeObjetos.getPlayer().getPosX(), ControladorDeObjetos.getPlayer().getPosY());
		this.caminho = caminho;
		this.dano = DANO;
		this.chefao = Fase3_Single.getChefao();
		this.velocidade_tiro = VELOCIDADE_TIRO;
	}
	
	public void mover() {
		if (caminho.equals("cima") && colisaoMonstro(getPosX(), getPosY()-VELOCIDADE_TIRO) == true || 
				caminho.equals("cima") && colisaoParede(getPosX(), getPosY()-VELOCIDADE_TIRO) == true ||
				caminho.equals("cima") && colisaoChefao(getPosX(), getPosY()-VELOCIDADE_TIRO) == true) {
			setPosY(1000000);
		}else if (caminho.equals("cima") && colisaoMonstro(getPosX(), getPosY()-VELOCIDADE_TIRO) == false || 
				caminho.equals("cima") && colisaoParede(getPosX(), getPosY()-VELOCIDADE_TIRO) == false ||
				caminho.equals("cima") && colisaoChefao(getPosX(), getPosY()-VELOCIDADE_TIRO) == false) {
			setPosY(getPosY() - VELOCIDADE_TIRO);
		}
		
		if (caminho.equals("baixo") && colisaoMonstro(getPosX(), getPosY()+VELOCIDADE_TIRO) == true || 
				caminho.equals("baixo") && colisaoParede(getPosX(), getPosY()+VELOCIDADE_TIRO) == true ||
				caminho.equals("baixo") && colisaoChefao(getPosX(), getPosY()+VELOCIDADE_TIRO) == true) {
			setPosY(100000000);
		}else if (caminho.equals("baixo") && colisaoMonstro(getPosX(), getPosY()+VELOCIDADE_TIRO) == false || 
				caminho.equals("baixo") && colisaoParede(getPosX(), getPosY()+VELOCIDADE_TIRO) == false ||
				caminho.equals("baixo") && colisaoChefao(getPosX(), getPosY()+VELOCIDADE_TIRO) == false) {
			setPosY(getPosY() + VELOCIDADE_TIRO);
		}
		
		if (caminho.equals("esquerda") && colisaoMonstro(getPosX()-VELOCIDADE_TIRO, getPosY()) == true ||
				caminho.equals("esquerda") && colisaoParede(getPosX()-VELOCIDADE_TIRO, getPosY()) == true ||
				caminho.equals("esquerda") && colisaoChefao(getPosX()-VELOCIDADE_TIRO, getPosY()) == true) {
			setPosX(10000000);
		}else if (caminho.equals("esquerda") && colisaoMonstro(getPosX()-VELOCIDADE_TIRO, getPosY()) == false ||
				caminho.equals("esquerda") && colisaoParede(getPosX()-VELOCIDADE_TIRO, getPosY()) == false ||
				caminho.equals("esquerda") && colisaoChefao(getPosX()-VELOCIDADE_TIRO, getPosY()) == false) {
			setPosX(getPosX() - VELOCIDADE_TIRO);
		}
		
		if (caminho.equals("direita") && colisaoMonstro(getPosX()+VELOCIDADE_TIRO, getPosY()) == true ||
				caminho.equals("direita") && colisaoParede(getPosX()+VELOCIDADE_TIRO, getPosY()) == true||
				caminho.equals("direita") && colisaoChefao(getPosX()+VELOCIDADE_TIRO, getPosY()) == true) {
			setPosX(10000000);
		}else if (caminho.equals("direita") && colisaoMonstro(getPosX()+VELOCIDADE_TIRO, getPosY()) == false ||
				caminho.equals("direita") && colisaoParede(getPosX()+VELOCIDADE_TIRO, getPosY()) == false||
				caminho.equals("direita") && colisaoChefao(getPosX()+VELOCIDADE_TIRO, getPosY()) == false) {
			setPosX(getPosX() + VELOCIDADE_TIRO);
		}
		movendo = true;
		
	}


	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getPosX(),
				getPosY(), getHeight(), getWidth(), null);
		
	}
	
	public boolean colisaoParede(int x, int y) {
		
		Rectangle bala = new Rectangle(x+10, y+10, 
				getWidth()-20, getHeight()-20);
		for(Rectangle rectangle : ControladorDeObjetos.getColisao()) {
			if(rectangle.intersects(bala)){
				return true;
			}
		}
		return false;
	}

	public boolean colisaoMonstro(int x, int y) {
		Rectangle bala = new Rectangle(x+10, y+9, 
				getWidth()-20, getHeight()-9);
		for(Inimigo inimigo : ControladorDeObjetos.getInimigos()) {
			if(new Rectangle(inimigo.posX+10, inimigo.posY+9, 
					inimigo.getWidth()-20, inimigo.getHeight()-9).intersects(bala)){
				if (inimigo.getHealth()-20 <= 0) {
					inimigo.setHealth(0);
				}
				else {	
					inimigo.setHealth(inimigo.getHealth()-DANO);
				}
				ControladorDeObjetos.getSom().somMonstroMortePlay();

				return true;

			}
		}
		return false;
	}
	
	public boolean colisaoChefao(int x, int y) {
		if (chefao != null) {
			Rectangle bala = new Rectangle(x+10, y+9, 
					getWidth()-20, getHeight()-9);
			if(new Rectangle(chefao.getPosX(),chefao.getPosY(),
					chefao.getWidth(), chefao.getHeight()).intersects(bala)) {
				if (chefao.getHealth()-DANO <= 0) {
					chefao.setHealth(0);
				}
				else {	
					chefao.setHealth(chefao.getHealth()-DANO);
				}
				ControladorDeObjetos.getSom().somMonstroMortePlay();
				return true;
			}
		}
		return false;
	}
	
	public static int getDANO() {
		return DANO;
	}

	public static void setDANO(int dANO) {
		DANO = dANO;
	}

	public static int getVELOCIDADE_TIRO() {
		return VELOCIDADE_TIRO;
	}

	public static void setVELOCIDADE_TIRO(int vELOCIDADE_TIRO) {
		VELOCIDADE_TIRO = vELOCIDADE_TIRO;
	}

	public int getMunicao() {
		return municao;
	}

	public void setMunicao(int municao) {
		this.municao = municao;
	}

	
}
