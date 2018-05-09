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
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Cursor;

public class ConsultaCiclos extends JPanel {
	private JList listCiclos;
	private JButton btnCancelar;
	public ConsultaCiclos() {
		setLayout(null);
		setBounds(0, 0, 700, 625);
		
		JLabel lblCiclos = new JLabel("CICLOS");
		lblCiclos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclos.setForeground(Color.WHITE);
		lblCiclos.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblCiclos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblCiclos.setBounds(143, 30, 425, 78);
		add(lblCiclos);
		
		JLabel lblListaCiclos = new JLabel("LISTA CICLOS:");
		lblListaCiclos.setForeground(Color.WHITE);
		lblListaCiclos.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblListaCiclos.setBounds(38, 146, 204, 41);
		add(lblListaCiclos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 200, 628, 332);
		add(scrollPane);
		
		listCiclos = new JList();
		scrollPane.setViewportView(listCiclos);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(new ImageIcon(ConsultaCiclos.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ConsultaCiclos.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(244, 543, 188, 55);
		add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConsultaCiclos.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 625);
		add(lblNewLabel);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);
	}
	
	
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void mostrarCiclos(ArrayList<Ciclo> ciclos) {
		
		DefaultListModel<Ciclo> model = new DefaultListModel<Ciclo>();
		
		for(int i = 0 ; i <ciclos.size(); i++) {
			
			model.addElement(ciclos.get(i));
		}
		 listCiclos.setModel(model);
	}

	
}
