package Canvas.Vista;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import Canvas.Tablero;

public class Lienzo extends Canvas {

	private static final long serialVersionUID = -7197762908765363778L;

	private int ancho;
	private int alto;

	public Lienzo(final int ancho, final int alto) {
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

		for (int i = 0; i < tablero.getCelulasOcultas().length; i++) {
			for (int j = 0; j < tablero.getCelulasOcultas()[i].length; j++) {

				if (vida == false) {
					if (tablero.getCelulasOcultas()[i][j] == 1) {
						g.setColor(Color.WHITE);
					} else {
						g.setColor(Color.BLACK);
					}
					g.fillRect(i * cuadrado, j * cuadrado, cuadrado, cuadrado);
				}

				g.setColor(Color.DARK_GRAY);
				g.drawRect(i * cuadrado, j * cuadrado, cuadrado, cuadrado);
				
			}
		}

		Toolkit.getDefaultToolkit().sync();

		g.dispose();

		buffer.show();

	}
}
