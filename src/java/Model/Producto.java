/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Palacios
 */
public class Producto {
  private int id_producto;
  private String nom_producto;
  private int categoria_id;
  private float stock;
  private float precio;
  private String unidad_de_medida;
  private int estado_producto;


  private String nomcat;
  private Categoria categoria;

    public Producto() {
        this.id_producto = 0;
        this.categoria = new Categoria(); //inicia el modelo categoria
        
        
    }

    public Producto(int id_producto, String nom_producto, int categoria_id, float stock, float precio, String unidad_de_medida, int estado_producto, String nomcat, Categoria categoria) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.categoria_id = categoria_id;
        this.stock = stock;
        this.precio = precio;
        this.unidad_de_medida = unidad_de_medida;
        this.estado_producto = estado_producto;
        this.categoria = categoria;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUnidad_de_medida() {
        return unidad_de_medida;
    }

    public void setUnidad_de_medida(String unidadMedida) {
        this.unidad_de_medida = unidadMedida;
    }

    public int getEstado_producto() {
        return estado_producto;
    }

    public void setEstado_producto(int estado) {
        this.estado_producto = estado;
    }
    
        public String getNomcat() {
        return nomcat;
    }

    public void setNomcat(String nomcat) {
        this.nomcat = nomcat;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
