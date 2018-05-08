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
		
		  PreparedStatement st  = null;
		
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
			
            st = con.prepareStatement("insert into profesores (usuario, contraseña) values (?,?)");
            st.setString(1, profe.getUsuario());
            st.setString(2, profe.getPass());
            st.execute();
            JOptionPane.showConfirmDialog(null, "Usuario guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Usuario ya existente");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }finally {	        	
        	try {	        		
        		if(st != null) {
        			st.close();
        		}
        		if (con != null) {
        			conexion.desconectar(con);
        		}	    	
    		}catch(SQLException e) {
    			 System.out.println("No se pudo cerrar");
    		}		        	
        }
	}
	
	
	public boolean buscarUsuario(Profesor profe) {
		
		boolean encontrado = false;
		
		PreparedStatement st = null;
		ResultSet rs = null;
				
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
			st = con.prepareStatement("SELECT * FROM profesores where usuario = ? AND contraseña = ?");
			st.setString(1, profe.getUsuario());
			st.setString(2, profe.getPass());
								//Si queremos guardar todas las columnas en una especie de coleccion haremos ResultSet rs = st.executeQuery();
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("usuario").equals(profe.getUsuario()) && rs.getString("contraseña").equals(profe.getPass())){
					encontrado = true;
				}
			}			
		}catch(SQLException e) {
			JOptionPane.showConfirmDialog(null, e.getMessage(), "Error al logearse", JOptionPane.CANCEL_OPTION);
		}catch(ClassNotFoundException er) {
			er.printStackTrace();
		}finally {	        	
        	try {	
        		if(rs != null) {
        			rs.close();
        		}
        		if(st != null) {
        			st.close();
        		}
        		if (con != null) {
        			conexion.desconectar(con);
        		}	    	
    		}catch(SQLException e) {
    			 System.out.println("No se pudo cerrar");
    		}		        	
        }
		return encontrado;
	}			
}
