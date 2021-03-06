package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Alumno;

public class AlumnoPersistencia {

	private AccesoDB acceso;

	
	public  AlumnoPersistencia() {
		this.acceso = new AccesoDB();
	}

	/*
	 * Metodo que recibe un objeto de tipo alumno y lo añade a la base de datos.
	 */
	public void añadirAlumno(Alumno alu) {
		Connection con = null;
		PreparedStatement st = null;

		try {

			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.prepareStatement("insert into alumnos (nombre, numExpediente) values (?,?)");
			st.setString(1, alu.getNombre());
			st.setInt(2, alu.getExpediente());
			st.execute();
			JOptionPane.showConfirmDialog(null, "Usuario guardado correctamente", "Mensaje de confirmación",
					JOptionPane.CLOSED_OPTION);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Usuario ya existente");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Los 3 campos deben estar rellenos debidamente", "Error",
					JOptionPane.CANCEL_OPTION);
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
	}

	/*
	 * Metodo que devolvera un arrayList de alumnos con la lista completa de alumnos
	 * guardados en la base de datos
	 */
	public ArrayList<Alumno> cargarAlumnos() {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno al;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.createStatement();
			rs = st.executeQuery("Select * from alumnos");

			while (rs.next()) {
				al = new Alumno(rs.getString(2), rs.getInt(3));
				alumnos.add(al);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
		return alumnos;
	}

	/*
	 * Metodo que recibe un objeto de tipo alumno y elimina dicho alumno de la base
	 * de datos.
	 */

	public void eliminarAlumno(Alumno al) {

		PreparedStatement st = null;
		Connection con = null;
		try {

			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.prepareStatement("Delete from alumnos where numExpediente =?");
			st.setInt(1, al.getExpediente());
			st.execute();
			JOptionPane.showConfirmDialog(null, "Usuario eliminado correctamente", "Mensaje de confirmación",
					JOptionPane.CLOSED_OPTION);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null,
					"Error,este alumno esta vinculado a un proyecto porfavor elimine el proyecto o desvincule al alumno del mismo");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {

			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
	}

	/*
	 * Metodo que recibe un alumno y el id de dicho alumno para poder modificarle
	 * con nuevos valores en sus campos.
	 */
	public void modificarAlumno(Alumno al, int id) {

		PreparedStatement sm = null;
		Connection con = null;

		try {
			
			con = acceso.conectar();
			System.out.println("Conectado");

			sm = con.prepareStatement("update alumnos set nombre = ?,numExpediente = ? where ID_A = ?");
			sm.setString(1, al.getNombre());
			sm.setInt(2, al.getExpediente());
			sm.setInt(3, id);
			sm.execute();
			JOptionPane.showConfirmDialog(null, "Usuario modificado correctamente", "Mensaje de confirmación",
					JOptionPane.CLOSED_OPTION);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {

			try {
				if (sm != null) {
					sm.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}

	}

	/*
	 * Metodo que recibe un alumno y devuelve el id de dicho alumno.
	 */
	public int obtenerID(Alumno al) {

		int id = 0;
		Connection con = null;
		PreparedStatement sm = null;

		try {

			con = acceso.conectar();
			System.out.println("Conectado");

			sm = con.prepareStatement("select ID_A from alumnos where numExpediente = ?");
			sm.setInt(1, al.getExpediente());
			ResultSet rs = sm.executeQuery();

			id = rs.getInt(1);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception er) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {

			try {
				if (sm != null) {
					sm.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
		return id;
	}

	/*
	 * Metodo que devolvera un arraylist de los alumnos de la base de datos, pero
	 * filtrados por un parametro que recibe el metodo.
	 */
	public ArrayList<Alumno> cargarAlumnosFiltrado(String consulta) {

		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno al;
		Statement st = null;
		ResultSet rs = null;
		Connection con = null;

		try {

			con = acceso.conectar();
			System.out.println("Conectado");

			st = con.createStatement();
			rs = st.executeQuery(consulta);

			while (rs.next()) {
				al = new Alumno(rs.getString(2), rs.getInt(3));
				alumnos.add(al);
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error");
		} catch (ClassNotFoundException er) {
			er.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (con != null) {
					acceso.desconectar(con);
				}
			} catch (SQLException e) {
				System.out.println("No se pudo cerrar");
			}
		}
		return alumnos;
	}
}
