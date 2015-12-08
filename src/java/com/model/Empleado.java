package com.model;
import java.sql.Date;

public class Empleado {
     private String rut;
     private String nombres;
     private String apellidos;
     private String direccion;
     private String fechaNac;
     private String cargasFam;
     private String telefono;
     private String email;
     private String password;     
     // claves foraneas  
     private Afp afp_id;
     private Ciudad ciudad_id;
     private EstadoCivil estado_civil_id;
     private Nacionalidad nacionalidad_id;
     private Prevision prevision_id;
     private Profesion profesion_id;
     private Rol rol_id;

    public Empleado() {
    }

    

    public Afp getAfp_id() {
        return afp_id;
    }

    public void setAfp_id(Afp afp_id) {
        this.afp_id = afp_id;
    }

    public Ciudad getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(Ciudad ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public EstadoCivil getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(EstadoCivil estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public Nacionalidad getNacionalidad_id() {
        return nacionalidad_id;
    }

    public void setNacionalidad_id(Nacionalidad nacionalidad_id) {
        this.nacionalidad_id = nacionalidad_id;
    }

    public Prevision getPrevision_id() {
        return prevision_id;
    }

    public void setPrevision_id(Prevision prevision_id) {
        this.prevision_id = prevision_id;
    }

    public Profesion getProfesion_id() {
        return profesion_id;
    }

    public void setProfesion_id(Profesion profesion_id) {
        this.profesion_id = profesion_id;
    }

    public Rol getRol_id() {
        return rol_id;
    }

    public void setRol_id(Rol rol_id) {
        this.rol_id = rol_id;
    }
     
     
     
     
     
  

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCargasFam() {
        return cargasFam;
    }

    public void setCargasFam(String cargasFam) {
        this.cargasFam = cargasFam;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
}
