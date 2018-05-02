package ejecutable;

import java.awt.EventQueue;

import controlador.ControladorApp;
import vista.AñadirCiclo;
import vista.ConsultaAlumnoNuevo;
import vista.ModificarAlumnos;
import vista.EliminarAlumno;
import vista.EliminarCiclo;
import vista.ModificarAlumno;
import vista.ModificarCicloJD;
import vista.ModificarCliclo;
import vista.PanelLogin;
import vista.PanelPrincipal;
import vista.RegistrarProfesor;
import vista.VistaPrincipal;
import vista.añadirAlumnos;

public class MainEjecutable {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				VistaPrincipal prueba = new VistaPrincipal();
				PanelPrincipal panel1 = new PanelPrincipal();
				PanelLogin panel2 = new PanelLogin();
				añadirAlumnos panel3 = new añadirAlumnos();
				EliminarAlumno panel4 = new EliminarAlumno();
				ModificarAlumnos panel5 = new ModificarAlumnos();
				RegistrarProfesor panel6 = new RegistrarProfesor();
				AñadirCiclo panel7 = new AñadirCiclo();
				ModificarAlumno panel8 = new ModificarAlumno();
				EliminarCiclo panel9 = new EliminarCiclo();
				ModificarCliclo panel10 = new ModificarCliclo();
				ModificarCicloJD panel11 = new ModificarCicloJD();
				ConsultaAlumnoNuevo panel12 = new ConsultaAlumnoNuevo();
				ControladorApp control = new ControladorApp(prueba);
				
				//con.conectar();							//Abrimos la comunicacion con la base de datos
														//FALTA CERRAR LA BASE AL SALIR
				
				control.setPanel1(panel1);
				control.setPanel2(panel2);
				control.setPanel3(panel3);
				control.setPanel4(panel4);
				control.setPanel5(panel5);
				control.setPanel6(panel6);
				control.setPanel7(panel7);
				control.setPanel8(panel8);
				control.setPanel9(panel9);
				control.setPanel10(panel10);
				control.setPanel11(panel11);
				control.setPanel12(panel12);
				
				panel2.setControlador(control);		//Todos los panelesd se le presentan al controlador
				panel1.setControlador(control);
				panel3.setControlador(control);
				prueba.setControlador(control);
				panel4.setControlador(control);
				panel5.setControlador(control);
				panel6.setControlador(control);
				panel7.setControlador(control);
				panel8.setControlador(control);
				panel9.setControlador(control);
				panel10.setControlador(control);
				panel11.setControlador(control);
				panel12.setControlador(control);
				
				prueba.hacerVisible();
				prueba.setPanel(panel2);
			}
		});

	}

}
