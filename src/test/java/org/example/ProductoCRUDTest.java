package org.example;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Clase ProductoCRUDTest que contiene los test de prueba para los metodos de ProductoCRUD (crear, leer, actualizar y borrar) los productos de
 * la clase ProductoCRUD.
 * La clase contiene los test:
 * crearProducto: Verifica que un producto se crea correctamente.
 * crearProductoDuplicado: Verifica que no se crea el producto si el id esta duplicado.
 * leerProductos: Verifica que se pueden leer todos los productos que haya almacenados en el TreeMap.
 * leerProductosVacios: Verifica que se retorne el mensaje adecuado cuando si no hay productos almacenados.
 * actualizarProducto: Verifica que se actualiza un producto correctamente.
 * actualizaProductoError: Verifica que si no existe el id no se actualiza el producto.
 * eliminaProducto: Verifica que un producto se ha elimindado correctamente.
 * eliminaProductoError: Verifica que si el id del producto dado para eliminar no existe no se elimina.
 * obtenerProducto: Verifica que se obtiene un producto correctamente por su id.
 * obtenerProductoError: Verifica que si el id no existe no se obtiene ningun producto.
 */
public class ProductoCRUDTest {

    /**
     * Metodo de prueba que verifica que el metodo crearProducto() de la clase ProductoCRUD
     * crea un producto correctamente, el test ejecuta crearProducto() pasando los atributos del producto, comprueba que el id no existe
     * y verifica que el valor de retorno sea: true, lo que indica que el producto fue creado correctamente.
     * Si el valor retornado y el esperado son iguales, significa que el metodo crearProducto() funciona correctamente
     * para un id que no existe anteriormente.
     */
    @Test
    public void crearProducto() {
        ProductoCRUD crud = new ProductoCRUD();
        boolean esperado = true;
        boolean accion = crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        Assert.assertEquals(esperado,accion);
    }

    /**
     * Metodo de prueba que verifica que el metodo crearProducto() de la clase ProductoCRUD
     * no crea un producto cuando el id ya existe, el test ejecuta crearProducto() pasando los atributos del producto,
     * y verifica que el id ya existe por lo que tendra una salida: false,
     * si el valor retornado y el esperado son iguales, significa que el metodo crearProducto() funciona correctamente
     * y no crea el producto para un id que ya existe con anterioridad.
     */
    @Test
    public void crearProductoDuplicado(){
        ProductoCRUD crud = new ProductoCRUD();
        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        Boolean esperado = false;
        Boolean accion = crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        Assert.assertEquals(esperado,accion);
    }

    /**
     * Metodo que verifica que el metodo leerProductos() de la clase ProductoCRUD
     * lee correctamente todos los productos almacenados en el TreeMap cuando este contiene entradas,
     * el test ejecuta leerProductos() y compara la cadena devuelta con la cadena esperada,
     * si son iguales el es porque leerProductos() funciona correctamente y esta devolviendo
     * los productos correctamente.
     */
    @Test
    public void leerProductos(){
        ProductoCRUD crud = new ProductoCRUD();
        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        crud.crearProducto(2, "Leche", 1.15, "Leche entera 1L", "Francia");
        String esperado = "Producto{id=1, nombre='Manzana', precio=0.99, descripcion='Fruta roja', pais='España'}, " +
                "Producto{id=2, nombre='Leche', precio=1.15, descripcion='Leche entera 1L', pais='Francia'}";
        String accion = crud.leerProductos();
        Assert.assertEquals(esperado,accion);
    }

    /**
     * Metodo de prueba que verifica que el metodo leerProductos() de la clase ProductoCRUD
     * devuelve el mensaje adecuado cuando el TreeMap esta vacio.
     * El test ejecuta leerProductos() y como el TreeMap no tiene productos, devuelve el mensaje:
     * "No hay productos.". Este mensaje se compara con el esperado, si son iguales, significa que el
     * metodo leerProductos() identifica correctamente que no hay productos y devuelve el mensaje esperado.
     */
    @Test
    public void leerProductosVacios(){
        ProductoCRUD crud = new ProductoCRUD();
        String esperado = "No hay productos.";
        String accion = crud.leerProductos();
        Assert.assertEquals(esperado, accion);
    }

