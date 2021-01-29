package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CarregarImagens {

	public static BufferedImage CarregarImagem(String path) {
		try {
			return ImageIO.read(ImageIO.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
