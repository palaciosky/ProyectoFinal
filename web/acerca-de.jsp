<%-- 
    Document   : acerca-de
    Created on : 07-02-2020, 08:30:52 PM
    Author     : Mario CD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<% 
      //HttpSession sesion = request.getSession(false);
      String nombre = (String) session.getAttribute("userd");
      String usuar = (String)session.getAttribute("userd2");
      String names = (String)session.getAttribute("name");
      try{
      if(nombre == null){
            out.print("<center><h2><font color='blue'> Error Cuatrosientoscuatro...</font><hr><h2></center>");
            response.sendRedirect("log.jsp");
        }else if(nombre!=null){
%>
        <!DOCTYPE html>
        <html lang="es">
        <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
          <meta name="viewport" content="width=device-width, initial-scale=1"/>
          <title>Acerca de </title>
        

          
          <!-- CSS  -->
          <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
          <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
          <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        </head>
        
        <body
           style="background: rgba(76,76,76,1);
background: -moz-linear-gradient(top, rgba(76,76,76,1) 0%, rgba(89,89,89,1) 5%, rgba(102,102,102,1) 13%, rgba(0,0,0,1) 61%, rgba(17,17,17,1) 72%, rgba(0,0,0,1) 98%, rgba(28,28,28,1) 98%, rgba(43,43,43,1) 99%, rgba(44,44,44,1) 99%, rgba(19,19,19,1) 100%);
background: -webkit-gradient(left top, left bottom, color-stop(0%, rgba(76,76,76,1)), color-stop(5%, rgba(89,89,89,1)), color-stop(13%, rgba(102,102,102,1)), color-stop(61%, rgba(0,0,0,1)), color-stop(72%, rgba(17,17,17,1)), color-stop(98%, rgba(0,0,0,1)), color-stop(98%, rgba(28,28,28,1)), color-stop(99%, rgba(43,43,43,1)), color-stop(99%, rgba(44,44,44,1)), color-stop(100%, rgba(19,19,19,1)));
background: -webkit-linear-gradient(top, rgba(76,76,76,1) 0%, rgba(89,89,89,1) 5%, rgba(102,102,102,1) 13%, rgba(0,0,0,1) 61%, rgba(17,17,17,1) 72%, rgba(0,0,0,1) 98%, rgba(28,28,28,1) 98%, rgba(43,43,43,1) 99%, rgba(44,44,44,1) 99%, rgba(19,19,19,1) 100%);
background: -o-linear-gradient(top, rgba(76,76,76,1) 0%, rgba(89,89,89,1) 5%, rgba(102,102,102,1) 13%, rgba(0,0,0,1) 61%, rgba(17,17,17,1) 72%, rgba(0,0,0,1) 98%, rgba(28,28,28,1) 98%, rgba(43,43,43,1) 99%, rgba(44,44,44,1) 99%, rgba(19,19,19,1) 100%);
background: -ms-linear-gradient(top, rgba(76,76,76,1) 0%, rgba(89,89,89,1) 5%, rgba(102,102,102,1) 13%, rgba(0,0,0,1) 61%, rgba(17,17,17,1) 72%, rgba(0,0,0,1) 98%, rgba(28,28,28,1) 98%, rgba(43,43,43,1) 99%, rgba(44,44,44,1) 99%, rgba(19,19,19,1) 100%);
background: linear-gradient(to bottom, rgba(76,76,76,1) 0%, rgba(89,89,89,1) 5%, rgba(102,102,102,1) 13%, rgba(0,0,0,1) 61%, rgba(17,17,17,1) 72%, rgba(0,0,0,1) 98%, rgba(28,28,28,1) 98%, rgba(43,43,43,1) 99%, rgba(44,44,44,1) 99%, rgba(19,19,19,1) 100%);
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#4c4c4c', endColorstr='#131313', GradientType=0 );" >
          <%@include file="WEB-INF/vistas-parciales/encabezado2.jspf" %>
          
          <div id="index-banner" class="parallax-container"  >
         
               
                <br> <br>
                <script lenguage="javascript">
                  function salir(){
                      var mensaje;
                      var opcion = confirm("Advertencia!\n\n¿¿Quieres Salir?");
                      if(opcion == true){
                          mensaje = "Acepte";
                          location.href= "Salir";
                      }else{
                          mensaje = "Cancele";
                          //alert(mensaje);
                      }
                      //alert(mensaje);
                      //Muestro en el elemento con id ejemplo el valor de la variable mensaje.
                      //document.getElementById("ejemplo").innerHTML = mensaje;
                  }
              </script>
        <!-- CSS only -->


            <div class="bd-example">
            </div>
            
            
         
          <div class="col s12 m4">
            <div class="icon-block">
             


 <br><br> 
<div class="img-fluid "><img src="img/fondo3.jpg" alt="Unsplashed background img 1" width="100%" height="50%" align="center"></div>
		
              
  <br><center> <h4 style="color:#db6400;"> <font face="Comic Sans Verdana">Acerca de nosotros: </h4>
  
   <h4 style="color:#000000;" ><font face="Comic Sans Verdana">ITCA FEPADE</h4>
   <h4 style="color:#00a8bd;"  ><font face="Comic Sans Verdana">Estudiantes de la carrera Técnico en Ingeniería de Sistemas Informáticos.</h4>
    
    <br><br>

    
<img src="img/Grupo.jfif" width="100%" height="50%" align="center"  >


<br><br>
<br><br>

              
         

          <footer class="page-footer grey darken-4">
            <div class="container table-responsive ">
              <div class="row">
                <div class="col-4 s12">
                  <h5 class="cyan-text">Facilitador:</h5>
                  <hp class="white-text">Manuel de Jesus Gamez Lopez</p>

                  <h5 class="cyan-text">Modulo:</h5>
                  <hp class="white-text">Aplicacion de Metodologias Agiles y Testeo de Software</hp>
               
                  
        
        
                </div>
                <div class="col-4 s12">
                  <h5 class="cyan-text">Correos Electronicos:</h5>
                  <ul>
                      <a class="white-text" href="mailto:g.mauricio@hotmail.es">Palacios</a><br>
                    <a class="white-text" href="mailto:fcarballo2000@gmail.com">Diaz</a><br>
                    <a class="white-text" href="mailto:nticashenriquez@gmail.com">Ticas</a><br>
                    <a class="white-text" href="mailto:Kevincitoo17042000@gmail.com">Kevin</a>
                   
                </div>
                  
                <div class="col-4 s12">
                  <h5 class="cyan-text">Facebook:</h5>
                  <ul>
                    <li><a class="white-text" href="https://www.facebook.com/TheVanpalaciosky1999" target="_blank">Palacios</a></li>
                    <li><a class="white-text" href="https://www.facebook.com/flordemaria.carballodiaz.9/" target="_blank">Flor Diaz</a></li>
                    <li><a class="white-text" href="https://www.https://www.facebook.com/nelsonwilli.ticas" target="_blank">Nelsito Ticas</a></li>
                    <li><a class="white-text" href="https://www.https://www.facebook.com/nelsonwilli.ticas" target="_blank">Kevin Aparicio</a></li>
                    <li><a class="white-text" href="https://www.https://www.facebook.com/Fredcascocastellanos" target="_blank">Alexis Casco</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="footer-copyright">
              <div class="container">
              By<a class="brown-text text-lighten-3" href="http://materializecss.com">Sistemas 21</a>
             
              </div>
            </div>
          </footer>
        
        
          <!--  Scripts-->
          <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
          <script src="js/materialize.js"></script>
          <script src="js/init.js"></script>
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    
    </body>
        </html>
        
<%
                }
      } catch(Exception e){
      
          out.print("<center><h2><font color='blue'> Error Cuatrosientoscuatro...</font><hr><h2></center>");
        }
   %>          