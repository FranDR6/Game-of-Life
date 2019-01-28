package Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Canvas.Vista.Lienzo;
import Canvas.Vista.Ventana;

public class Principal {

	private final int ANCHO;
	private final int ALTO;
	private int cuadrado = 10;

	private boolean enFuncionamiento = false;
	private boolean vida = false;

	private Lienzo canvas;
	private Ventana ventana;
	private Tablero tablero;

	public Principal(final int ancho, final int alto) {
		super();
		this.ANCHO = ancho;
		this.ALTO = alto;
	}

	public static void main(String[] args) {
		Principal principal = new Principal(1900, 940);
		principal.iniciar();
		principal.iniciarBuclePrincipal();

	}

	private void iniciar() {
		enFuncionamiento = true;
		tablero = new Tablero(ANCHO / cuadrado, ALTO / cuadrado);
		canvas = new Lienzo(ANCHO, ALTO);
		ventana = new Ventana(canvas);
		listener();

	}

	private void listener() {

		ventana.getBtnIniciar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vida = true;
			}
		});

		ventana.getBtnPausar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vida = false;
			}
		});

	}

	private void iniciarBuclePrincipal() {
		while (enFuncionamiento) {

//			if (System.nanoTime() % 100000 == 0) {
//				canvas.dibujar(tablero, vida, cuadrado);
//			}

			canvas.dibujar(tablero, vida, cuadrado);

		}
	}

}
