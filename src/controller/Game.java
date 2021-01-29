package controller;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import model.Fase;
import model.Fase1_Single;
import model.Fase2_Single;
import model.Fase3_Single;
import model.Som;
import view.Tela;

public class Game implements Runnable{

	private Tela tela;
	private int WIDTH, HEIGHT;
	private String title;

	private Thread thread;
	private boolean running = false;
	private boolean reiniciar = false;

	private BufferStrategy bs;
	private Graphics g;

	private Fase fase;
	private KeyPrincipal keyPrincipal;
	private Som som;

	private int ticker;

	private int chances = 3;
	
	private static boolean fase1 = true , fase2 = false ;

	public Game(String title, int WIDTH, int HEIGHT) {
		this.title = title;
		this.WIDTH = WIDTH;
		this.HEIGHT = HEIGHT;
		this.som = ControladorDeObjetos.getSom();
		keyPrincipal = new KeyPrincipal();
		tela = new Tela(title, WIDTH, HEIGHT);
		ControladorDeObjetos.setGame(this);
	}

	private void init() {		
		tela.getFrame().addKeyListener(keyPrincipal);
		if(fase1 == true && fase2 == false) {
			fase = new Fase1_Single(this);	
		}
		if(fase1 == false && fase2 == true) {
			fase = new Fase2_Single(this);	
		}
		if(fase1 == false && fase2 == false) {
			fase = new Fase3_Single(this);	
		}
		Fase.setFaseAtual(fase);
	}

	private void tick() {

		keyPrincipal.tick();
		if (Fase.getFaseAtual() != null) {
			Fase.getFaseAtual().tick();
		}
	}

	private void render() {
		bs = tela.getCanvas().getBufferStrategy();

		if (bs==null) {
			tela.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

		if (Fase.getFaseAtual() != null) {
			Fase.getFaseAtual().render(g);
		}

		bs.show();
		g.dispose();
	}



	@Override
	public void run() {

		init();

		int fps = 30;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			if(reiniciar) {
				ControleJpanel.limparJlabel();
				fase1 = true;
				fase2 = false;
				init();
				reiniciar = false;
			}

			now = System.nanoTime();
			delta += (now - lastTime)/ timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				ticker = ticks;
				ticks = 0;
				timer = 0;
			}

		}

	}

	public synchronized void start() {
		if (running) {return;}
		running = true;

		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) {return;}
		running = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getTicker() {
		return ticker;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	public void setGameEstado(Fase fase) {
		this.fase = fase;
	}
	public Fase getGameEstado() {
		return fase;
	}

	public  KeyPrincipal getKeyPrincipal() {
		return keyPrincipal;
	}

	public boolean isReiniciar() {
		return reiniciar;
	}

	public void setReiniciar(boolean reiniciar) {
		this.reiniciar = reiniciar;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public int getChances() {
		return chances;
	}

	public void setChances(int chances) {
		this.chances = chances;
	}

	public Tela getTela() {
		return tela;
	}

	public  static boolean isFase1() {
		return fase1;
	}

	public static void setFase1(boolean fase1) {
		Game.fase1 = fase1;
	}

	public  static boolean isFase2() {
		return fase2;
	}

	public static void setFase2(boolean fase2) {
		Game.fase2 = fase2;
	}

	

}
