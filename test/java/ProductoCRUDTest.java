import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductoCRUDTest {

    private ProductoCRUD crud;

    @Before
    public void setUp() {
        crud = new ProductoCRUD();
    }

    @Test
    public void testCrearProductoCorrectamente() {
        boolean resultado = crud.crearProducto(1, "Manzana", 1.0, "Fruta", "España");
        assertTrue(resultado);
    }

    @Test
    public void testCrearProductoDuplicado() {
        crud.crearProducto(1, "Manzana", 1.0, "Fruta", "España");
        boolean resultado = crud.crearProducto(1, "Manzana", 1.0, "Fruta", "España");
        assertFalse(resultado);
    }

    @Test
    public void testLeerProductosVacio() {
        String resultado = crud.leerProductos();
        assertEquals("No hay productos.", resultado);
    }

    @Test
    public void testLeerProductosConContenido() {
        crud.crearProducto(1, "Manzana", 1.0, "Fruta", "España");
        String resultado = crud.leerProductos();
        assertTrue(resultado.contains("Manzana"));
    }

    @Test
    public void testActualizarProductoExistente() {
        crud.crearProducto(2, "Pera", 1.2, "Fruta", "España");
        boolean resultado = crud.actualizarProducto(2, "Pera actualizada", 1.5, "Dulce", "Portugal");
        assertTrue(resultado);
        assertTrue(crud.leerProductos().contains("Portugal"));
    }

    @Test
    public void testActualizarProductoInexistente() {
        boolean resultado = crud.actualizarProducto(999, "Nada", 0, "Nada", "Ninguno");
        assertFalse(resultado);
    }

    @Test
    public void testEliminarProductoExistente() {
        crud.crearProducto(3, "Plátano", 0.9, "Fruta", "Canarias");
        boolean resultado = crud.eliminarProducto(3);
        assertTrue(resultado);
    }

    @Test
    public void testEliminarProductoInexistente() {
        boolean resultado = crud.eliminarProducto(404);
        assertFalse(resultado);
    }

    @Test
    public void testObtenerProductoExistente() {
        crud.crearProducto(4, "Melón", 3.0, "Fruta", "España");
        Producto p = crud.obtenerProducto(4);
        assertNotNull(p);
        assertEquals("Melón", p.getNombre());
    }

    @Test
    public void testObtenerProductoInexistente() {
        Producto p = crud.obtenerProducto(123);
        assertNull(p);
    }
}

