/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Producto;
import java.util.List;
import Factory.FactoryConexionDB;
import Factory.ConexionDB;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Palacios
 */
public class ProdcutoDAOImplementarn implements ProductoDAO {
   ConexionDB conn;
    @Override
    public List<Producto> Listar() {
           this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT * FROM tb_producto;");
        List<Producto> lista = new ArrayList<Producto>();
        try{
            //Se crea el objeto ResultSet omplemantando el metodo ConsultaSQL 
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            Producto producto = new Producto();//Declara el objeto categoria
            //Asigna a cada campo consultado al atributo de la clase
            producto.setId_producto(resultadoSQL.getInt("id_producto"));
            producto.setNom_producto(resultadoSQL.getString("nom_producto"));
            producto.setStock(resultadoSQL.getInt("stock"));
            producto.setPrecio(resultadoSQL.getFloat("precio"));
            producto.setUnidad_de_medida(resultadoSQL.getString("unidad_de_medida"));
            producto.setEstado_producto(resultadoSQL.getInt("estado_producto"));
            producto.setCategoria_id(resultadoSQL.getInt("categoria"));
            lista.add(producto);//Agrega al arreglo cada registro encontrado
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();//pa cerrar conexion señores
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
         this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        StringBuilder miSQL = new StringBuilder();
        miSQL.append("SELECT id_producto, nom_producto, stock, precio, unidad_de_medida, estado_producto, nom_categoria, categoria FROM tb_producto t1 INNER JOIN tb_categoria t2 ON t1.categoria = t2.id_categoria;");
        List<Producto> lista = new ArrayList<Producto>();
        try{
            //Se crea el objeto ResultSet omplemantando el metodo ConsultaSQL 
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            while(resultadoSQL.next()){
            Producto producto = new Producto();//Declara el objeto categoria
            //Asigna a cada campo consultado al atributo de la clase
            producto.setId_producto(resultadoSQL.getInt("id_producto"));
            producto.setNom_producto(resultadoSQL.getString("nom_producto"));
            producto.setStock(resultadoSQL.getInt("stock"));
            producto.setPrecio(resultadoSQL.getFloat("precio"));
            producto.setUnidad_de_medida(resultadoSQL.getString("unidad_de_medida"));
            producto.setEstado_producto(resultadoSQL.getInt("estado_producto"));
            producto.setNomcat(resultadoSQL.getString("nom_categoria"));
            producto.setCategoria_id(resultadoSQL.getInt("categoria"));
            
            lista.add(producto);//Agrega al arreglo cada registro encontrado
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();//pa cerrar conexion señores
        }
        return lista;
    }

    @Override
    public Producto editarPro(int id_pro_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        Producto producto = new Producto();//Objeto producto para devolver datos
        StringBuilder miSQL = new StringBuilder();//Construye la consulta
        //Agregar la consulta SQL
        miSQL.append("SELECT * FROM tb_producto WHERE id_producto =").append(id_pro_edit);
        miSQL.append(";");
        try{// Realiza la consulta
            ResultSet resultadoSQL = this.conn.consultaSQL(miSQL.toString());
            
            while(resultadoSQL.next()){
            producto.setId_producto(resultadoSQL.getInt("id_producto"));
            producto.setNom_producto(resultadoSQL.getString("nom_producto"));
            producto.setStock(resultadoSQL.getFloat("stock"));
            producto.setPrecio(resultadoSQL.getFloat("precio"));
            producto.setUnidad_de_medida(resultadoSQL.getString("unidad_de_medida"));
            producto.setEstado_producto(resultadoSQL.getInt("estado_producto"));
            producto.setCategoria_id(resultadoSQL.getInt("categoria"));
            }       
        }catch(Exception ex){
              
        }finally{
        this.conn.cerrarConexion();//esto la cierra
        }
        return producto;
    }

   


    @Override
    public boolean borrarPro(int id_pro_edit) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean borrar = false;           //Bandera de resultados
        try{
            StringBuilder miSQL = new StringBuilder();
            miSQL.append("DELETE FROM tb_producto WHERE id_producto = ").append(id_pro_edit);
            this.conn.ejecutarSQL(miSQL.toString());
            borrar = true;
        }catch(Exception e){
            
        }finally{
            this.conn.cerrarConexion();  //Cerrar la conexión.
        }
        return borrar;
    }

    @Override
    public boolean guardaPro(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false; //bandera de resultado
        try{
            if (producto.getId_producto()== 0) {//Para cuando es una nueva categoria
            StringBuilder miSQL = new StringBuilder();    
            //Agregar consulta SQL, el id_categoria es autoincrement
            miSQL.append("INSERT INTO tb_producto(nom_producto, stock, precio, unidad_de_medida, estado_producto, categoria) VALUES ('");
            miSQL.append(producto.getNom_producto()+ "','").append(producto.getStock()+"','").append(producto.getPrecio()+"','").append(producto.getUnidad_de_medida()+"','").append(producto.getEstado_producto()+"','").append(producto.getCategoria_id());
            miSQL.append("')");
            //Invoca al diablo perdon digo el metodo para ejecutar la consulta
            this.conn.ejecutarSQL(miSQL.toString());
            }else if (producto.getId_producto() > 0){//Actualizar, id_categoira mayoress a 0
                                System.out.println("Entramos...");
                StringBuilder miSQL = new StringBuilder();
                miSQL.append("UPDATE tb_producto SET id_producto = ").append(producto.getId_producto());
                miSQL.append(", nom_producto =  '").append(producto.getNom_producto());
                miSQL.append("', stock =  ").append(producto.getStock());
                miSQL.append(", precio =  ").append(producto.getPrecio());
                miSQL.append(", unidad_de_medida =  '").append(producto.getUnidad_de_medida());
                miSQL.append("', estado_producto =  ").append(producto.getEstado_producto());
                miSQL.append(", categoria =  ").append(producto.getCategoria_id());
                miSQL.append(" WHERE id_producto = ").append(producto.getId_producto()).append(";");
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
    
}
