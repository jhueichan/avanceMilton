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

                                <sj:tab id="lista_empleados" target="tabListaEmpleados" label="Listar Empleados"/>
                                
                                

                                <div id="tabListaEmpleados">
                                    <h3>
                                        Lista de Empleados
                                    </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>Rut</th>
                                        <th>Nombre</th>
                                        <th>Apellido</th>
                                        <th>Direccion</th>
                                        <th>Teléfono</th>
                                        <th>Email</th>
                                        <th>Afp</th>
                                        <th>Previsión</th>
                                        <th>Rol</th>
                                         <th>Actualizar</th>
                                         <th>Eliminar</th>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td ><s:property value="rut" /></td>
                                                    <td><s:property value="nombres" /></td>                                          
                                                    <td><s:property value="apellidos" /></td>
                                                    <td><s:property value="direccion" /></td>
                                                    <td><s:property value="telefono" /></td>
                                                    <td><s:property value="email" /></td>
                                                    <td><s:property value="afp_id.nombre" /></td>
                                                    <td><s:property value="prevision_id.prevision" /></td>
                                                    <td><s:property value="rol_id.nombres" /></td>
                                                    <td>
                                                        <s:url id="url" action="buscarEmpleado">
                                                            <s:param name="codigoEmpleado">
                                                                <s:property value="rut"></s:property>                                                                    
                                                            </s:param>                                                               
                                                        </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true">Actualizar</s:a>

                                                          
                                                    </td>
                                                    <td>
                                                         <s:a action="eliminarEmpleado">
                                                            <s:param name="rut" value="rut" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a> 
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                    
                                    </div>
                                    
                                    

                               

                            </sj:tabbedpanel>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
