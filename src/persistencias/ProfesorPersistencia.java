package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Profesor;

public class ProfesorPersistencia {

	AccesoDB conexion = new AccesoDB("org.sqlite.JDBC", "jdbc:sqlite:C:\\Users\\PcCom\\Desktop\\sqlite\\SQLiteDatabaseBrowserPortable\\Data\\Prueba.db");

	Connection con;
		
	public void añadirProfesor(Profesor profe) {
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException | ClassNotFoundException e) {
			e.getMessage();
		}
		
		try {
            PreparedStatement st = con.prepareStatement("insert into profesores (usuario, contraseña) values (?,?)");
            st.setString(1, profe.getUsuario());
            st.setString(2, profe.getPass());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Usuario guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Usuario ya existente");
        }
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}
	}
	
	
	public boolean buscarUsuario(Profesor profe) {
		
		boolean encontrado = false;
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, "Error al conectar","Error", JOptionPane.CANCEL_OPTION);
		}catch(ClassNotFoundException e) {
			JOptionPane.showConfirmDialog(null, "No se encontro la clase","Error", JOptionPane.CANCEL_OPTION);
		}
		
				
		try {
			PreparedStatement st = con.prepareStatement("SELECT * FROM profesores where usuario = ? AND contraseña = ?");
			st.setString(1, profe.getUsuario());
			st.setString(2, profe.getPass());
								//Si queremos guardar todas las columnas en una especie de coleccion haremos ResultSet rs = st.executeQuery();
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usuario").equals(profe.getUsuario()) && rs.getString("contraseña").equals(profe.getPass())){
					encontrado = true;
				}
			}			
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error al logearse", JOptionPane.CANCEL_OPTION);
		}	
		
		try {
			conexion.desconectar(con);
		}catch(SQLException e) {
			 System.out.println("No se pudo cerrar");
		}
		return encontrado;
	}
	
	
	
}
