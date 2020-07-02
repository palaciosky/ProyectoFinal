<%-- 
    Document   : 17
    Created on : 06-19-2020, 04:56:17 PM
    Author     : Palacios
--%>

<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!--El id debe ser el mismo que le coloco de nombre a la sesion en el controlador  -->
<jsp:useBean id = "listass" scope="session" class = "java.util.List"  />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios list</title>
        <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
    </head>
    <body  >
        <%@include file="../WEB-INF/vistas-parciales/encabezado.jspf" %>
        <div  >
            <a href="<%= request.getContextPath() %>/Usuarios?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"  >Agregar Usuario +</a>
            <a onclick="javascript:window.imprimirDIV('ID_DIV');" href="#"  class="btn btn-success btn-sm " role="button" ><span class="glyphicon glyphicon-print"> PDF</span> </a>
             <a href="pdfu" class="btn btn-danger btn-sm glyphicon glyphicon-print" role="button"  > Imprimir Reg+</a>
            <h3>Listado de Usuarios Registradas</h3>
             <script>
                function imprimirDIV(ID_DIV) {
                var ficha = document.getElementById(ID_DIV);
                 var ventanaImpresion = window.open(' ', 'popUp');
                ventanaImpresion.document.write(ficha.innerHTML);
                ventanaImpresion.document.close();
                ventanaImpresion.print();
                ventanaImpresion.close();
                 }
      </script>
        <div id="ID_DIV" class="table-responsive" >
            <table class="table table-striped"  >
                      
                
                    <tr>
                        <th> CODIGO </th>
                        <th> NOMBRES </th>
                        <th> APELLIDOS </th>
                        <th> CORREO </th>
                        <th> USER </th>
                        <th> PASSWORD </th>
                        <th> PREGUNTA </th>
                        <th> REPUESTA </th>
                        <th> FECHA R </th>
                        <th></th>
                    </tr>
                    <% 
                        for (int i =0 ; i < listass.size(); i++){
                        Usuario usuario = new Usuario();
                        usuario = (Usuario)listass.get(i);//Categoria es para el casting
                        
                        
                        %>
                    <tr>
                        
                        <td> <%= usuario.getId()%> </td>
                       <td> <%= usuario.getNombre()%> </td>
                       <td> <%= usuario.getApellido()%> </td>
                       <td><%= usuario.getCorreo()%></td>
                       <td><%= usuario.getUsuario()%></td>
                       <td><%= usuario.getClave()%></td>
                       <td><%= usuario.getPregunta()%></td>
                       <td><%= usuario.getRespuesta()%></td>
                       <td><%= usuario.getFecharegistro()%></td>
                       
                       <td>
                           <a href="<%= request.getContextPath() %>/Usuarios?opcion=modificar&&id_us=<%= usuario.getId()%>&&nombre_us=<%= usuario.getNombre()%>&&apellido_us=<%= usuario.getApellido()%>&&correo_us=<%= usuario.getCorreo()%>&&usuario_us=<%= usuario.getUsuario()%>&&clave_us=<%= usuario.getClave()%>&&tipo_us=<%= usuario.getTipo()%>&&estado_us=<%= usuario.getEstado()%>&&preg_us=<%= usuario.getPregunta()%>&&resp_us=<%= usuario.getRespuesta()%>" class="btn btn-info btn-sm glyphicon glyphicon-pencil" role="button" ></a> 
                           <%--  PENDIENTE  --%>
                           <a href="<%= request.getContextPath() %>/Usuarios?opcion=eliminar&&id=<%= usuario.getId()%>" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button" ></a> 
                           <%--  PENDIENTE --%>
                       </td>
                    </tr>
                    <%
                       }
                    %>

                </table>
        </div>

        </div>
      <%@include file="../WEB-INF/vistas-parciales/pie.jspf" %>               
    </body>
</html>
