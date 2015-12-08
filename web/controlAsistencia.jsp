<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                <sj:tab id="lista_asistencia" target="tabListaAsistencia" label="Listar Asistencia Empleados"/>
                                <sj:tab id="ingreso_empleados" target="tabIngresoAsistencia" label="Ingresar Asistencia Empleados"/>
                                <div id="tabListaAsistencia">
                                    <h3>
                                        Lista de Asistencia
                                    </h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <th>Rut</th>
                                        <th>Fecha Entrada</th>
                                        <th>Fecha Salida</th>
                                        
                                        <th>Acciones</th>
                                        </thead>
                                        <tbody>
                                            <s:iterator value="records" var="dato" status="estado">
                                                <tr>
                                                    <!-- los nombre de valores de las propiedades deben ser los mismos que en la clase del modelo-->
                                                    <td ><s:property value="rut_empleado.rut" /></td>
                                                    <td><s:property value="fecha_entrada" /></td>                                          
                                                    <td><s:property value="fecha_salida" /></td>
                                                    
                                                    <td>
                                                        <s:url id="url" action="buscarAsistencia">
                                                            <s:param name="codigoAsistencia">
                                                                <s:property value="rut_empleado.rut"></s:property>                                                                    
                                                            </s:param>                                                               
                                                        </s:url>
                                                        <s:a href="%{url}" cssClass="fs1" aria-hidden="true">Actualizar</s:a>

                                                        <s:a action="eliminarEmpleado">
                                                            <s:param name="rut_empleado" value="rut_empleado.rut" />
                                                            <i class="glyphicon glyphicon-trash"></i>
                                                        </s:a>    
                                                    </td>
                                                </tr>
                                            </s:iterator>
                                        </tbody>
                                    </table>
                                </div>
                                
                                <div id="tabIngresoAsistencia">
                                    <s:form action="ingresarAsistencia" theme="bootstrap" label="Ingrese Asistencia Empleados">
                                        <s:textfield
                                            label="Identificador"
                                            name="id"/>
                                        <s:select 
                                            label="Rut Empleado"
                                            list="listaEmpleados"
                                            listValue="rut"
                                            name="IdEmp"
                                            listKey="rut"
                                         />
                                        <sj:datepicker name="fecha_entrada" label="Fecha Entrada"  displayFormat="dd/mm/yy"></sj:datepicker>
                                        <sj:datepicker name="fecha_salida" label="Fecha Salida"  displayFormat="dd/mm/yy"></sj:datepicker>
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
