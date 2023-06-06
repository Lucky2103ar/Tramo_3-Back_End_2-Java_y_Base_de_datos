/*
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:
• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package GUIA_10_SERVICIOS;

import GUIA_10_ENTIDADES.Pelicula;
import java.util.ArrayList;
import static java.util.Collections.reverse;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class PeliculaServicio {

        private final Scanner leerStr = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        private final Scanner leerNum = new Scanner(System.in);
        private final Scanner leerCha = new Scanner(System.in);

//        En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
//        todos sus datos y guardándolos en el objeto Pelicula.
//        Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
//        crear otra Pelicula o no.
        public ArrayList<Pelicula> crearPelicula() {
                // Creo una lista vacía para guardar las peliculas.
                ArrayList<Pelicula> listaPelicula = new ArrayList();
                char resp;
                System.out.print("¿Desea usar el llenado automático? (S/N): ");
                resp = Character.toUpperCase(leerCha.next().charAt(0));
                if (resp == 'S') {
                        listaPelicula = llenadoAutomatico();
                } else {
                        // Bucle para cargar los datos de los alumnos.
                        do {
                                // Pido los datos de la película.
                                System.out.print("\nIngrese el título de la Película: ");
                                String titulo = leerStr.nextLine();

                                System.out.print("Ingrese el nombre del director: ");
                                String director = leerStr.nextLine();

                                System.out.print("Ingrese su duración (en horas): ");
                                Float duracion = leerNum.nextFloat();

                                // Se guardan los datos ingresados en el objeto y éste se guarda en la lista.
                                Pelicula pelicula = new Pelicula(titulo, director, duracion);
                                listaPelicula.add(pelicula);

                                // Pregunto si se desea cargar otro alumno.
                                System.out.print("¿Quiere cargar otra Pelicula? (S/N): ");
                                resp = Character.toUpperCase(leerCha.next().charAt(0));
                        } while (resp == 'S');  // Con cualquier caracter que no sea 'S' sale del DoWhile.

                }
                return listaPelicula;
        }

//         • Mostrar en pantalla todas las películas.
        public void mostrarPeliculas(ArrayList<Pelicula> listaPelicula) {
                int i = 0;
                // bucle forEach
                for (Pelicula pelicula : listaPelicula) {
//                        System.out.println(++i + "° Título: " + pelicula.getTitulo());
//                        System.out.println("   Director: " + pelicula.getDirector());
//                        System.out.println("   Duración: " + pelicula.getDuracion());
                        System.out.println(++i + ")_ " + pelicula.toString());
                }
        }

//        • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
        public void mostrarPelisMay1Hora(ArrayList<Pelicula> listaPelicula) {
                int i = 1;
                // bucle forEach
                for (Pelicula pelicula : listaPelicula) {
                        if (pelicula.getDuracion() > 1) {
                                System.out.println(i++ + ")_ " + pelicula.toString());
                        }
                }
        }

//        • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en pantalla.
        public void ordenarPelisXDuracionMayAMen(ArrayList<Pelicula> listaPelicula) {
                listaPelicula.sort(Pelicula.ordenarXDuracion); // Utilizo el método de ordenamiento por DURACION de la CLASE ENTIDAD.
                mostrarPeliculas(listaPelicula); // muestro por pantalla.
        }

//        • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en pantalla.
        public void ordenarPelisXDuracionMenAMay(ArrayList<Pelicula> listaPelicula) {
                listaPelicula.sort(Pelicula.ordenarXDuracion); // Utilizo el método de ordenamiento por DURACION de la CLASE ENTIDAD.
                reverse(listaPelicula); // Luego invierto el orden devuelto,
                mostrarPeliculas(listaPelicula); // muestro por pantalla.
        }

//        • Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
        public void ordenarPelisXTitulo(ArrayList<Pelicula> listaPelicula) {
                listaPelicula.sort(Pelicula.ordenarXTitulo); // Utilizo el método de ordenamiento por TITULO de la CLASE ENTIDAD.
                mostrarPeliculas(listaPelicula); // muestro por pantalla.
        }

//        • Ordenar las películas por director , alfabéticamente y mostrarlo en pantalla.
        public void ordenarPelisXDirector(ArrayList<Pelicula> listaPelicula) {
                listaPelicula.sort(Pelicula.ordenarXDirector); // Utilizo el método de ordenamiento por DIRECTOR de la CLASE ENTIDAD.
                mostrarPeliculas(listaPelicula); // muestro por pantalla.
        }

//        METODOS AUXILIARES
        private ArrayList<Pelicula> llenadoAutomatico() {
                ArrayList<Pelicula> listaPelicula = new ArrayList();
                Pelicula pelicula = new Pelicula();
                pelicula = new Pelicula("Los Caballeros del Zodiaco", "Tomasz Baginski", 1.87f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("Super Mario Bros. La película", "Aaron Horvath, Michael Jelenic", 1.53f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("El exorcista del Papa", "Julius Avery", 1.72f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("Guardianes de la Galaxia: Volumen 3", "James Gunn", 2.5f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("John Wick 4", "Chad Stahelski", 2.83f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("La bolita - El cortometraje", "Arturo Artal, Juan Carrascal Yñigo", 0.05f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("Por siempre jamás (C)", "Jordi García", 0.08f);
                listaPelicula.add(pelicula);
                pelicula = new Pelicula("El puercoespín", "Carlos Lerma", 0.03f);
                listaPelicula.add(pelicula);
                return listaPelicula;
        }

}
