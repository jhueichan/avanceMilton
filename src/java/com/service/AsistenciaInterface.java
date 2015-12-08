package com.service;
import com.jdbc.DataAccessObject;
import com.model.Asistencia;
import java.sql.Connection;
import java.util.List;

public interface AsistenciaInterface {
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(String  rut) throws Exception;
    public List <Asistencia> listar() throws Exception;
    public boolean ingresar(Asistencia obj) throws Exception;   
    public boolean actualizar(Asistencia obj) throws Exception;
    public Asistencia buscarPorID(String rut) throws Exception;
}
