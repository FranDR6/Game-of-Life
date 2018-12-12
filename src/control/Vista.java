package control;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.border.MatteBorder;

public class Vista extends JFrame {

	protected JPanel panelBotonera;
	protected JButton btnEmpezar;

	public Vista() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("The Game of Life");
		getContentPane().setBackground(Color.BLACK);

		panelBotonera = new JPanel();
		panelBotonera.setBackground(Color.BLACK);
		panelBotonera.setBorder(new MatteBorder(1, 1, 1, 1, Color.WHITE));

		btnEmpezar = new JButton("EMPEZAR");
		btnEmpezar.setBackground(Color.white);

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addContainerGap()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(panelBotonera, GroupLayout.DEFAULT_SIZE, 764,
																Short.MAX_VALUE)
														.addComponent(btnEmpezar))
												.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(btnEmpezar)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panelBotonera, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
						.addContainerGap()));
		panelBotonera.setLayout(new GridLayout(1, 0, 0, 0));
		getContentPane().setLayout(groupLayout);

	}
}
