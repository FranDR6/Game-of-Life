package Canvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Canvas.Vista.Lienzo;
import Canvas.Vista.Ventana;

public class Principal {

	private final int ANCHO;
	private final int ALTO;
	private int cuadrado = 5;

	private boolean enFuncionamiento = false;
	private boolean vida = false;

	private Lienzo canvas;
	private Ventana ventana;
	private Tablero tablero;
	private Raton raton;

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
		raton = new Raton();
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

		ventana.getBtnAleatorio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < tablero.getCelulasOcultas().length; i++) {
					for (int j = 0; j < tablero.getCelulasOcultas()[i].length; j++) {
						tablero.getCelulasOcultas()[i][j] = Tablero.obtenerNumeroAleatorio(0, 1);
					}
				}
			}
		});

		ventana.getBtnReiniciar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tablero.getCelulasOcultas().length; i++) {
					for (int j = 0; j < tablero.getCelulasOcultas()[i].length; j++) {
						tablero.getCelulasOcultas()[i][j] = 0;
					}
				}
			}
		});

	}

	private void iniciarBuclePrincipal() {
		while (enFuncionamiento) {

			if (!vida) {
				ventana.getLblEstado().setText("ESTADO : PAUSA");
			} else {
				ventana.getLblEstado().setText("ESTADO : FUNCIONANDO");
			}

			raton.actualizar();
			raton.dibujar(ventana.getLblRaton());

//			if (System.nanoTime() % 100000 == 0) {
//				canvas.dibujar(tablero, vida, cuadrado);
//			}

			canvas.dibujar(tablero, vida, cuadrado);

		}
	}

}
