package persistencias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Alumno;
import modelo.Ciclo;
import modelo.Proyecto;

public class PoryectoPersistencia {

	AccesoDB conexion = new AccesoDB("org.sqlite.JDBC", "jdbc:sqlite:Prueba.db");

	Connection con;
		
	
public void añadirProyecto(Proyecto pro) {
		
		PreparedStatement st = null;	
	
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
            st = con.prepareStatement("insert into proyectos (nombre,url,nota,año,curso,grupo,ciclo) values (?,?,?,?,?,?,?)");
            st.setString(1, pro.getNombre());
            st.setString(2, pro.getUrl());
            st.setDouble(3, pro.getNota());
            st.setInt(4, pro.getAño());
            st.setInt(5, pro.getCurso());
            st.setString(6, pro.getGrupo());
            st.setInt(7, new CicloPersistencia().obtenerID(pro.getCiclo().getNombre()));           
            st.execute();
            
            
            /*Introducimos la relacion en la tabla se_realizan de la base de datos entre alumnos y proyectos.
             * Obtenemos el id del proyecto y lo volcamos en una variable, y tambien la lista de integrantes del equipo.
             * En unn bucle recorremos la lista de alumnos para ir metiendo sus ids en la tabla se_realizan con su respectivo proyecto.
             */
            
            int id = new PoryectoPersistencia().obtenerID(pro);					
            ArrayList<Alumno> listaAux = pro.getIntegrantes();
            
            st = con.prepareStatement("insert into se_realizan (proyecto, alumno) values (?,?)");
            
            for (int i = 0; i <listaAux.size(); i++) {           	
            	st.setInt(1, id);
                st.setInt(2, new AlumnoPersistencia().obtenerID(listaAux.get(i)));
                st.execute();         	
            }
            
                    
            JOptionPane.showConfirmDialog(null, "Proyecto guardado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Proyecto ya existente");
        }catch (ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Los 3 campos deben estar rellenos debidamente", "Error", JOptionPane.CANCEL_OPTION);
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

	public int obtenerID(Proyecto pro) {
	
		int id = 0;
		
		PreparedStatement sm = null;
				
		try {
			con = conexion.conectar();
			System.out.println("Conectado");
									
			sm = con.prepareStatement("select id_p from proyectos where nombre = ?");
	        sm.setString(1, pro.getNombre());
	        ResultSet rs = sm.executeQuery();
	        
	        id = rs.getInt(1);
	        
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch (ClassNotFoundException er){
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);		
	        }finally {	        	
	        	try {
	        		if(sm != null) {
	        			sm.close();
	        		}
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }		
		
		return id;
	}
	
	
	public ArrayList<Proyecto> cargarProyectos() {
		
		ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
		Proyecto pro;
		Statement st = null;
        ResultSet rs = null;
		
				
		try {		
			con = conexion.conectar();
			System.out.println("Conectado");
			
			st = con.createStatement();
			rs = st.executeQuery("Select * from proyectos");
           
           while(rs.next()) {      	   
        	   pro = new Proyecto(rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5), rs.getInt(6), rs.getString(7));
        	   proyectos.add(pro);      	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
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
    			 System.out.println(e.getMessage());
    		}		        	
        }
		
		return proyectos;
	}
	
	
	public void eliminarProyecto(Proyecto pro) {
		
		
		  PreparedStatement st = null;
		
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
			
			//Primero eliminaremos todas las referencias a este proyecto de la tabla se_realizan.
			
            st = con.prepareStatement("Delete from se_realizan  where proyecto =?");          
            st.setInt(1, new PoryectoPersistencia().obtenerID(pro));
            st.execute();
            
            //Por ultimo eliminamos el proyecto.
            
            st = con.prepareStatement("Delete from proyectos where nombre = ?");
            st.setString(1, pro.getNombre());
            st.execute();
            
            JOptionPane.showConfirmDialog(null, "Proyecto eliminado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch (ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
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
	
	public ArrayList<Alumno> cargarAlumnosDePro(Proyecto pro) {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		Alumno al;
		Statement st = null;
        ResultSet rs = null;
        ResultSet rt = null;
        PreparedStatement pt = null;
		int id = 0;
				
		try {		
			con = conexion.conectar();
			System.out.println("Conectado");
			
			id = new PoryectoPersistencia().obtenerID(pro);
			
			st = con.createStatement();
			rs = st.executeQuery("Select * from se_realizan where proyecto = " + id);
           
           while(rs.next()) {      	   
        	       
        	   pt = con.prepareStatement("Select * from alumnos where ID_A = ?");
        	   pt.setInt(1, rs.getInt(2));
        	   rt = pt.executeQuery();
        	   while(rt.next()) {
        		   al = new Alumno(rt.getString(2), rt.getInt(3));
        		   alumnos.add(al);
        	   }
        	   
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error");
        }catch(ClassNotFoundException er) {
        	er.printStackTrace();
        }catch(Exception e) {
        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
        }finally {	        	
        	try {
        		if(rt != null) {
        			rt.close();
        		}
        		if(pt != null) {
        			pt.close();
        		}
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
    			 System.out.println(e.getMessage());
    		}		        	
        }
		
		return alumnos;
	}
	
	public void modificarProyecto(Proyecto pro, int idProyecto, int idCiclo) {
		
		PreparedStatement sm = null;
				
		try {
			
			con = conexion.conectar();
			System.out.println("Conectado");
					
			sm = con.prepareStatement("update proyectos set nombre = ?,url = ?, nota = ?, año = ?, curso = ?, grupo = ? , ciclo = ?  where id_p = ?");
            sm.setString(1, pro.getNombre());
            sm.setString(2, pro.getUrl());
            sm.setDouble(3, pro.getNota());
            sm.setInt(4, pro.getAño());
            sm.setInt(5, pro.getCurso());
            sm.setString(6, pro.getGrupo());
            sm.setInt(7, idCiclo);
            sm.setInt(8, idProyecto);
            sm.execute();
            JOptionPane.showConfirmDialog(null, "Proyecto modificado correctamente", "Mensaje de confirmación", JOptionPane.CLOSED_OPTION);
	        } catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	        }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	        }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	        }finally {
	        	
	        	try {
	        		if(sm != null) {
	        			sm.close();
	        		}
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println("No se pudo cerrar");
	    		}		        	
	        }		
				
					
	}
	
	public void vincularAlumno(Alumno al, int idProyecto) {
		
		PreparedStatement ps = null;
		
		try {
			con = conexion.conectar();
			ps = con.prepareStatement("insert into se_realizan (proyecto, alumno) values(?,?)");
			ps.setInt(1, idProyecto);
			ps.setInt(2, new AlumnoPersistencia().obtenerID(al));
			ps.executeUpdate();
			
		}catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	    }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	    }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	     }finally {	        	
	        	try {
	        		if(ps != null) {
	        			ps.close();
	        		}	        		
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println(e.getMessage());
	    		}		        	
	        }		
	}
	
	public void desvincularAlumno(Alumno al, int idProyecto) {
		
		PreparedStatement ps = null;
		
		try {
			con = conexion.conectar();
			ps = con.prepareStatement("delete from se_realizan where proyecto = ? and alumno = ?");
			ps.setInt(1, idProyecto);
			ps.setInt(2, new AlumnoPersistencia().obtenerID(al));
			ps.executeUpdate();
			
		}catch (SQLException ex) {
	           JOptionPane.showMessageDialog(null, "Error");
	    }catch(ClassNotFoundException er) {
	        	er.printStackTrace();
	    }catch(Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error 2", "Error", JOptionPane.CANCEL_OPTION);
	     }finally {	        	
	        	try {
	        		if(ps != null) {
	        			ps.close();
	        		}	        		
	        		if (con != null) {
	        			conexion.desconectar(con);
	        		}	    	
	    		}catch(SQLException e) {
	    			 System.out.println(e.getMessage());
	    		}		        	
	        }		
	}
	
	
}
