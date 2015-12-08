package com.dao;
import com.jdbc.DataAccessObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.service.AsistenciaInterface;
import com.model.Empleado;
import com.model.Asistencia;

public class DaoAsistencia implements AsistenciaInterface{
    DaoEmpleado daoEmpleado = new DaoEmpleado();
    PreparedStatement pStmt; 
    CallableStatement csts;

    public DaoAsistencia() {
    }

    
    
    @Override
    public boolean eliminar(String rut) throws Exception {
        String deleteQuery = "DELETE FROM ASISTENCIA WHERE RUT_EMPLEADO = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setString(1, rut);
            pStmt.executeUpdate();
            return  true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List<Asistencia> listar() throws Exception {
        
     List<Asistencia> asistencias = new ArrayList<Asistencia>();
   	String query = "SELECT * FROM ASISTENCIA ORDER BY RUT_EMPLEADO";
        try {              
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
                while (rs.next()) {
	        Asistencia asistencia = new Asistencia();
               
                asistencia.setId(rs.getInt(1));
                Empleado empleado=daoEmpleado.buscarPorID(rs.getString(2));
                asistencia.setRut_empleado(empleado);
                
                asistencia.setFecha_entrada(rs.getString(3));
                asistencia.setFecha_salida(rs.getString(4));
                
                asistencias.add(asistencia);
                
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return asistencias;
    }

    @Override
    public boolean ingresar(Asistencia asistencia) throws Exception {
        
        try {
            csts = dbConnection.prepareCall("{call insertar_asistencia(?,?,?,?)}");
            
            csts.setInt(1, asistencia.getId());
            csts.setString(2, asistencia.getRut_empleado().getRut());
            csts.setString(3, asistencia.getFecha_entrada());
            csts.setString(4, asistencia.getFecha_salida());
            csts.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Asistencia asistencia) throws Exception {
              
            
        try {
            csts = dbConnection.prepareCall("{call actualizar_asistencia(?,?,?,?)}");    
            
            csts.setInt(1, asistencia.getId());
            csts.setString(2, asistencia.getFecha_entrada());
            csts.setString(3, asistencia.getFecha_salida());
            csts.setString(4, asistencia.getRut_empleado().getRut());
            csts.executeUpdate();
            return true;
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }    
    }

    @Override
    public Asistencia buscarPorID(String rut) throws Exception {
        Asistencia asistencia = new Asistencia();
        String query = "SELECT * FROM ASISTENCIA WHERE RUT_EMPLEADO = ?";
         try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,rut);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                asistencia.setId(rs.getInt(1));
                
                Empleado empleado=daoEmpleado.buscarPorID(rs.getString(2));
                asistencia.setRut_empleado(empleado);
                
                SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yy"); 
                asistencia.setFecha_entrada(sm.format(rs.getString(3)));
                SimpleDateFormat sm1 = new SimpleDateFormat("dd/MM/yy"); 
                asistencia.setFecha_salida(sm1.format(rs.getString(4)));
                
           						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  asistencia;   
    }
}
