package org.example;

/**
 * Clase Producto en con la que crearemos el porfolio de productos de AgroNatura,
 * cada producto tiene un id unico, nombre, precio, descripción y pais de origen.
 */
public class Producto {

    /**
     * Campos de la clase Producto, en el que tenemos:
     * id unico para cada producto
     * nombre del producto,
     * precio del producto,
     * breve descripcion el producto,
     * pais de origen del producto
     */
    int id;
    String nombre;
    double precio;
    String descripcion;
    String pais;

    /**
     * Contructor por parametros de la clase producto que inicializa los campos de la clase.
     * @param id id unico para cada producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion breve descripcion del producto
     * @param pais pais de origen del producto
     */

    public Producto(int id, String nombre, double precio, String descripcion, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    /**
     * metodo toString con el que se muestran los productos con todos sus campos
     * @return cadena que representa el producto con sus campos.
     */
    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
                ", descripcion='" + descripcion + "', pais='" + pais + "'}";
    }
}

