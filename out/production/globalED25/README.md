//Ejemplo de prueba de la clase

public class Main {
    public static void main(String[] args) {
        src.main.java.ProductoCRUD crud = new src.main.java.ProductoCRUD();

        crud.crearProducto(1, "Manzana", 0.99, "Fruta roja", "España");
        crud.crearProducto(2, "Leche", 1.15, "Leche entera 1L", "Francia");

        System.out.println(crud.leerProductos());

        crud.eliminarProducto(1);
        crud.eliminarProducto(2);

        System.out.println(crud.leerProductos()); // "No hay productos."
    }
}