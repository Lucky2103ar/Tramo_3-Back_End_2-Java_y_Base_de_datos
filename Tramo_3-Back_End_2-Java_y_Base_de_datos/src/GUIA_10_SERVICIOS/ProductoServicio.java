/*
//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//productos que venderemos y el precio que tendrán. Además, se necesita que la
//aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package GUIA_10_SERVICIOS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class ProductoServicio {

        private Scanner leerStr = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        private Scanner leerNum = new Scanner(System.in);
        private Scanner leerCha = new Scanner(System.in);

        public void ingresarProducto(HashMap<String, Float> stock) {
                System.out.print("¿Cuál es el producto que desea cargar al stock?: ");
                String prod = leerStr.nextLine().toUpperCase();
                System.out.print("Ingrese el precio del producto: $");
                Float precio = Math.round(leerNum.nextFloat() * 100) / 100.0f;
                stock.put(prod, precio);
                System.out.print("¿Desea agregar otro producto?(S/N): ");
                char resp = Character.toUpperCase(leerCha.next().charAt(0));
                if (resp == 'S') {
                        ingresarProducto(stock);
                }
        }

        public void modificarPrecio(HashMap<String, Float> stock) {
                System.out.print("¿Cuál es el producto que desea modificar?: ");
                String prod = leerStr.nextLine().toUpperCase();
                if (stock.containsKey(prod)) {
                        System.out.print("Ingrese el nuevo precio del producto: $");
                        Float precio = Math.round(leerNum.nextFloat() * 100) / 100.0f;
                        stock.put(prod, precio);
                }else{
                        System.err.println("El producto no está cargado en el stock!");
                }
                System.out.print("¿Desea modificar el precio de otro producto?(S/N): ");
                char resp = Character.toUpperCase(leerCha.next().charAt(0));
                if (resp == 'S') {
                        modificarPrecio(stock);
                }
        }
        
        public void eliminarProducto(HashMap<String, Float> stock) {
                System.out.print("¿Cuál es el producto que desea eliminar?: ");
                String prod = leerStr.nextLine().toUpperCase();
                if (stock.containsKey(prod)) {
                        stock.remove(prod);
                        System.out.println("Producto Eliminado...");
                }else{
                        System.err.println("El producto no está cargado en el stock!");
                }
                System.out.print("¿Desea eliminar otro producto?(S/N): ");
                char resp = Character.toUpperCase(leerCha.next().charAt(0));
                if (resp == 'S') {
                        eliminarProducto(stock);
                }
        }
        
        public void mostrarProductos(HashMap<String, Float> stock) {
                for (Map.Entry<String, Float> entry : stock.entrySet()) {
                        String prod = entry.getKey();
                        Float precio = entry.getValue();
                        System.out.println(prod + ": $" + precio);
                }
        }
}
