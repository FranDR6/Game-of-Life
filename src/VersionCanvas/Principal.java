package VersionCanvas;

public class Principal {

	private final int ANCHO;
	private final int ALTO;
	private boolean enFuncionamiento = false;

	private vistaCanvas canvas;
	private Ventana ventana;
	private Tablero tablero;

	public Principal(final int ancho, final int alto) {
		super();
		this.ANCHO = ancho;
		this.ALTO = alto;
	}

	public static void main(String[] args) {
		Principal principal = new Principal(1800, 960);
		principal.iniciar();
		principal.iniciarBuclePrincipal();

	}

	private void iniciar() {
		enFuncionamiento = true;
		tablero = new Tablero(ANCHO / 20, ALTO / 20);
		canvas = new vistaCanvas(ANCHO, ALTO);
		ventana = new Ventana(canvas);

	}

	private void iniciarBuclePrincipal() {
		while (enFuncionamiento) {
			
//			if (System.nanoTime() % 200000000 == 0) {
//				canvas.dibujar(tablero);
//			}
			
			canvas.dibujar(tablero);
			
		}
	}

	private void actualizar() {
		// TODO Auto-generated method stub

	}

}
