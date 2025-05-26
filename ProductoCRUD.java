import java.util.Map;
import java.util.TreeMap;

public class ProductoCRUD {
    private TreeMap<Integer, Producto> productos = new TreeMap<>();

    public boolean crearProducto(int id, String nombre, double precio, String descripcion, String pais) {
        if (productos.containsKey(id)) {
            return false; // Ya existe
        }
        productos.put(id, new Producto(id, nombre, precio, descripcion, pais));
        return true;
    }

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

    public boolean actualizarProducto(int id, String nuevoNombre, double nuevoPrecio,
                                      String nuevaDescripcion, String nuevoPais) {
        Producto p = productos.get(id);
        if (p == null) {
            return false;
        }
        productos.put(id, new Producto(id, nuevoNombre, nuevoPrecio, nuevaDescripcion, nuevoPais));
        return true;
    }

    public boolean eliminarProducto(int id) {
        return productos.remove(id) != null;
    }

    public Producto obtenerProducto(int id) {
        return productos.get(id);
    }
}