    /**
     * Metodo que verifica que el metodo actualizarProducto() de la clase ProductoCRUD
     * actualiza correctamente los atributos del producto dado id existente en el TreeMap,
     * el test ejecuta actualizarProductos() y comprueba que el id pasado con los demás parametros exista,
     * en ese caso devuelve true, si el valor retornado y el esperado son iguales, significa que el metodo actualizarProducto() funciona correctamente
     * y actualiza los atributos del producto.
     */
    @Test
    public void actualizarProducto() {
        ProductoCRUD crud = new ProductoCRUD();
        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        boolean esperado = true;
        boolean accion = crud.actualizarProducto(1,"Manzana Golden", 1.15, "Tamaño pequeño", "España");
        Assert.assertEquals(esperado, accion);
    }

    /**
     * Metodo que verifica que el metodo actualizarProducto() de la clase ProductoCRUD
     * no actualiza los atributos del producto al dar un id que no existe en el TreeMap,
     * el test ejecuta actualizaProducto() y comprueba que el id pasado con los demás parametros exista,
     * en ese caso devuelve false, si el valor retornado y el esperado son iguales, significa que el metodo
     * actualizarProducto() funciona correctamente y no actualiza los atributos del producto.
     */
    @Test
    public void actualizarProductoError(){
        ProductoCRUD crud = new ProductoCRUD();
        boolean esperado = false;
        boolean accion = crud.actualizarProducto(1,"Manzana Golden", 1.15, "Tamaño pequeño", "España");
        Assert.assertEquals(esperado, accion);
    }

    /**
     * Metodo que verifica que el metodo eliminarProducto() de la clase ProductoCRUD
     * elimina correctamente un producto dado id existente en el TreeMap,
     * el test ejecuta eliminarProducto() y comprueba que el id pasado exista,
     * en ese caso devuelve true, si el valor retornado y el esperado son iguales, significa que el metodo eliminarProducto() funciona correctamente
     * y elimina el producto con el id proporcionado.
     */
    @Test
    public void eliminarProducto() {
        ProductoCRUD crud = new ProductoCRUD();
        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        boolean esperado = true;
        boolean accion = crud.eliminarProducto(1);
        Assert.assertEquals(esperado, accion);
    }

    /**
     * Metodo que verifica que el metodo eliminarProducto() de la clase ProductoCRUD
     * no elimina un producto dado id que no existe en el TreeMap,
     * el test ejecuta eliminarProducto() y comprueba que el id pasado exista,
     * en ese caso devuelve false, si el valor retornado y el esperado son iguales,
     * significa que el metodo eliminarProducto() funciona correctamente
     * y no elimina el producto con el id proporcionado, ya que este no existe.
     */
    @Test
    public void eliminarProductoError() {
        ProductoCRUD crud = new ProductoCRUD();
        boolean esperado = false;
        boolean accion = crud.eliminarProducto(1);
        Assert.assertEquals(esperado, accion);
    }

    /**
     * Metodo que verifica que el metodo obtenerProducto() de la clase ProductoCRUD
     * obtiene correctamente un producto dado id existente en el TreeMap,
     * el test ejecuta obtenerProducto() con un id existente y verifica que el producto obtenido
     * tenga los mismos atributos que el producto creado previamente.
     * Si el valor retornado como cadena, coincide con la cadena esperada, significa que el metodo
     * obtenerProducto() funciona correctamente y obtiene el producto con los valores correctos.
     */
    @Test
    public void obtenerProducto() {
        ProductoCRUD crud = new ProductoCRUD();
        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        String esperado = "Producto{id=1, nombre='Manzana', precio=0.99, descripcion='Fruta roja', pais='España'}";
        Producto accion = crud.obtenerProducto(1);
        Assert.assertEquals(esperado, accion.toString());
    }

    /**
     * Metodo que verifica que el metodo obtenerProducto() de la clase ProductoCRUD
     * no obtiene un producto dado id que no existe en el TreeMap,
     * el test ejecuta obtenerProducto() con un id que no corresponde a ningun producto y
     * verifica que el valor retornado sea null, lo que coincide con el retorno que debe hacer el
     * metodo, por lo tanto se confirma que el metodo obtenerProducto() funciona correctamente.
     */
    @Test
    public void obtenerProductoError() {
        ProductoCRUD crud = new ProductoCRUD();
        Producto accion = crud.obtenerProducto(1);
        Assert.assertNull(accion);
    }


}