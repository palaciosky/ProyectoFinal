/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.util.ArrayList;
import Factory.ConexionDB;
import Factory.FactoryConexionDB;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Palacios
 */
public class UsuarioDAOImplementarn implements UsuarioDAO {
    
    ConexionDB conn; 

    @Override
    public ArrayList<Usuario> startSesion(String user, String clave) {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
         StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario WHERE correo = '").append(user);
        miSQL.append("' and clave = ('").append(clave);
        miSQL.append("');");  
        
         ArrayList<Usuario> lista = new ArrayList<Usuario>();
        try{
        //Se crea el objeto ResultSet implementando el método (consultaSQL) creado para la consulta.
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
                Usuario usuario = new Usuario();
                //Asignar cada campo consultado al atributo en la clase.
                usuario.setId(resultadoSQL.getInt("id_usuario"));
                usuario.setNombre(resultadoSQL.getString("nombre_u"));
                usuario.setApellido(resultadoSQL.getString("apellido_u"));
                usuario.setCorreo(resultadoSQL.getString("correo"));
                usuario.setUsuario(resultadoSQL.getString("usuario"));
                usuario.setClave(resultadoSQL.getString("clave"));
                usuario.setTipo(resultadoSQL.getInt("tipo"));
                usuario.setEstado(resultadoSQL.getInt("estado"));
                usuario.setPregunta(resultadoSQL.getString("pregunta"));
                usuario.setRespuesta(resultadoSQL.getString("respuesta"));
                usuario.setFecharegistro(resultadoSQL.getString("f_registro"));
                lista.add(usuario); //Agregar al array cada registro encontrado.
                
                
            }
        }catch(Exception ex){
            
        }finally{
            this.conn.cerrarConexion();
        }
    
    return lista;
    }

    @Override
    public List<Usuario> Listar() {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_usuario;");
        List<Usuario> lista = new ArrayList<Usuario>();
        try{
            //Se crea el objeto ResultSet omplemantando el metodo ConsultaSQL 
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            Usuario usuario = new Usuario();//Declara el objeto categoria
            //Asigna a cada campo consultado al atributo de la clase
            usuario.setId(resultadoSQL.getInt("id_usuario"));
            usuario.setNombre(resultadoSQL.getString("nombre_u"));
            usuario.setApellido(resultadoSQL.getString("apellido_u"));
            usuario.setCorreo(resultadoSQL.getString("correo"));
            usuario.setUsuario(resultadoSQL.getString("usuario"));
            usuario.setClave(resultadoSQL.getString("clave"));
            usuario.setTipo(resultadoSQL.getInt("tipo"));
            usuario.setEstado(resultadoSQL.getInt("estado"));
            usuario.setPregunta(resultadoSQL.getString("pregunta"));
            usuario.setRespuesta(resultadoSQL.getString("repuesta"));
            lista.add(usuario);//Agrega al arreglo cada registro encontrado
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();//pa cerrar conexion señores
        }
        return lista;
    }

    @Override
    public List<Usuario> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario editarPro(int id_pro_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardaPro(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean borrarPro(int id_pro_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
