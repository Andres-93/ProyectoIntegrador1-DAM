package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Ciclo;
import modelo.Proyecto;
import persistencias.PoryectoPersistencia;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class EliminarProyecto extends JPanel {
	private JList<Proyecto> listPro;
	private JButton btnEliminarPro;
	private JButton btnCancelar;
	public EliminarProyecto() {

		inicializar();
	}
	private void inicializar() {
		setLayout(null);
		
		JLabel lblEliminarProyecto = new JLabel("ELIMINAR PROYECTO");
		lblEliminarProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarProyecto.setForeground(Color.WHITE);
		lblEliminarProyecto.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblEliminarProyecto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblEliminarProyecto.setBounds(43, 37, 625, 90);
		add(lblEliminarProyecto);
		
		JLabel lblListaProyectos = new JLabel("LISTA PROYECTOS:");
		lblListaProyectos.setForeground(Color.WHITE);
		lblListaProyectos.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblListaProyectos.setBounds(43, 229, 248, 41);
		add(lblListaProyectos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 270, 597, 284);
		add(scrollPane);
		
		listPro = new JList();
		scrollPane.setViewportView(listPro);
		
		btnEliminarPro = new JButton("");
		btnEliminarPro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarPro.setRolloverIcon(new ImageIcon(EliminarProyecto.class.getResource("/images/botonEliminarPulsado.png")));
		btnEliminarPro.setIcon(new ImageIcon(EliminarProyecto.class.getResource("/images/BotonoEliminar.png")));
		btnEliminarPro.setFocusPainted(false);
		btnEliminarPro.setContentAreaFilled(false);
		btnEliminarPro.setBorderPainted(false);
		btnEliminarPro.setBorder(null);
		btnEliminarPro.setBounds(64, 565, 193, 49);
		add(btnEliminarPro);
		
		btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(EliminarProyecto.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(EliminarProyecto.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(421, 565, 188, 55);
		add(btnCancelar);
		
		setBounds(0,0,700,625);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EliminarProyecto.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 625);
		add(lblNewLabel);
	}
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
		btnEliminarPro.addActionListener(c);
	}
	public JButton getBtnEliminarPro() {
		return btnEliminarPro;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void mostrarProyectos(ArrayList<Proyecto> pro) {
		
		DefaultListModel<Proyecto> model = new DefaultListModel<Proyecto>();
		
		for(int i = 0 ; i <pro.size(); i++) {
			
			model.addElement(pro.get(i));
		}
		 listPro.setModel(model);
	}
	
	
	public Proyecto ProyectoAEliminar() {
		
		Proyecto pro = null;
		
		pro = listPro.getSelectedValue();

		return pro;
	}
}
