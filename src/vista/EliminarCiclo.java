package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Ciclo;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class EliminarCiclo extends JPanel {
	private JButton btnEliminarCiclo;
	private JButton btnCancelar;
	private JList listCi;
	public EliminarCiclo() {
		inicializar();
	}

	private void inicializar() {
		setBounds(0,0,700,625);
		setLayout(null);
		
		JLabel label = new JLabel("ELIMINAR CICLOS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Small", Font.BOLD, 50));
		label.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		label.setBounds(96, 65, 521, 90);
		add(label);
		
		btnEliminarCiclo = new JButton("");
		btnEliminarCiclo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarCiclo.setIcon(new ImageIcon(EliminarCiclo.class.getResource("/images/BotonoEliminar.png")));
		btnEliminarCiclo.setFocusPainted(false);
		btnEliminarCiclo.setContentAreaFilled(false);
		btnEliminarCiclo.setBorderPainted(false);
		btnEliminarCiclo.setBorder(null);
		btnEliminarCiclo.setBounds(58, 548, 193, 49);
		add(btnEliminarCiclo);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(new ImageIcon(EliminarCiclo.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(EliminarCiclo.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(429, 542, 188, 55);
		add(btnCancelar);
		
		JLabel label_1 = new JLabel("LISTA CICLOS:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label_1.setBounds(47, 268, 204, 41);
		add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 320, 592, 204);
		add(scrollPane);
		
		listCi = new JList();
		scrollPane.setViewportView(listCi);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(EliminarCiclo.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 625);
		add(lblNewLabel);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
		btnEliminarCiclo.addActionListener(c);
	}
	public JButton getBtnEliminarCiclo() {
		return btnEliminarCiclo;
	}
	public JButton getBtnCanceloar() {
		return btnCancelar;
	}
	
	public void mostrarCiclos(ArrayList<Ciclo> ciclos) {
		
		DefaultListModel<Ciclo> model = new DefaultListModel<Ciclo>();
		
		for(int i = 0 ; i <ciclos.size(); i++) {
			
			model.addElement(ciclos.get(i));
		}
		 listCi.setModel(model);
	}

	
	public Ciclo ciclossAEliminar() {
		
		Ciclo ci;
		
		ci = (Ciclo) listCi.getSelectedValue();

		return ci;
	}
	
}
