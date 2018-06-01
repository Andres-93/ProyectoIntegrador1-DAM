package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import controlador.ControladorApp;
import modelo.Alumno;

import javax.swing.JButton;
import java.awt.Cursor;

public class añadirAlumnos extends JPanel {
	private JTextField textNombreAl;
	private JTextField textExpAl;
	private JButton btnCancelar;
	private JButton btnAnadir;
	public añadirAlumnos() {
		inicializar();
		
	}

	private void inicializar() {
		
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLayout(null);
		setBounds(0,0,700,700);
		textNombreAl = new JTextField();
		textNombreAl.setBounds(325, 264, 298, 36);
		add(textNombreAl);
		textNombreAl.setColumns(10);
		
		textExpAl = new JTextField();
		textExpAl.setColumns(10);
		textExpAl.setBounds(348, 427, 245, 36);
		add(textExpAl);
		
		btnCancelar = new JButton("");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setRolloverIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/PulsadoBotonCancelar.png")));
		btnCancelar.setIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/BotonCancelar.png")));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorderPainted(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(435, 505, 188, 55);
		add(btnCancelar);
		
		btnAnadir = new JButton("");
		btnAnadir.setRolloverIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/PulsadoBotonA\u00F1adir.png")));
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.setIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/BotonA\u00F1adir.png")));
		btnAnadir.setFocusPainted(false);
		btnAnadir.setContentAreaFilled(false);
		btnAnadir.setBorderPainted(false);
		btnAnadir.setBorder(null);
		btnAnadir.setBounds(135, 505, 188, 55);
		add(btnAnadir);
		
		JLabel lblNewLabel_3 = new JLabel("A\u00D1ADIR ALUMNO");
		lblNewLabel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.WHITE));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Sitka Small", Font.BOLD, 50));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(121, 85, 502, 90);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre Completo");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(37, 260, 236, 42);
		add(lblNewLabel_2);
		
		JLabel lblNumeroDeExpediente = new JLabel("N\u00BA Expediente");
		lblNumeroDeExpediente.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeExpediente.setForeground(Color.WHITE);
		lblNumeroDeExpediente.setFont(new Font("Sitka Small", Font.BOLD, 20));
		lblNumeroDeExpediente.setBounds(98, 423, 188, 42);
		add(lblNumeroDeExpediente);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/LogoMirmidonBajo.png")));
		lblNewLabel_1.setBounds(0, 525, 100, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(añadirAlumnos.class.getResource("/images/FondoAlumnos700X700.png")));
		lblNewLabel.setBounds(0, 0, 700, 625);				//El ancho hacia abajo debe ser 625 ya que el menu empuja todo 75 pixeles hacia abajo.
		add(lblNewLabel);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnCancelar.addActionListener(c);										//aqui iran los botones de añadir y cancelar.
		btnAnadir.addActionListener(c);
	}
	
	public Alumno getDatos() {
		
		Alumno alumno = null;
		
		if(textNombreAl.getText().equals("") || textExpAl.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Ninguno de los campos debe estar en blanco");
		}else {
			try {
				alumno = new Alumno(textNombreAl.getText(), Integer.parseInt(textExpAl.getText()));
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error, el expediente deben ser unicamente numeros");
				
			}
		}
			
		return alumno;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}	
}
