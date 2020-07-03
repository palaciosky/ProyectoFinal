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
            usuario.setFecharegistro(resultadoSQL.getString("f_registro"));
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
    public Usuario editarUs(int id_us_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Usuario usuario = new Usuario();//Objeto categoria para devolver datos
        StringBuilder miSQL = new StringBuilder();//Construye la consulta
        //Agregar la consulta SQL
        miSQL.append("SELECT * FROM tb_usuario WHERE id_usuario ='").append(id_us_edit);
        miSQL.append("';");
        try{// Realiza la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
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
            
            }       
        }catch(Exception ex){
              
        }finally{
        this.conn.cerrarConexion();//esto la cierra
        }
        return usuario;
    }

    @Override
    public boolean guardaUs(Usuario usuario) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false; //bandera de resultado
        try{
            if (usuario.getId()== 0) {//Para cuando es una nueva categoria
            StringBuilder miSQL = new StringBuilder();    
            //Agregar consulta SQL, el id_categoria es autoincrement
            miSQL.append("INSERT INTO tb_usuario(nombre_u, apellido_u, correo, usuario, clave, tipo, estado, pregunta, repuesta) VALUES ('");
            miSQL.append(usuario.getNombre()+"','").append(usuario.getApellido()+"','").append(usuario.getCorreo()+"','").append(usuario.getUsuario()+"','").append(usuario.getClave()+"','").append(usuario.getTipo()+"','").append(usuario.getEstado()+"','").append(usuario.getPregunta()+"','").append(usuario.getRespuesta());
            miSQL.append("')");
            //Invoca al diablo perdon digo el metodo para ejecutar la consulta
            this.conn.ejecutarSQL(miSQL.toString());
            }else if (usuario.getId()> 0){//Actualizar, id_categoira mayoress a 0
                                 System.out.println("Entramos...");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_usuario SET id_usuario = ").append(usuario.getId());
                miSQL.append(", nombre_u =  '").append(usuario.getNombre());
                miSQL.append("', apellido_u =  '").append(usuario.getApellido());
                miSQL.append("', correo =  '").append(usuario.getCorreo());
                miSQL.append("', usuario =  '").append(usuario.getUsuario());
                miSQL.append("', clave =  '").append(usuario.getClave());
                miSQL.append("', tipo =  ").append(usuario.getTipo());
                miSQL.append(", estado =  ").append(usuario.getEstado());
                miSQL.append(", pregunta =  '").append(usuario.getPregunta());
                miSQL.append("', repuesta =  '").append(usuario.getRespuesta()+"'");
                miSQL.append(" WHERE id_usuario = ").append(usuario.getId()).append(";");
                //Invocar método para ejecutar la consulta.
                this.conn.ejecutarSQL(miSQL.toString());
                System.out.println("Registro modificado correctamente!");
            }
        }catch(Exception e){
            System.out.println("Error en la matriz de consulta");
        }finally{
        this.conn.cerrarConexion();
        }
        return guarda;
    }

    @Override
    public boolean borrarUs(int id_us_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borrar = false;           //Bandera de resultados
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_usuario WHERE id_usuario = ").append(id_us_edit);
            this.conn.ejecutarSQL(miSQL.toString());
            borrar = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();  //Cerrar la conexión.
        }
        return borrar;
    }
    
    
    
}
