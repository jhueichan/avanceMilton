package com.dao;

import com.model.Afp;
import com.model.Ciudad;
import com.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.EstadoCivil;
import com.model.FormaPago;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Rol;
import com.service.ClienteInterface;
import static com.service.EmpleadoInterface.dbConnection;

import java.sql.CallableStatement;



public class DaoCliente implements ClienteInterface {
    DaoCiudad daoCiudad = new DaoCiudad();
    DaoFormaPago daoFormaPago = new DaoFormaPago();  
    PreparedStatement pStmt; 
    CallableStatement csts;
    
    public DaoCliente() {        
    }
    
 public Cliente ValidarCliente(String User, String Clave) throws Exception {

        CallableStatement Cstm = null;
        ResultSet Rst = null;
        Cliente cliente = new Cliente();
        Rol r = new Rol();
        try{         
            String Comando = "call pa_ValidarCliente(?,?)";
            Cstm = dbConnection.prepareCall(Comando);
            Cstm.setString(1, User);
            Cstm.setString(2, Clave);
            Rst = Cstm.executeQuery();
            while(Rst.next()){
                             
            }
            System.out.println("exito login en ----> ValidarCliente ");
        }catch(Exception e){
            System.out.println("error login en ----> ValidarCliente");
        }
        return cliente;
    }

    @Override
    public boolean eliminar(String rut) throws Exception {
        String deleteQuery = "DELETE FROM CLIENTE WHERE RUT = ?";
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
    public List <Cliente> listar() throws Exception {
     List<Cliente> clientes = new ArrayList<Cliente>();
   	String query = "SELECT * FROM CLIENTE ORDER BY RUT";
	try {              
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
                while (rs.next()) {
	        Cliente cliente = new Cliente();    
                
                cliente.setRut(rs.getString(1));           
                cliente.setRazonSocial(rs.getString(2));                
                cliente.setDireccion(rs.getString(3)); 
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(4));
                cliente.setCiudad(ciudad); 
                cliente.setContacto(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setEmail(rs.getString(7));
                cliente.setWebsite(rs.getString(8));
                cliente.setActivo(rs.getString(9));
                
                
               
                
                FormaPago forma=daoFormaPago.buscarPorID(rs.getInt(10));
                cliente.setFormaPago(forma);
        

                
                
                
                clientes.add(cliente);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return clientes;        
    }

    @Override
    public boolean ingresar(Cliente cliente) throws Exception {
     Cliente emp = new Cliente();
        
        
         //String insertQuery =    "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            csts = dbConnection.prepareCall("{call insertar_cliente(?,?,?,?,?,?,?,?,?,?)}");
            //pStmt = dbConnection.prepareStatement(insertQuery);
            csts.setString(1, cliente.getRut());
            csts.setString(2, cliente.getRazonSocial());
            csts.setString(3, cliente.getDireccion());
            csts.setInt(4,cliente.getCiudad().getId()); 
            csts.setString(5, cliente.getContacto());          
            csts.setString(6, cliente.getTelefono());
            csts.setString(7, cliente.getEmail());
            csts.setString(8, cliente.getWebsite());
            csts.setString(9, cliente.getActivo());
            csts.setInt(10, cliente.getFormaPago().getId());
            
            csts.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Cliente cliente) throws Exception {
         System.out.println("muestra algo para probar");
//         String updateQuery = "UPDATE CLIENTE SET                     "
//                                                 + "RAZON_SOCIAL = ?,"
//                                                 + "DIRECCION = ?,"
//                                                 + "CIUDAD_ID = ?,"
//                                                 + "CONTACTO = ?,"
//                                                 + "TELEFONO = ?,"
//                                                 + "EMAIL = ?,"
//                                                 + "WEBSITE = ?,"
//                                                 + "ACTIVO = ?,"
//                                                 + "FORMA_PAGO_ID = ?"                                                
//                                                 +"  WHERE RUT = ?";
        try {
            csts = dbConnection.prepareCall("{call actualizar_cliente(?,?,?,?,?,?,?,?,?,?)}");     
            
            
            
            csts.setString(1, cliente.getRazonSocial());
            csts.setString(2, cliente.getDireccion());
            csts.setInt(3,cliente.getCiudad().getId()); 
            csts.setString(4, cliente.getContacto());          
            csts.setString(5, cliente.getTelefono());
            csts.setString(6, cliente.getEmail());
            csts.setString(7, cliente.getWebsite());
            csts.setString(8, cliente.getActivo());
            csts.setString(9, cliente.getFormaPago().getFormaPago());
            csts.setString(10, cliente.getRut());
            
            
            
            csts.executeUpdate();
            
          return true;
        } catch (SQLException e) {
            
            System.err.println(e.getMessage());
            
            return false;
            
        }
    }

    @Override
    public Cliente buscarPorID(String rut) throws Exception {
     Cliente cliente =new Cliente();
     String query = "SELECT * FROM CLIENTE WHERE RUT = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,rut);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                    
                cliente.setRut(rs.getString(1));           
                cliente.setRazonSocial(rs.getString(2));                
                cliente.setDireccion(rs.getString(3)); 
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(4));
                cliente.setCiudad(ciudad); 
                cliente.setContacto(rs.getString(5));
                cliente.setTelefono(rs.getString(6));
                cliente.setEmail(rs.getString(7));
                cliente.setWebsite(rs.getString(8));
                cliente.setActivo(rs.getString(9));
                FormaPago forma=daoFormaPago.buscarPorID(rs.getInt(10));
                cliente.setFormaPago(forma);
               	 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  cliente;   
    
    }

 
    
    
}
