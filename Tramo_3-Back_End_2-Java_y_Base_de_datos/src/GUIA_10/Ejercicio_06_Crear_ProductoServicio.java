/*
//Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
//productos que venderemos y el precio que tendrán. Además, se necesita que la
//aplicación cuente con las funciones básicas.
//Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
//eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
//Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
//Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package GUIA_10;

import GUIA_10_SERVICIOS.ProductoServicio;
import java.util.HashMap;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Ejercicio_06_Crear_ProductoServicio {
        
        public static void main(String[] args) {
                HashMap<String, Float> stock = new HashMap();
                ProductoServicio prodServ = new ProductoServicio();
                Scanner leer = new Scanner(System.in);
                char op;
                
                do {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("\tMENU");
                        System.out.println("1- Agregar Productos");
                        System.out.println("2- Modificar Precios");
                        System.out.println("3- Eliminar Productos");
                        System.out.println("4- Mostrar Productos");
                        System.out.println("S- Salir");
                        System.out.print("\n\t\tElija su opción: ");
                        op = Character.toUpperCase(leer.next().charAt(0));
                        switch (op) {
                                case '1':
                                        prodServ.ingresarProducto(stock);
                                        break;
                                case '2':
                                        prodServ.modificarPrecio(stock);
                                        break;
                                case '3':
                                        prodServ.eliminarProducto(stock);
                                        break;
                                case '4':
                                        prodServ.mostrarProductos(stock);
                                        break;
                                case 'S':
                                        System.out.println("            ¡GRACIAS POR USAR NUESTRO PROGRAMA!");
                                        break;
                                default:
                                        System.err.println("               OPCION NO VALIDA!!!");
                        }
                        
//                        System.out.println("\n                              Presione ENTER para continuar...");
//                        leer.next();
                } while (op != 'S');
                
        }
}
