package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPrincipal extends Thread implements KeyListener{

	private boolean[] keys;

	public boolean up, down,left, right,shoot, tirarAviso,abrirBau, shootEspecial;
	
	public KeyPrincipal() {
		keys = new boolean[1000];
		start();
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right  = keys[KeyEvent.VK_D];

		shoot = keys[KeyEvent.VK_SPACE]; 
		shootEspecial = keys[KeyEvent.VK_SHIFT]; 

		abrirBau = keys[KeyEvent.VK_E];
		tirarAviso = keys[KeyEvent.VK_ENTER];
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public boolean[] getKeys() {
		return keys;
	}

	public void setKeys(boolean[] keys) {
		this.keys = keys;
	}

}
