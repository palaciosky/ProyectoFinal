<%-- 
    Document   : crearUsuarios
    Created on : 07-02-2020, 08:18:47 AM
    Author     : Palacios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<jsp:useBean id="usuario" scope="session" class="Model.Usuario" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
        <body class="d-flex flex-column" style="background: rgba(246,255,229,1);
background: -moz-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -webkit-gradient(left top, right top, color-stop(0%, rgba(246,255,229,1)), color-stop(28%, rgba(255,255,255,1)), color-stop(55%, rgba(253,255,222,1)), color-stop(65%, rgba(252,252,199,1)), color-stop(91%, rgba(253,255,222,1)), color-stop(100%, rgba(255,255,242,1)));
background: -webkit-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -o-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: -ms-linear-gradient(left, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
background: linear-gradient(to right, rgba(246,255,229,1) 0%, rgba(255,255,255,1) 28%, rgba(253,255,222,1) 55%, rgba(252,252,199,1) 65%, rgba(253,255,222,1) 91%, rgba(255,255,242,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#f6ffe5', endColorstr='#fffff2', GradientType=1 );" >
         <%@include file="../WEB-INF/vistas-parciales/css-js.jspf" %>
         <div class="container shadow p-3 mb-5 bg-white rounded" >
             <h1 class="text-Center text-dark">SISTEMA INVENTARIO WEB</h1>
             <h3>Formulario de Registro</h3>
        <form action="<%= request.getContextPath() %>/NUser" method="post">
           
           
            <div class="form-group">
                <label for="txtNomUs" class="col-sm-2 control label"   >Nombres:</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtNomUs"  required placeholder="Nombres Completos" />
                </div>        
            </div>
            
            <div class="form-group">
                <label for="txtApeUs" class="col-sm-2 control label" >Apellidos</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtApeUs" placeholder="Apellidos Completos" required />
                </div>        
            </div>
                
            <div class="form-group">
                <label for="txtCorUs" class="col-sm-2 control label" >E mail</label>
                <div class="col-sm-10" >
                    <input type="email" class="form-control" name="txtCorUs"  required placeholder="Example@host.com"  />
                </div>        
            </div>                
              
            <div class="form-group">
                <label for="txtusrUs" class="col-sm-2 control label" >Usuario</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtusrUs"  required placeholder="Ingrese su usuario" />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txtclUs" class="col-sm-2 control label" >Clave</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtclUs"  required placeholder="Ingrese su clave" />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txttpUs" class="col-sm-2 control label" >Tipo</label>
                <div class="col-sm-10" >
                    <select class="form-control" name="txttpUs">
                    <option value="1" >Administrador</option>
                    <option value="2" >Estandar</option>
                </select>    
                </div>
            </div> 
                
            <div class="form-group">
                <label for="txtesUs" class="col-sm-2 control label" >Estado</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtesUs"  required />
                </div>        
            </div> 
                <br>
                <br>
            <div class="form-group">
                <label for="txtprUs" class="col-sm-2 control label" >Pregunta</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtprUs"  placeholder="No olvidar su pregunta" required />
                </div>        
            </div> 
                
            <div class="form-group">
                <label for="txtreUs" class="col-sm-2 control label" >Repuesta</label>
                <div class="col-sm-10" >
                    <input type="text" class="form-control" name="txtreUs"  placeholder="No olvidar su repuesta" required />
                </div>        
            </div>
            <div>
                <div class="col-sm-offset-2 col-sm-10">
                   
                    <input type="submit" class="btn btn-sucess btn-lg" name="btnGuardar" value="Guardar"/>    
                    <a href="Login" class="btn btn-dark btn-lg" >Regresar</a>
                </div>
                
            </div>
        
                
           
            
        </form>
         </div>
                
    </body>
</html>
