/*
2. Crear una clase llamada CantanteFamoso. Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
Se debe, además, en el main, crear una lista de tipo CantanteFamoso y agregar 5
objetos de tipo CantanteFamoso a la lista. Luego, se debe mostrar los nombres de
cada cantante y su disco con más ventas por pantalla.
Una vez agregado los 5, en otro bucle, crear un menú que le de la opción al usuario de
agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el
usuario elija o de salir del programa. Al final se deberá mostrar la lista con todos los
cambios.
 */
package GUIA_10;

import GUIA_10_ENTIDADES.CantanteFamoso;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Extra1_02_Crear_clase_CantanteFamoso {
// SE GENERA UN PROBLEMA CON EL BUFFER DEL SCANNER, POR ESO SE DEBE CREAR UN SCANNER EN CADA FUNCION
//        private static Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n"); 

        private static ArrayList<CantanteFamoso> listaDeAgregados = new ArrayList(); // PARA LLEVAR EL CONTROL DE LOS AGREGADOS
        private static ArrayList<CantanteFamoso> listaDeBorrados = new ArrayList(); // PARA LLEVAR EL CONTROL DE LOS BORRADOS

        public static void main(String[] args) {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA

//                crear una lista de tipo CantanteFamoso y agregar 5
//                objetos de tipo CantanteFamoso a la lista.
                ArrayList<CantanteFamoso> listaCantanteFamoso = new ArrayList();
                System.out.println("Ingrese 5 artistas a la lista de Cantantes Famosos");
                for (int i = 0; i < 5; i++) {
                        CantanteFamoso cantantefamoso = new CantanteFamoso();
                        System.out.print("Ingrese el nombre del " + (i + 1) + "° cantante famoso: ");
                        cantantefamoso.setNombre(leer.nextLine());
                        System.out.print("Ingrese su disco con más ventas: ");
                        cantantefamoso.setDiscoConMasVentas(leer.nextLine());
                        listaCantanteFamoso.add(cantantefamoso);
                }

//                Luego, se debe mostrar los nombres de
//                cada cantante y su disco con más ventas por pantalla.
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                int orden = 1;
                for (CantanteFamoso artista : listaCantanteFamoso) {
                        System.out.println(orden++ + "°_ " + artista.toString());
                }
                System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                leer.next();

//                en otro bucle, crear un menú que le de la opción al usuario de
//                agregar un cantante más, mostrar todos los cantantes, eliminar un cantante que el
//                usuario elija o de salir del programa.
                char op;
                do {
//                        System.out.println("==================================");
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        System.out.println("\tMENU DE OPCIONES");
                        System.out.println("1)_ Agregar un cantante más");
                        System.out.println("2)_ Mostrar todos los cantantes");
                        System.out.println("3)_ Eliminar un cantante a elegir");
                        System.out.println("4)_ Salir del MENU");
                        System.out.print("\t\t\tElija su opción: ");
                        op = leer.next().charAt(0);

                        switch (op) {
                                case '1':
                                        agregarCantante(listaCantanteFamoso);
                                        break;
                                case '2':
                                        mostrarCantante(listaCantanteFamoso);
                                        break;
                                case '3':
                                        eliminarCantante(listaCantanteFamoso);
                                        break;
                                case '4':
                                        System.out.println("\nSe listarán los cambios relizados.");
                                        break;
                                default:
                                        System.err.println("\n\t\tOPCION INCORRECTA!!!");
                        }
                        System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                        leer.next();
                } while (op != '4');

//                Al final se deberá mostrar la lista con todos los
//                cambios.
                listarCambiosAgregados();
                System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                leer.next();

                listarCambiosBorrados();
                System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                leer.next();
        }

        private static void agregarCantante(ArrayList<CantanteFamoso> listaCantanteFamoso) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                CantanteFamoso cantantefamoso = new CantanteFamoso();
                System.out.print("Ingrese el nombre del nuevo cantante famoso: ");
                cantantefamoso.setNombre(leer.nextLine());
                System.out.print("Ingrese su disco con más ventas: ");
                cantantefamoso.setDiscoConMasVentas(leer.nextLine());
                listaCantanteFamoso.add(cantantefamoso);
                listaDeAgregados.add(cantantefamoso);
        }

        private static void mostrarCantante(ArrayList<CantanteFamoso> listaCantanteFamoso) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                int orden = 1;
                for (CantanteFamoso artista : listaCantanteFamoso) {
                        System.out.println(orden++ + "°_" + artista.toString());
                }
        }

        private static void eliminarCantante(ArrayList<CantanteFamoso> listaCantanteFamoso) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                boolean b = true;
//                                        leer.next(); // LIMPIO EL BUFFER DE LEER
                System.out.print("Ingrese el nombre del cantante a borrar: ");
                String nombre = leer.nextLine();
//                                        nombre = leer.nextLine();
                Iterator<CantanteFamoso> it = listaCantanteFamoso.iterator();
                while (it.hasNext()) {
                        // utilizo éste paso para poder salvar el objeto en la lista de cambios.
                        CantanteFamoso aux = it.next();
                        if (aux.getNombre().equalsIgnoreCase(nombre)) {
                                it.remove();
                                listaDeBorrados.add(aux);
                                b = false;
                                System.out.println("El artista fue borrado de la lista.");
                        }
                }
                if (b) {
                        System.err.println("El artista ingresado no está en la lista.");
                }
        }

        private static void listarCambiosAgregados() {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                if (listaDeAgregados.isEmpty()) {
                        System.out.println("\nEl usuario no agregó ningún nuevo cantante famoso a la lista.");
                } else {
                        System.out.println("\nCantantes Famosos AGREGADOS a la lista:");
                        int orden = 1;
                        for (CantanteFamoso artista : listaDeAgregados) {
                                System.out.println(orden++ + "°_" + artista.toString());
                        }
                }
        }

        private static void listarCambiosBorrados() {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                if (listaDeBorrados.isEmpty()) {
                        System.out.println("\nEl usuario no borró ningún cantante famoso de la lista.");
                } else {
                        System.out.println("\nCantantes Famosos BORRADOS de la lista: ");
                        int orden = 1;
                        for (CantanteFamoso artista : listaDeBorrados) {
                                System.out.println(orden++ + "°_" + artista.toString());
                        }
                }
        }
}
