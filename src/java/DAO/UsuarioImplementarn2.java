/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Usuario;
import java.sql.SQLException;
import Factory.MySQLConexionFactory;
import Factory.FactoryConexionDB;
import Factory.ConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Palacios
 */
public class UsuarioImplementarn2 {
    ConexionDB conn;
    
     public UsuarioImplementarn2() {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        //Definir a la base de datos que se conectará por defecto.
        //this.conn = FactoryConexionBD.open(FactoryConexionBD.MySQL);
    }
    
    public Usuario VerLogin(String email, String password)throws SQLException,ClassNotFoundException{
       String jdbcURL = "jdbc:mysql://localhost:3307/bd_recurso_humano";
		String dbUser = "root";
		String dbPassword = "";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM tb_usuario WHERE correo = ? and clave = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, email);
		statement.setString(2, password);

		ResultSet result = statement.executeQuery();

		Usuario user = null;

		if (result.next()) {
			user = new Usuario();
			//user.setNombrec(result.getString("fullname"));
			user.setCorreo(email);
		}

		connection.close();

		return user;
    
    }
}
