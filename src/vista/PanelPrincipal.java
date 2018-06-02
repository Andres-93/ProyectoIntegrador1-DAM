package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controlador.ControladorApp;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;

public class PanelPrincipal extends JPanel {
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JButton btnSalir;

	public PanelPrincipal() {
		inicializar();

	}

	private void inicializar() {

		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		setLayout(null);
		setBounds(0, 0, 700, 700);
		JLabel lblAplicacion = new JLabel("");
		lblAplicacion.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/LogoMirmidon.png")));
		lblAplicacion.setForeground(Color.WHITE);
		lblAplicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		lblAplicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAplicacion.setBounds(120, 91, 442, 332);
		add(lblAplicacion);

		btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setRolloverIcon(
				new ImageIcon(PanelPrincipal.class.getResource("/images/botonDesconectarPulsado.png")));
		btnNewButton.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/botonDesconectar.png")));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(37, 536, 189, 50);
		add(btnNewButton);

		btnSalir = new JButton("");
		btnSalir.setRolloverIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/botonExitPulsado.png")));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/botonExit.png")));
		btnSalir.setFocusPainted(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		btnSalir.setBorder(null);
		btnSalir.setBounds(599, 530, 56, 56);
		add(btnSalir);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PanelPrincipal.class.getResource("/images/fondo2.jpg")));
		lblNewLabel.setBounds(0, 0, 700, 625);
		add(lblNewLabel);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnNewButton.addActionListener(c);
		btnSalir.addActionListener(c);
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void confirmarSalida() {
		int op = JOptionPane.showConfirmDialog(getParent(), "Esta seguro que desea salir?", "Confirmar",
				JOptionPane.YES_NO_OPTION);
		if (op == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
