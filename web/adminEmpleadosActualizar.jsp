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

                                <sj:tab id="modificar_empleados" target="tabActualizarEmpleados" label="Actualizar Empleados"/>
                                
                                

                                <div id="tabActualizarEmpleados">                                
                                    <s:form action="actualizarEmpleado"  theme="bootstrap">   
                                        <s:textfield name="rut" label="Rut" value="%{record.rut}"  readonly="true"></s:textfield>
                                        <s:textfield name="nombres" label="Nombre" value="%{record.nombres}" type="text" size="15" maxLength="50" title="Debe ingresar nombres" required="true" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"></s:textfield>
                                        <s:textfield name="apellidos" label="Apellidos" value="%{record.apellidos}" type="text" size="15" maxLength="50" required="true" title="Debe ingresar apellidos" required="true" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'- {2,50}]+"></s:textfield>            
                                        <s:textfield name="direccion" label="Direccion" value="%{record.direccion}" required="true" title="Debe ingresar dirección" type="text"size="20" maxLength="50"></s:textfield>
                                        <sj:datepicker name="fechaNac" label="Fecha de Nacimiento" value="%{record.fechaNac}" displayFormat="dd/mm/yy"></sj:datepicker>
                                         <s:textfield name="telefono" type="tel" required="true" size="10" maxLength="10" pattern="\S{5,10}"label="Teléfono" value="%{record.telefono}"></s:textfield>
                                        <s:textfield name="email" title="Debe ingresar un correo electrónico" size="20" maxLength="50" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" required="true"label="Email" value="%{record.email}" required="true"></s:textfield>
                                         <s:textfield name="cargasFam" label="Cargas Familiares" value="%{record.cargasFam}" required="true"></s:textfield>
                                        <s:textfield name="password" title="Debe ingresar una contraseña (mínimo 5, máximo 10 caracteres)" size="10" maxLength="10" pattern="\S{5,10}" type="password" label="Contraseña" value="%{record.password}" required="true"></s:textfield>
                                       
                                        
                                        
                                        <s:textfield name="IdCiudad" label="Ciudad" value="%{record.ciudad_id.id}"></s:textfield>
                                        <s:textfield name="IdNacionalidad" label="Nacionalidad" value="%{record.nacionalidad_id.id}"></s:textfield>                                      
                                        <s:textfield name="IdEstadoCivil" label="Estado Civil" value="%{record.estado_civil_id.id}"></s:textfield>                                       
                                        <s:textfield name="IdAfp" label="AFP" value="%{record.afp_id.id}"></s:textfield>
                                        <s:textfield name="IdPrevision" label="Prevision" value="%{record.prevision_id.id}"></s:textfield>                                       
                                        <s:textfield name="IdProfesion" label="Profesion" value="%{record.profesion_id.id}"></s:textfield>
                                        <s:textfield name="IdRol" label="Rol" value="%{record.rol_id.id}"></s:textfield>                                        
                                       
                                        <s:submit value="Actualizar"></s:submit>
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
