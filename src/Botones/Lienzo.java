package Botones;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class Lienzo extends Canvas {

	private int ancho;
	private int alto;

	public Lienzo(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(ancho, alto));
		setFocusable(true);
		requestFocus();
	}

	public void dibujar() {
		BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = buffer.getDrawGraphics();

		g.fillRect(0, 0, ancho, alto);

		Toolkit.getDefaultToolkit().sync();

		g.dispose();

		buffer.show();
	}

}
