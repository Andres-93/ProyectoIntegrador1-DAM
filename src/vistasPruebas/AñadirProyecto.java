package vistasPruebas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class AñadirProyecto extends JPanel {
	private JTextField textNombre;
	private JTextField textUrl;
	private JSpinner spinnerNota;
	private JSpinner spinnerAno;
	private JComboBox comboBoxGrupo;
	private JComboBox comboBoxCiclo;
	private JList listAlumnos;
	public AñadirProyecto() {
		setLayout(null);
		setBounds(0,0,700,625);
		
		JLabel lblAadirProyecto = new JLabel("A\u00D1ADIR PROYECTO");
		lblAadirProyecto.setBorder(new LineBorder(Color.WHITE, 2));
		lblAadirProyecto.setFont(new Font("Sitka Text", Font.BOLD, 42));
		lblAadirProyecto.setForeground(Color.WHITE);
		lblAadirProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadirProyecto.setBounds(132, 11, 431, 73);
		add(lblAadirProyecto);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(10, 131, 104, 29);
		add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(112, 131, 177, 29);
		add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblUrlGithub = new JLabel("URL GITHUB");
		lblUrlGithub.setHorizontalAlignment(SwingConstants.CENTER);
		lblUrlGithub.setForeground(Color.WHITE);
		lblUrlGithub.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUrlGithub.setBounds(317, 131, 104, 29);
		add(lblUrlGithub);
		
		textUrl = new JTextField();
		textUrl.setColumns(10);
		textUrl.setBounds(461, 131, 177, 29);
		add(textUrl);
		
		JLabel lblNota = new JLabel("NOTA");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setForeground(Color.WHITE);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNota.setBounds(10, 186, 104, 29);
		add(lblNota);
		
		spinnerNota = new JSpinner();
		spinnerNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinnerNota.setBounds(112, 184, 63, 36);
		add(spinnerNota);
		
		JLabel lblAo = new JLabel("A\u00D1O");
		lblAo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAo.setForeground(Color.WHITE);
		lblAo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAo.setBounds(10, 331, 104, 29);
		add(lblAo);
		
		spinnerAno = new JSpinner();
		spinnerAno.setModel(new SpinnerNumberModel(2018, 2018, 2040, 1));
		spinnerAno.setBounds(112, 329, 63, 36);
		add(spinnerAno);
		
		JLabel lblCruso = new JLabel("CURSO");
		lblCruso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCruso.setForeground(Color.WHITE);
		lblCruso.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCruso.setBounds(10, 262, 104, 29);
		add(lblCruso);
		
		JComboBox comboCurso = new JComboBox();
		comboCurso.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboCurso.setBounds(112, 260, 63, 36);
		add(comboCurso);
		
		JLabel lblGrupo = new JLabel("GRUPO");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setForeground(Color.WHITE);
		lblGrupo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGrupo.setBounds(317, 195, 104, 29);
		add(lblGrupo);
		
		comboBoxGrupo = new JComboBox();
		comboBoxGrupo.setModel(new DefaultComboBoxModel(new String[] {"M11", "M12", "T11", "T12"}));
		comboBoxGrupo.setBounds(461, 192, 63, 36);
		add(comboBoxGrupo);
		
		JLabel lblCiclo = new JLabel("CICLO");
		lblCiclo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclo.setForeground(Color.WHITE);
		lblCiclo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCiclo.setBounds(317, 271, 104, 29);
		add(lblCiclo);
		
		comboBoxCiclo = new JComboBox();
		comboBoxCiclo.setBounds(461, 268, 218, 36);
		add(comboBoxCiclo);
		
		JLabel lblAlumnos = new JLabel("ALUMNOS");
		lblAlumnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlumnos.setForeground(Color.WHITE);
		lblAlumnos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAlumnos.setBounds(26, 390, 104, 29);
		add(lblAlumnos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 440, 470, 163);
		add(scrollPane);
		
		listAlumnos = new JList();
		scrollPane.setViewportView(listAlumnos);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AñadirProyecto.class.getResource("/images/FondoAlumnos700X700.png")));
		label.setBounds(0, 0, 700, 625);
		add(label);
	}
}
