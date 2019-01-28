package Canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

public class vistaCanvas extends Canvas {

	private int ancho;
	private int alto;

	public vistaCanvas(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(ancho, alto));
		setFocusable(true);
		requestFocus();
	}

	public void dibujar(final Tablero tablero, boolean vida, int cuadrado) {
		BufferStrategy buffer = getBufferStrategy();

		if (buffer == null) {
			createBufferStrategy(4);
			return;
		}

		Graphics g = buffer.getDrawGraphics();

		tablero.dibujar(g, vida, cuadrado);

		Toolkit.getDefaultToolkit().sync();

		g.dispose();

		buffer.show();

	}
}
