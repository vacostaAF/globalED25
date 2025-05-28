import java.util.Map;
import java.util.TreeMap;

/**
 * Clase que implementa operaciones CRUD sobre productos usando un TreeMap.
 * Esta clase permite crear, leer, actualizar, eliminar y obtener productos.
 *
 * Los productos se almacenan en un TreeMap donde la clave es el ID del producto.
 *
 * @author Tony
 * @version 1.0
 */
public class ProductoCRUD {

    /** Estructura que almacena los productos ordenados por su ID. */
    private TreeMap<Integer, Producto> productos = new TreeMap<>();

    /**
     * Crea un nuevo producto y lo añade al mapa si no existe un producto con el mismo ID.
     *
     * @param id ID único del producto
     * @param nombre Nombre del producto
     * @param precio Precio del producto
     * @param descripcion Descripción del producto
     * @param pais País de origen del producto
     * @return true si el producto fue creado correctamente, false si ya existe un producto con ese ID
     */
    public boolean crearProducto(int id, String nombre, double precio, String descripcion, String pais) {
        if (productos.containsKey(id)) {
            return false; // Ya existe
        }
        productos.put(id, new Producto(id, nombre, precio, descripcion, pais));
        return true;
    }

    /**
     * Devuelve todos los productos almacenados como un String.
     * Si no hay productos, devuelve un mensaje indicándolo.
     *
     * @return Cadena con la lista de productos o un mensaje de vacío
     */
    public String leerProductos() {
        if (productos.isEmpty()) {
            return "No hay productos.";
        } else {
            StringBuilder resultado = new StringBuilder();
            for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
                resultado.append(entry.getValue().toString()).append(", ");
            }
            return resultado.substring(0, resultado.length() - 2);
        }
    }

    /**
     * Actualiza los datos de un producto existente.
     *
     * @param id ID del producto a actualizar
     * @param nuevoNombre Nuevo nombre
     * @param nuevoPrecio Nuevo precio
     * @param nuevaDescripcion Nueva descripción
     * @param nuevoPais Nuevo país de origen
     * @return true si el producto fue actualizado, false si no existía
     */
    public boolean actualizarProducto(int id, String nuevoNombre, double nuevoPrecio,
                                      String nuevaDescripcion, String nuevoPais) {
        Producto p = productos.get(id);
        if (p == null) {
            return false;
        }
        productos.put(id, new Producto(id, nuevoNombre, nuevoPrecio, nuevaDescripcion, nuevoPais));
        return true;
    }

    /**
     * Elimina un producto del mapa por su ID.
     *
     * @param id ID del producto a eliminar
     * @return true si el producto existía y fue eliminado, false si no existía
     */
    public boolean eliminarProducto(int id) {
        return productos.remove(id) != null;
    }

    /**
     * Obtiene un producto por su ID.
     *
     * @param id ID del producto
     * @return El producto correspondiente o null si no existe
     */
    public Producto obtenerProducto(int id) {
        return productos.get(id);
    }
}
