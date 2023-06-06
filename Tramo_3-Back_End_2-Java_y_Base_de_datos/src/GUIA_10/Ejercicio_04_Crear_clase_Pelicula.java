/*
4. Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla toda1s las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package GUIA_10;

import GUIA_10_SERVICIOS.PeliculaServicio;
import GUIA_10_ENTIDADES.Pelicula;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Ejercicio_04_Crear_clase_Pelicula {

        public static void main(String[] args) {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                PeliculaServicio peliServ = new PeliculaServicio();
                ArrayList<Pelicula> listaPeliculas = new ArrayList();
                char op;
                boolean b = true;

                do {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n");
                        System.out.println("1- Crear Lista de Películas");
                        System.out.println("2- Listar las Películas ingresadas");
                        System.out.println("3- Listar las películas con una duración mayor a 1 hora");
                        System.out.println("4- Listar las películas ordenadas de acuerdo a su duración (de mayor a menor)");
                        System.out.println("5- Listar las películas ordenadas de acuerdo a su duración (de menor a mayor)");
                        System.out.println("6- Listar las películas ordenadas por título");
                        System.out.println("7- Listar las películas ordenadas por director");
                        System.out.println("S- Salir");
                        System.out.print("\n                  Elija su opción: ");
                        op = Character.toUpperCase(leer.next().charAt(0));

                        switch (op) {
                                case '1':
                                        if (b) {
                                                listaPeliculas = peliServ.crearPelicula();
                                                b = false;
                                        } else {
                                                System.out.print("Ya existe una lista creada, ¿desea borrarla y crear una nueva? (S/N): ");
                                                op = Character.toLowerCase(leer.next().charAt(0));
                                                if (op == 's') {
                                                        listaPeliculas = peliServ.crearPelicula();
                                                }
                                        }
                                        break;
                                case '2':
                                        System.out.println("\nLas películas ingresadas son:");
                                        peliServ.mostrarPeliculas(listaPeliculas);
                                        break;
                                case '3':
                                        System.out.println("\nLas películas con una duración mayor a 1 hora son:");
                                        peliServ.mostrarPelisMay1Hora(listaPeliculas);
                                        break;
                                case '4':
                                        System.out.println("\nLas películas ordenadas de acuerdo a su duración (de mayor a menor) son:");
                                        peliServ.ordenarPelisXDuracionMayAMen(listaPeliculas);
                                        break;
                                case '5':
                                        System.out.println("\nLas películas ordenadas de acuerdo a su duración (de menor a mayor) son:");
                                        peliServ.ordenarPelisXDuracionMenAMay(listaPeliculas);
                                        break;
                                case '6':
                                        System.out.println("\nLas películas ordenadas por título son:");
                                        peliServ.ordenarPelisXTitulo(listaPeliculas);
                                        break;
                                case '7':
                                     System.out.println("\nLas películas ordenadas por director son:");
                                        peliServ.ordenarPelisXDirector(listaPeliculas);
                                        break;
                                case 'S':
                                        System.out.println("            ¡GRACIAS POR USAR NUESTRO PROGRAMA!");
                                        break;
                                default:
                                        System.err.println("               OPCION NO VALIDA!!!");
                        }
                        
                        System.out.println("\n                              Presione ENTER para continuar...");
                        leer.next();
                } while (op != 'S');
        }
}
