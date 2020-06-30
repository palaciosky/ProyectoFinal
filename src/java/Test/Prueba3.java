/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImplementarn;
import Model.Usuario;
import java.util.List;

/**
 *
 * @author Palacios
 */
public class Prueba3 {
    public static void main(String[] args) {
        System.out.println("PRUEBA USUARIOS");
         Prueba3 evaluar = new Prueba3();
          evaluar.listarUsuarios();
    }

    private void listarUsuarios() {
        UsuarioDAO usuario = new UsuarioDAOImplementarn(); //To change body of generated methods, choose Tools | Templates.
       List<Usuario> listar = usuario.Listar();
        System.out.println("LISTADO DE USUARIOS");
        for ( Usuario usuarioListar : listar) {
            System.out.println("ID: "+usuarioListar.getId()
            + " NOMBRE: "+ usuarioListar.getNombre()
            + " APELLIDO: "+usuarioListar.getApellido()
            +" CORREO: "+usuarioListar.getCorreo()
            +" USER: "+usuarioListar.getUsuario());
        }
    }
}
