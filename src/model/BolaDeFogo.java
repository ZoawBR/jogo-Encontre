package model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.IOException;

import controller.ControladorDeObjetos;
import controller.Game;

public class BolaDeFogo extends Sprite{
	
	private static int DANO = 50;
	private static int VELOCIDADE = 6;

	private int dano, velocidade;
	
	private boolean usado = true;
	private boolean coletado = false;
	private boolean movendo = false;
	private String direcaoTiro = "parar";
	
	private Chefao chefe;
		
	public BolaDeFogo(String direcaoTiro) throws IOException {
		super("boladefogo.png", 1, 4, 4, ControladorDeObjetos.getPlayer().getPosX(), ControladorDeObjetos.getPlayer().getPosY());
		this.dano = DANO;
		this.chefe = Fase3_Single.getChefao();
		this.direcaoTiro = direcaoTiro;
		this.velocidade = VELOCIDADE;
	}
	
	public void mover() {
		if (direcaoTiro.equals("cima") && colisaoMonstro(getPosX(), getPosY()-VELOCIDADE) == true || 
				direcaoTiro.equals("cima") && colisaoChefao(getPosX(), getPosY()-VELOCIDADE) == true ||
				direcaoTiro.equals("cima") && colisaoParede(getPosX(), getPosY()-VELOCIDADE) == true) {
			setAparencia(getAparencia()+1);
			setPosY(getPosY() - VELOCIDADE);

		}else if (direcaoTiro.equals("cima") && colisaoMonstro(getPosX(), getPosY()-VELOCIDADE) == false || 
				direcaoTiro.equals("cima") && colisaoChefao(getPosX(), getPosY()-VELOCIDADE) == false ||
				direcaoTiro.equals("cima") && colisaoParede(getPosX(), getPosY()-VELOCIDADE) == false) {
			setPosY(getPosY() - VELOCIDADE);
			setAparencia(getAparencia()+1);

		}
		
		if (direcaoTiro.equals("baixo") && colisaoMonstro(getPosX(), getPosY()+VELOCIDADE) == true || 
				direcaoTiro.equals("baixo") && colisaoChefao(getPosX(), getPosY()+VELOCIDADE) == true ||
				direcaoTiro.equals("baixo") && colisaoParede(getPosX(), getPosY()+VELOCIDADE) == true) {
			setAparencia(getAparencia()+1);
			setPosY(getPosY() + VELOCIDADE);

		}else if (direcaoTiro.equals("baixo") && colisaoMonstro(getPosX(), getPosY()+VELOCIDADE) == false || 
				direcaoTiro.equals("baixo") && colisaoChefao(getPosX(), getPosY()+VELOCIDADE) == false ||
				direcaoTiro.equals("baixo") && colisaoParede(getPosX(), getPosY()+VELOCIDADE) == false) {
			setPosY(getPosY() + VELOCIDADE);
			setAparencia(getAparencia()+1);

		}
		
		if (direcaoTiro.equals("esquerda") && colisaoMonstro(getPosX()-VELOCIDADE, getPosY()) == true ||
				direcaoTiro.equals("esquerda") && colisaoChefao(getPosX()-VELOCIDADE, getPosY()) == true ||
				direcaoTiro.equals("esquerda") && colisaoParede(getPosX()-VELOCIDADE, getPosY()) == true) {
			setPosX(getPosX() - VELOCIDADE);

		}else if (direcaoTiro.equals("esquerda") && colisaoMonstro(getPosX()-VELOCIDADE, getPosY()) == false ||
				direcaoTiro.equals("esquerda") && colisaoChefao(getPosX()-VELOCIDADE, getPosY()) == false ||
				direcaoTiro.equals("esquerda") && colisaoParede(getPosX()-VELOCIDADE, getPosY()) == false) { 
			setPosX(getPosX() - VELOCIDADE);
			setAparencia(getAparencia()+1);

		}
		
		if (direcaoTiro.equals("direita") && colisaoMonstro(getPosX()+VELOCIDADE, getPosY()) == true ||
				direcaoTiro.equals("direita") && colisaoChefao(getPosX()+VELOCIDADE, getPosY()) == true ||
				direcaoTiro.equals("direita") && colisaoParede(getPosX()+VELOCIDADE, getPosY()) == true) {
			setPosX(getPosX() + VELOCIDADE);

			setAparencia(getAparencia()+1);
		}else if (direcaoTiro.equals("direita") && colisaoMonstro(getPosX()+VELOCIDADE, getPosY()) == false ||
				direcaoTiro.equals("direita") && colisaoChefao(getPosX()+VELOCIDADE, getPosY()) == false ||
				direcaoTiro.equals("direita") && colisaoParede(getPosX()+VELOCIDADE, getPosY()) == false) {
			setPosX(getPosX() + VELOCIDADE);
			setAparencia(getAparencia()+1);

		}
		movendo = true;
	}
	
	public boolean colisaoChefao(int x, int y) {
		if (chefe != null) {
			Rectangle bola = new Rectangle(x+10, y+10, 
					getWidth()-20, getHeight()-20);
			if(new Rectangle(chefe.getPosX(),chefe.getPosY(),
					chefe.getWidth(), chefe.getHeight()).intersects(bola)) {
				if (chefe.getHealth()-DANO <= 0) {
					chefe.setHealth(0);
				}
				else {	
					chefe.setHealth(chefe.getHealth()-DANO);
				}
				setPosX(1000000);
				ControladorDeObjetos.getSom().somBolaFogoStop();
				ControladorDeObjetos.getSom().somMonstroMortePlay();
				return true;
			}
		}
		return false;
	}
	
	public boolean colisaoParede(int x, int y) {
		
		Rectangle bala = new Rectangle(x+10, y+10, 
				getWidth()-20, getHeight()-20);
		for(Rectangle rectangle : ControladorDeObjetos.getColisao()) {
			if(rectangle.intersects(bala)){
				ControladorDeObjetos.getSom().somBolaFogoStop();
				setPosX(1000000);
				return true;
			}
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(getSprites()[getAparencia()], getPosX(),
				getPosY(), getHeight(), getWidth(), null);
	
	}
	public void animar() {
		if (movendo == true) {
			
			if(direcaoTiro.equals("cima")) {
				if(getAparencia() > 7 || getAparencia() < 4)
					setAparencia(4);
			}
			
			if(direcaoTiro.equals("baixo")) {
				if(getAparencia() > 3 || getAparencia() < 0)
					setAparencia(0);	
			}
			
			if(direcaoTiro.equals("esquerda")) {
				if(getAparencia() > 11 || getAparencia() < 8)
					setAparencia(8);
			}
			
			if(direcaoTiro.equals("direita")) {
				if(getAparencia() > 15 || getAparencia() < 12)
					setAparencia(12);
			}
		}
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

	public static int getDANO() {
		return DANO;
	}

	public static void setDANO(int dANO) {
		DANO = dANO;
	}

	public static int getVELOCIDADE() {
		return VELOCIDADE;
	}

	public static void setVELOCIDADE(int vELOCIDADE) {
		VELOCIDADE = vELOCIDADE;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public boolean isColetado() {
		return coletado;
	}

	public void setColetado(boolean coletado) {
		this.coletado = coletado;
	}

	public boolean isMovendo() {
		return movendo;
	}

	public void setMovendo(boolean movendo) {
		this.movendo = movendo;
	}

	public String getDirecaoTiro() {
		return direcaoTiro;
	}

	public void setDirecaoTiro(String direcaoTiro) {
		this.direcaoTiro = direcaoTiro;
	}

	
	
	
}
