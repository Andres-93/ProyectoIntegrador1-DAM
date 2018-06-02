package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import controlador.ControladorApp;
import modelo.Profesor;

import java.awt.Cursor;

public class PanelLogin extends JPanel {
	private JButton btnBoton;
	private JLabel label;
	private JButton buttonAccesoAlumno;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	public PanelLogin() {
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
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 398, 210, 30);
		add(passwordField);
		
		buttonAccesoAlumno = new JButton("");
		buttonAccesoAlumno.setRolloverIcon(new ImageIcon(PanelLogin.class.getResource("/images/PulsadoAlumno.png")));
		buttonAccesoAlumno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAccesoAlumno.setIcon(new ImageIcon(PanelLogin.class.getResource("/images/botonAccesAlumno.png")));
		buttonAccesoAlumno.setFocusPainted(false);
		buttonAccesoAlumno.setContentAreaFilled(false);
		buttonAccesoAlumno.setBorderPainted(false);
		buttonAccesoAlumno.setBorder(null);
		buttonAccesoAlumno.setForeground(Color.BLACK);
		buttonAccesoAlumno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonAccesoAlumno.setBackground(new Color(0, 102, 204));
		buttonAccesoAlumno.setBounds(384, 462, 185, 51);
		add(buttonAccesoAlumno);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(275, 343, 210, 30);
		add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		btnBoton = new JButton("");
		btnBoton.setRolloverIcon(new ImageIcon(PanelLogin.class.getResource("/images/pulsadoProfesor.png")));
		btnBoton.setPressedIcon(null);
		btnBoton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBoton.setIcon(new ImageIcon(PanelLogin.class.getResource("/images/BotonAcessProfe.png")));
		btnBoton.setFocusPainted(false);
		btnBoton.setContentAreaFilled(false);
		btnBoton.setBorderPainted(false);
		btnBoton.setBorder(null);
		btnBoton.setBackground(new Color(0, 102, 204));
		btnBoton.setForeground(new Color(0, 0, 0));
		btnBoton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBoton.setBounds(161, 462, 185, 51);
		add(btnBoton);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContrasea.setBounds(94, 385, 185, 51);
		add(lblContrasea);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(94, 330, 185, 51);
		add(lblUsuario);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(PanelLogin.class.getResource("/images/icono2.png")));
		label_1.setBounds(-10, 0, 600, 254);
		add(label_1);
		
		label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		label.setIcon(new ImageIcon(PanelLogin.class.getResource("/images/fondo2.jpg")));
		label.setBounds(0, 0, 700, 700);
		add(label);
	}
	
	public void setControlador(ControladorApp c) {		//Deberemos presentarle todos los botones al controlador
		btnBoton.addActionListener(c);
		buttonAccesoAlumno.addActionListener(c);
	}

	public JButton getBtnBoton() {			//Necesitamos generar los getteres de todos los botones para poder diferenciarlos en el metodo ActionListener del controlador.
		return btnBoton;
	}

	public JButton getButtonAccesoAlumno() {
		return buttonAccesoAlumno;
	}
	
	public Profesor getDatos() {
		
		Profesor profe;
		
		profe = new Profesor(textFieldUsuario.getText(), passwordField.getText());			//He usado otro diferente al getText en la pass porque ponia que estaba ya deprecated el getText normal.
		
		return profe;
		
	}
	
	public void borrarCampos() {
		textFieldUsuario.setText("");
		passwordField.setText("");
	}
	
}
