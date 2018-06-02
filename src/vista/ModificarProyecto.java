package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Proyecto;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class ModificarProyecto extends JPanel {
	private JList<Proyecto> listPro;
	private JButton btnModificarPro;
	private JButton btnCancelar;

	public ModificarProyecto() {
		inicializar();
	}

	private void inicializar() {
		setLayout(null);
		setBounds(0, 0, 700, 625);

		JLabel lblModificarProyecto = new JLabel("MODIFICAR PROYECTO");
		lblModificarProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarProyecto.setForeground(Color.WHITE);
		lblModificarProyecto.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblModificarProyecto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblModificarProyecto.setBounds(24, 37, 630, 90);
		add(lblModificarProyecto);

		JLabel label_1 = new JLabel("LISTA PROYECTOS:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label_1.setBounds(24, 215, 248, 41);
		add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 249, 611, 253);
		add(scrollPane);

		listPro = new JList();
		scrollPane.setViewportView(listPro);

		btnModificarPro = new JButton("");
		btnModificarPro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarPro.setRolloverIcon(
				new ImageIcon(ModificarProyecto.class.getResource("/images/botonModificarPulsado.png")));
		btnModificarPro.setIcon(new ImageIcon(ModificarProyecto.class.getResource("/images/botonModificar.png")));
		btnModificarPro.setFocusPainted(false);
		btnModificarPro.setContentAreaFilled(false);
		btnModificarPro.setBorderPainted(false);
		btnModificarPro.setBorder(null);
		btnModificarPro.setBounds(49, 537, 188, 55);
		add(btnModificarPro);

		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(
				new ImageIcon(ModificarProyecto.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarProyecto.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(428, 537, 188, 55);
		add(btnCancelar);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificarProyecto.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnModificarPro.addActionListener(c);
		btnCancelar.addActionListener(c);
	}

	public JButton getBtnModificarPro() {
		return btnModificarPro;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void mostrarProyectos(ArrayList<Proyecto> pro) {

		DefaultListModel<Proyecto> model = new DefaultListModel<Proyecto>();

		for (int i = 0; i < pro.size(); i++) {

			model.addElement(pro.get(i));
		}
		listPro.setModel(model);
	}

	public Proyecto obtenerSelecionado() {

		Proyecto pro = null;

		pro = listPro.getSelectedValue();

		return pro;
	}

}
