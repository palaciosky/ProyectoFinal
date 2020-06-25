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
            producto.setUnidad_de_medida(resultadoSQL.getString("unidad_de_medida"));
            producto.setEstado_producto(resultadoSQL.getInt("estado_producto"));
            //producto.setCategoria(resultadoSQL.getInt("categoria"));
            lista.add(producto);//Agrega al arreglo cada registro encontrado
            }
        }catch(Exception ex){
        this.conn.cerrarConexion();//pa cerrar conexion señores
        }
        return lista;
    }

    @Override
    public List<Producto> Listar2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producto editarPro(int id_cat_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   


    @Override
    public boolean borrarPro(int id_pro_edit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean guardaPro(Producto producto) {
        this.conn = FactoryConexionDB.open(FactoryConexionDB.MySQL);
        boolean guarda = false; //bandera de resultado
        try{
            if (producto.getId_producto()== 0) {//Para cuando es una nueva categoria
            StringBuilder miSQL = new StringBuilder();    
            //Agregar consulta SQL, el id_categoria es autoincrement
            miSQL.append("INSERT INTO tb_producto(nom_producto, sotck, precio, unidad_de_medida, estado_producto, categoria) VALUES ('");
            miSQL.append(producto.getNom_producto()+ "','").append(producto.getStock()+"','").append(producto.getPrecio()+"','").append(producto.getUnidad_de_medida()+"','").append(producto.getEstado_producto()+"','").append(producto.getCategoria());
            miSQL.append(");");
            //Invoca al diablo perdon digo el metodo para ejecutar la consulta
            this.conn.ejecutarSQL(miSQL.toString());
            }else if (producto.getId_producto() > 0){//Actualizar, id_categoira mayoress a 0
            }
        }catch(Exception e){
        }finally{
        this.conn.cerrarConexion();
        }
        return guarda;
    }
    
}
