package Canvas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 5300880680876136593L;

	private JPanel panelCanvas;

	private JButton btnIniciar;
	private JButton btnPausar;
	private JButton btnAleatorio;
	private JButton btnReiniciar;
	private JLabel lblEstado;
	private JLabel lblRaton;

	public Ventana(Lienzo dibujo) {
		configurarVentana(dibujo);
	}

	private void configurarVentana(Lienzo dibujo) {
		setBounds(800, 800, 800, 800);
		setTitle("Juego de la Vida");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		getContentPane().setBackground(Color.DARK_GRAY);

		panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.BLACK);
		panelCanvas.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));

		btnIniciar = new JButton("INICIAR");
		btnIniciar.setBackground(Color.WHITE);

		btnPausar = new JButton("PAUSAR");
		btnPausar.setBackground(Color.WHITE);

		btnAleatorio = new JButton("ALEATORIO");
		btnAleatorio.setBackground(Color.WHITE);

		btnReiniciar = new JButton("REINICIAR");
		btnReiniciar.setBackground(Color.WHITE);

		lblEstado = new JLabel("ESTADO :");
		lblEstado.setForeground(Color.WHITE);

		lblRaton = new JLabel("");
		lblRaton.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(panelCanvas,
										GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnIniciar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPausar)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAleatorio)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnReiniciar)
										.addPreferredGap(ComponentPlacement.RELATED, 292, Short.MAX_VALUE)
										.addComponent(lblRaton).addGap(10).addComponent(lblEstado)))
						.addGap(10)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnIniciar)
								.addComponent(btnPausar).addComponent(btnAleatorio).addComponent(btnReiniciar)
								.addComponent(lblEstado).addComponent(lblRaton))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelCanvas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(10)));
		getContentPane().setLayout(groupLayout);

		panelCanvas.setLayout(new BorderLayout(0, 0));
		panelCanvas.add(dibujo, BorderLayout.CENTER);
	}

	public JButton getBtnIniciar() {
		return btnIniciar;
	}

	public JButton getBtnPausar() {
		return btnPausar;
	}

	public JButton getBtnAleatorio() {
		return btnAleatorio;
	}

	public JButton getBtnReiniciar() {
		return btnReiniciar;
	}

	public JLabel getLblEstado() {
		return lblEstado;
	}

	public void setLblEstado(JLabel lblEstado) {
		this.lblEstado = lblEstado;
	}

	public JLabel getLblRaton() {
		return lblRaton;
	}

	public void setLblRaton(JLabel lblRaton) {
		this.lblRaton = lblRaton;
	}

}
