package com.model;
import java.sql.Date;

public class Asistencia {
    private int id;
    private Empleado rut_empleado;
    private String fecha_entrada, fecha_salida;

    public Asistencia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getRut_empleado() {
        return rut_empleado;
    }

    public void setRut_empleado(Empleado rut_empleado) {
        this.rut_empleado = rut_empleado;
    }

    public String getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(String fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    
    
}
