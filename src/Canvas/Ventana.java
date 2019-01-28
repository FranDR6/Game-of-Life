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
import java.awt.GridLayout;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 5300880680876136593L;

	private JPanel panelCanvas;

	public JButton btnIniciar;
	public JButton btnPausar;

	public Ventana(vistaCanvas dibujo) {
		configurarVentana(dibujo);
	}

	private void configurarVentana(vistaCanvas dibujo) {
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(10)
						.addComponent(panelCanvas, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE).addGap(10))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnIniciar)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPausar)
						.addContainerGap(625, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(12)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnIniciar)
								.addComponent(btnPausar))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panelCanvas, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE).addGap(10)));
		getContentPane().setLayout(groupLayout);

		panelCanvas.setLayout(new BorderLayout(0, 0));
		panelCanvas.add(dibujo, BorderLayout.CENTER);
	}
}
