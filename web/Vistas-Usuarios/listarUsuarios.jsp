<%-- 
    Document   : 17
    Created on : 06-19-2020, 04:56:17 PM
    Author     : Palacios
--%>

<%@page import="Model.Usuario"%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    try {
      //HttpSession sesion = request.getSession(false);
      String name = (String) session.getAttribute("userd");
      
      if(name == null){
            out.print("<center><h2><font color='blue'> ERRORCUATROSIENTOSCUATRO</font><hr><h2></center>");
            response.sendRedirect("./log.jsp");
        }else if(name!=null){
            
%>

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
            <a href="<%= request.getContextPath() %>/Categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon-pencil" role="button"  >Agregar Usuario +</a>
            <a onclick="javascript:window.imprimirDIV('ID_DIV');" href="#"  class="btn btn-success btn-sm " role="button" ><span class="glyphicon glyphicon-print"> PDF</span> </a>
             <a href="pdf" class="btn btn-danger btn-sm glyphicon glyphicon-print" role="button"  > Imprimir Reg+</a>
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
                       
                       <td>
                           <a href="#" class="btn btn-info btn-sm glyphicon glyphicon-pencil" role="button" ></a> 
                           <%-- <%= request.getContextPath() %>/Categorias?opcion=modificar&&id=<%= categoria.getId_categoria() %>&&nombre_cat=<%= categoria.getNom_categoria() %>&&estado_cat=<%= categoria.getEstado_categoria() %> PENDIENTE  --%>
                           <a href="#" class="btn btn-danger btn-sm glyphicon glyphicon-remove" role="button" ></a> 
                           <%-- <%= request.getContextPath() %>/Categorias?opcion=eliminar&&id=<%= categoria.getId_categoria() %> PENDIENTE --%>
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
<%
          }
        }catch(Exception e){
                out.print("<center><h2><font color='blue'> ERRORCUATROSIENTOSCUATRO</font><hr><h2></center>");
            }
   %>