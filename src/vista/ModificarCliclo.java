package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;
import modelo.Ciclo;
import persistencias.AlumnoPersistencia;
import persistencias.CicloPersistencia;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModificarCliclo extends JPanel {
	private JList listCiclos;
	private JButton btnModificarCi;
	private JButton btnCancelar;
	private JTextField textFiltro;
	private JButton btnFiltrarCiclos;
	private JComboBox comboBox;

	public ModificarCliclo() {
		inicializar();
	}

	private void inicializar() {
		setBounds(0, 0, 700, 625);
		setLayout(null);

		JLabel lblModificarCiclo = new JLabel("MODIFICAR CICLO");
		lblModificarCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblModificarCiclo.setForeground(Color.WHITE);
		lblModificarCiclo.setFont(new Font("Sylfaen", Font.BOLD, 44));
		lblModificarCiclo.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblModificarCiclo.setBounds(87, 40, 506, 72);
		add(lblModificarCiclo);

		JLabel label_1 = new JLabel("LISTA CICLOS:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Banner", Font.BOLD, 20));
		label_1.setBounds(47, 232, 204, 41);
		add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(47, 284, 599, 241);
		add(scrollPane);

		listCiclos = new JList();
		scrollPane.setViewportView(listCiclos);

		listCiclos = new JList();
		scrollPane.setViewportView(listCiclos);

		btnModificarCi = new JButton("");
		btnModificarCi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificarCi
				.setRolloverIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/botonModificarPulsado.png")));
		btnModificarCi.setIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/botonModificar.png")));
		btnModificarCi.setFocusPainted(false);
		btnModificarCi.setContentAreaFilled(false);
		btnModificarCi.setBorderPainted(false);
		btnModificarCi.setBorder(null);
		btnModificarCi.setBounds(47, 559, 188, 55);
		add(btnModificarCi);

		btnCancelar = new JButton("");
		btnCancelar
				.setRolloverIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(443, 559, 188, 55);
		add(btnCancelar);

		JLabel label_2 = new JLabel("FILTRAR:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sitka Small", Font.BOLD, 18));
		label_2.setBounds(25, 123, 115, 41);
		add(label_2);

		textFiltro = new JTextField();
		textFiltro.setBounds(284, 161, 290, 41);
		add(textFiltro);
		textFiltro.setColumns(10);

		btnFiltrarCiclos = new JButton("");
		btnFiltrarCiclos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFiltrarCiclos
				.setRolloverIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/botonFiltrarPulsado.png")));
		btnFiltrarCiclos.setIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/botonFiltrar.png")));
		btnFiltrarCiclos.setFocusPainted(false);
		btnFiltrarCiclos.setContentAreaFilled(false);
		btnFiltrarCiclos.setBorderPainted(false);
		btnFiltrarCiclos.setBorder(null);
		btnFiltrarCiclos.setBounds(223, 212, 188, 55);
		add(btnFiltrarCiclos);

		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 204));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Ver todos", "Nombre" }));
		comboBox.setBounds(111, 161, 115, 41);
		add(comboBox);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ModificarCliclo.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}

	public void setControlador(ControladorApp c) { // Deberemos presentarle todos los botones al controlador
		btnModificarCi.addActionListener(c);
		btnCancelar.addActionListener(c);
		btnFiltrarCiclos.addActionListener(c);
	}

	public JButton getBtnModificarCi() {
		return btnModificarCi;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnFiltrarCiclos() {
		return btnFiltrarCiclos;
	}

	public void mostrarCiclos(ArrayList<Ciclo> ciclos) {

		DefaultListModel<Ciclo> model = new DefaultListModel<Ciclo>();

		for (int i = 0; i < ciclos.size(); i++) {

			model.addElement(ciclos.get(i));
		}
		listCiclos.setModel(model);
	}

	public Ciclo cicloSelecionado() {

		Ciclo ci = null;

		ci = (Ciclo) listCiclos.getSelectedValue();

		return ci;
	}

	public void filtrar() {

		ArrayList<Ciclo> listaFiltrada = new ArrayList<Ciclo>();
		ArrayList<Ciclo> listaCompleta = new CicloPersistencia().cargarCiclos();

		if (comboBox.getSelectedItem().toString().equals("Ver todos")) {

			mostrarCiclos(listaCompleta);

		} else {
			for (int i = 0; i < listaCompleta.size(); i++) {
				if (listaCompleta.get(i).getNombre().equals(textFiltro.getText())) {
					listaFiltrada.add(listaCompleta.get(i));
				}
			}
			mostrarCiclos(listaFiltrada);
		}
	}
}
