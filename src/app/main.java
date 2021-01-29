package app;

import controller.ControleMenu;
import model.Som;
import view.TelaMenu;

public class main {

	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		new ControleMenu(menu);
	}

}
