import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoCRUDTest {

    private ProductoCRUD crud;

    /**
     * Después del decorador Before escribimos el metodo setUp para antes de cada prueba
     * crear un nuevo objeto
     */
    @Before
    public void setUp() {
        crud = new ProductoCRUD();
    }

    /**
     * Metodo para mostrar que  se puede crear un producto
     * Ademas vamos a mostrarlo, por eso después ponemos un assertEquals
     * por cada campo que queramos comparar. En los decimales ponemos el parámetro @param delta
     * que indica el margen de error en los decimales
     */

    @Test
    public void testCrearProducto_NuevoProducto() {
        boolean creado = crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        assertTrue(creado);
        Producto p = crud.obtenerProducto(1);
        assertNotNull(p);
        assertEquals("Camiseta", p.nombre);
        assertEquals(20.0, p.precio, 0.0001);
        assertEquals("Camiseta azul", p.descripcion);
        assertEquals("España", p.pais);
        assertEquals(1, p.id);
    }

    /**
     * Test para la creación de productos existentes. Similar al anterior pero nos
     * devolverá un assertFalse debido a que no se ha podido crear el producto
     */
    @Test
    public void testCrearProducto_ProductoExistente() {
        crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        boolean creado = crud.crearProducto(1, "Pantalón", 30.0, "Pantalón rojo", "España");
        assertFalse(creado);
    }

    /**
     * Test para cuando no hay productos. Es importante que el string del @return sea el
     * mismo que pusimos en el metodo leer
     */
    @Test
    public void testLeerProductos_Vacio() {
        assertEquals("No hay productos.", crud.leerProductos());
    }

    /**
     * Metodo para leer. Creamos varios productos y despues su resultado lo guardamos en
     * una variable string. Después con el assertTrue comprobamos que esas palabras
     * están en ese string
     */
    @Test
    public void testLeerProductos_NoVacio() {
        crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        crud.crearProducto(2, "Pantalón", 30.0, "Pantalón rojo", "Italia");
        String result = crud.leerProductos();
        // Revisamos si contiene la info de ambos productos
        assertTrue(result.contains("Camiseta"));
        assertTrue(result.contains("Pantalón"));
        assertTrue(result.contains("España"));
        assertTrue(result.contains("Italia"));
    }

    /**
     * Similar al de creacion. Creamos un producto y luego lo actualizamos, asegurándonos
     * con un assertTrue. Ademas cogemos ese producto y mediante assertEquals nos
     * aseguramos parámetro por parámetro
     */
    @Test
    public void testActualizarProducto_Existente() {
        crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        boolean actualizado = crud.actualizarProducto(1, "Camiseta nueva", 25.0, "Camiseta verde", "Francia");
        assertTrue(actualizado);
        Producto p = crud.obtenerProducto(1);
        assertEquals("Camiseta nueva", p.nombre);
        assertEquals(25.0, p.precio, 0.0001);
        assertEquals("Camiseta verde", p.descripcion);
        assertEquals("Francia", p.pais);
    }

    /**
     * Actualizamos el producto, pero como no existe nos tiene que salir assertFalse su
     * actualizacion
     */
    @Test
    public void testActualizarProducto_NoExistente() {
        boolean actualizado = crud.actualizarProducto(10, "Nombre", 10.0, "Desc", "Pais");
        assertFalse(actualizado);
    }

    /**
     * Similar al resto. Creamos producto y lo eliminamos asegurándonos con un asserTrue de
     * eliminacion y un assert Null a la hora de intentar obtener ese producto
     */
    @Test
    public void testEliminarProducto_Existente() {
        crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        boolean eliminado = crud.eliminarProducto(1);
        assertTrue(eliminado);
        assertNull(crud.obtenerProducto(1));
    }

    /**
     * Nos sale assertFalse porque no se puede eliminar un producto que no existe
     */
    @Test
    public void testEliminarProducto_NoExistente() {
        boolean eliminado = crud.eliminarProducto(99);
        assertFalse(eliminado);
    }

    /**
     * Usamos assertNotNull que emularía el assertTrue. Ademas añadimos tambien un
     * assertEquals para asegurarnos
     */
    @Test
    public void testObtenerProducto() {
        crud.crearProducto(1, "Camiseta", 20.0, "Camiseta azul", "España");
        Producto p = crud.obtenerProducto(1);
        assertNotNull(p);
        assertEquals("Camiseta", p.nombre);
    }

    /**
     * assertNull porque no existe ese objeto
     */
    @Test
    public void testObtenerProducto_NoExistente() {
        Producto p = crud.obtenerProducto(123);
        assertNull(p);
    }
}
