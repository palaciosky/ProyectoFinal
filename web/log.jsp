<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="WEB-INF/vistas-parciales/css-js.jspf" %>
     </head>
    <body>
    <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="img/user.png" th:src="img/user.png}"/>
                    
                </div>
                <form class="col-12" action="Login" method="POST">
                    <div class="form-group" id="user-group">
                        <input type="text" name="inputEmail" class="form-control" placeholder="Correo" />
                    </div>
                    <div class="form-group" id="contrasena-group">
                        <input type="password" name="inputPassword" class="form-control" placeholder="Contrasea" />
                    </div>
                    <button type="submit" class="btn btn-primary"><i class="fas fa-sign-in-alt"></i>  Ingresar </button>
                </form>
                <div class="col-12 forgot">
                    <a href="#">Recordar contrasena?</a>
                </div>
                <div th:if="${param.error}" class="alert alert-danger" role="alert">
		            Invalid username and password.
		        </div>
		        <div th:if="${param.logout}" class="alert alert-success" role="alert">
		            You have been logged out.
		        </div>
            </div>
        </div>
    </div>
</body>
</html>
