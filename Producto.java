public class Producto {
    int id;
    String nombre;
    double precio;
    String descripcion;
    String pais;

    public Producto(int id, String nombre, double precio, String descripcion, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Producto{id=" + id + ", nombre='" + nombre + "', precio=" + precio +
                ", descripcion='" + descripcion + "', pais='" + pais + "'}";
    }
}