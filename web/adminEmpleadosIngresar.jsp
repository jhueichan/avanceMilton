<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Administración de Empleados</title>
        <%@include file="header.txt"%>
        <%@include file="footer.txt" %>
        <sj:head jqueryui="true" jquerytheme="start"/>

    </head>
    <body>
        <div id="wrapper">
            <%@include file="menu.jspf" %>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">

                            <sj:tabbedpanel id="tabs" cssClass="listas">

                                
                                <sj:tab id="ingreso_empleados" target="tabIngresoEmpleados" label="Ingresar Empleados"/>
                               

                                
                                    
                                    <div id="tabIngresoEmpleados">
                                    <s:form action="ingresarEmpleado" theme="bootstrap" label="Ingrese Empleados">
                                        <s:textfield
                                            title="Debe ingresar un rut válido"
                                            type="text"
                                            size="9"
                                            pattern="\d{3,8}[\d|kK]{1}"
                                            maxLength="9"
                                            label="Rut"
                                            name="rut" required="true"
                                            />
                                        <s:textfield
                                            title="Debe ingresar nombres"
                                            type="text"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"
                                            size="15"
                                            maxLength="50"
                                            label="Nombre"
                                            name="nombres" required="true"/>
                                        <s:textfield
                                            title="Debe ingresar apellidos"
                                            type="text"
                                            pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]"
                                            size="15"
                                            maxLength="50"
                                            label="Apellidos"
                                            name="apellidos" required="true"/>
                                        <s:textfield
                                            title="Debe ingresar dirección"
                                            type="text"
                                            size="20"
                                            
                                            maxLength="50"
                                            label="Dirección"
                                            name="direccion" required="true"/>
                                        <s:select 
                                            label="Ciudad"
                                            list="listaCiudades"
                                            listValue="nombre"
                                            name="IdCiudad"
                                            listKey="id"
                                            
                                         /> 
                                        <s:select
                                            label="Nacionalidad"
                                            list="listaNacionalidad"
                                            listValue="pais"
                                            name="IdNacionalidad"
                                            listKey="id"
                                            
                                         />  
                                         <sj:datepicker name="fechaNac" label="Fecha Nacimiento"  displayFormat="dd/mm/yy" ></sj:datepicker>
                                        <s:select
                                            label="Estado Civíl"
                                            list="listaEstadoCivil"
                                            listValue="nombre"
                                            name="IdEstadoCivil"
                                            listKey="id"
                                            
                                         /> 
                                        <sj:spinner name="cargasFam" label="Cargas Familiares"   value="0" readonly="false" max="20" min="0" tooltip="Ingresar una cantidad" />                                      
                                        <s:select
                                            label="Afp"
                                            list="listaAfp"
                                            listValue="nombre"
                                            name="IdAfp"
                                            listKey="id"
                                            
                                         /> 
                                        <s:select
                                            label="Previsión"
                                            list="listaPrevision"
                                            listValue="prevision"
                                            name="IdPrevision"
                                            listKey="id"
                                           
                                            />
                                        <s:textfield
                                            label="Teléfono"
                                            title="Debe ingresar un teléfono"
                                            
                                            type="tel"
                                            size="10"
                                            maxLength="10"
                                            pattern="[0-9]\S{5,10}" 
                                            name="telefono"
                                             required="true"/>
                                        <s:textfield
                                            label="Email"
                                            name="email"
                                            title="Debe ingresar un correo electrónico"
                                            type="email"
                                            size="20"
                                            maxLength="50"
                                            pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$"
                                             required="true"/>
                                        <s:select
                                            label="Profesión"
                                            list="listaProfesion"
                                            listValue="profesion"
                                            name="IdProfesion"
                                            listKey="id"
                                            
                                            />
                                       <s:select
                                            label="Rol"
                                            list="listaRoles"
                                            listValue="nombres"
                                            name="IdRol"
                                            listKey="id"
                                            />
                                        <s:textfield
                                             title="Debe ingresar una contraseña (mínimo 5, máximo 10 caracteres)"
                                            label="Password"
                                            size="10"
                                            maxLength="10"
                                            pattern="\S{5,10}"
                                            type="password"
                                            name="password"
                                             required="true"/>
                                        <br>
                                        <s:submit value="Grabar datos" cssClass="btn btn-primary"/>
                                    </s:form>

                                </div>

                                
                            </sj:tabbedpanel>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
