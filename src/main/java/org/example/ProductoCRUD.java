package org.example;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase ProductoCRUD en la que realizamos para la clase Producto metodos para:
 * Creacion de productos
 * Lectura de productos
 * Actualización de productos
 * Elimiar productos
 * Utiliza un TreeMap para almacenar los productos, la clave es el id del producto.
 */
public class ProductoCRUD {
    /**
     <li>TreeMap que almacena los productos usando el id como clave</li>
     *
     */
    private TreeMap<Integer, Producto> productos = new TreeMap<>();

    /**
     * Metodo que crea un nuevo producto
     * @param id id unico para cada producto
     * @param nombre nombre del producto
     * @param precio precio del producto
     * @param descripcion breve descripcion del producto
     * @param pais pais de origen del producto
     * @return Devuelve true si lo crea correctamente o false si ya existe un producto con ese id.
     */

    public boolean crearProducto(int id, String nombre, double precio, String descripcion, String pais) {
        if (productos.containsKey(id)) {
            return false; // Ya existe
        }
        productos.put(id, new Producto(id, nombre, precio, descripcion, pais));
        return true;
    }

    /**
     *  Metodo que lee los productos que contiene el TreeMap
     * si hay productos, devuelve una cadena con su representacion
     * si no hay productos, devuelve una cadena con el mensaje: "No hay productos."
     * @return Retorna una cadena con todos los productos y si no hay productos retorna: "No hay productos.""
     */

    public String leerProductos() {
        if (productos.isEmpty()) {
            return "No hay productos.";
        } else {
            StringBuilder resultado = new StringBuilder();
            for (Map.Entry<Integer, Producto> entry : productos.entrySet()) {
                resultado.append(entry.getValue().toString()).append(", ");
            }
            // Eliminar la última coma y espacio
            return resultado.substring(0, resultado.length() - 2);
        }
    }

    /**
     * Metodo que actualiza los campos de un producto con un id concreto.
     * Si el el id del producto existe, se actualizaran los atributos
     * Si el id no existe el metodo devolvera false
     * * @param id id del producto que queremos actualizar
     * @param nuevoNombre nuevo nombre del producto
     * @param nuevoPrecio nuevo precio del producto
     * @param nuevaDescripcion nueva descripcion del producto
     * @param nuevoPais nuevo pais de origen del producto
     * @return Retorna true si la accion se completa correctamente y false en caso del que el id del producto no se encuentre
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
     * Metodo para eliminar productos dado un id
     * Si el id del producto existe, el producto quedara eliminado
     * Si el id no existe, el metodo devolvera false
     * @param id id unico del producto que queremos eliminar
     * @return Retorna true si la accion se completa correctamente y false en  caso de que el id del producto no se encuentre
     */

    public boolean eliminarProducto(int id) {
        return productos.remove(id) != null;
    }

    /**
     * Metodo para obtener un producto dado un id
     * Si el id del producto existe, el metodo devolvera el producto correspondiente
     * Si el id no existe, el metodo devolvera null
     * @param id id unico del producto que queremos obetener
     * @return Retorna el procuto con el id dado, o null si el id del producto no se encuentra
     */

    public Producto obtenerProducto(int id) {
        return productos.get(id);
    }
}
