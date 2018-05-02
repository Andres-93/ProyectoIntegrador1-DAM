package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

public class ConsultaAlumnoNuevo extends JPanel {
	private JList listaAl;
	private JButton btnCancelar;
	public ConsultaAlumnoNuevo() {
		
		inicializar();
	}
	private void inicializar() {
		setLayout(null);
		setBounds(0,0,700,625);
		
		JLabel lblAlumnos = new JLabel("ALUMNOS");
		lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnos.setForeground(Color.WHITE);
		lblAlumnos.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblAlumnos.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblAlumnos.setBounds(78, 51, 471, 78);
		add(lblAlumnos);
		
		JLabel label_1 = new JLabel("LISTA ALUMNOS:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.BOLD, 20));
		label_1.setBounds(52, 175, 204, 41);
		add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 227, 586, 313);
		add(scrollPane);
		
		listaAl = new JList();
		scrollPane.setViewportView(listaAl);
		
		btnCancelar = new JButton("");
		btnCancelar.setRolloverIcon(new ImageIcon(ConsultaAlumnoNuevo.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(ConsultaAlumnoNuevo.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(263, 551, 188, 55);
		add(btnCancelar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ConsultaAlumnoNuevo.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);		
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public void mostrarAlumnos(ArrayList<Alumno> alumnos) {
		
		DefaultListModel<Alumno> model = new DefaultListModel<Alumno>();
		
		for(int i = 0 ; i <alumnos.size(); i++) {
			
			model.addElement(alumnos.get(i));
		}
		 listaAl.setModel(model);
	}
}
