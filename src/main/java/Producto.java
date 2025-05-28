
/**
 * Clase que representa un producto agrícola en la aplicación AgroNatura.
 * Contiene información básica como ID, nombre, precio, descripción y país de origen.
 *
 * @author TonyRMdev
 * @version 1.0
 */
public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String descripcion;
    private String pais;

    /**
     * Constructor para crear un nuevo producto.
     *
     * @param id Identificador único del producto
     * @param nombre Nombre del producto
     * @param precio Precio en euros
     * @param descripcion Descripción del producto
     * @param pais País de origen del producto
     */
    public Producto(int id, String nombre, double precio, String descripcion, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    /** @return id del producto */
    public int getId() {
        return id;
    }

    /** @return Nombre del producto */
    public String getNombre() {
        return nombre;
    }

    /** @return Precio del producto */
    public double getPrecio() {
        return precio;
    }

    /** @return Descripción del producto */
    public String getDescripcion() {
        return descripcion;
    }

    /** @return País de origen del producto */
    public String getPais() {
        return pais;
    }

    /**
     * Establece un nuevo ID para el producto.
     * @param id Nuevo ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /** @param nombre Nuevo nombre del producto */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @param precio Nuevo precio del producto */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /** @param descripcion Nueva descripción del producto */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @param pais Nuevo país de origen del producto */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Representación en texto del producto, útil para mostrar en consola o logs.
     * @return Cadena que describe el producto
     */
    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
                ", descripcion='" + descripcion + "', pais='" + pais + "'}";
    }
}
