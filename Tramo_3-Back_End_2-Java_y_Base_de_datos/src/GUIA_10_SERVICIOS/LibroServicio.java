/*
Métodos auxiliares para Método prestamo() y Método devolucion() de la clase ENTIDAD
 */
package GUIA_10_SERVICIOS;

import GUIA_10_ENTIDADES.Libro;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class LibroServicio {

        private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

        public void buquedaParaPrestamo(HashSet<Libro> biblioteca) {
                System.out.print("Ingrese el título del libro que quiere prestar: ");
                String tituloBuscado = leer.next();
                Iterator<Libro> it = biblioteca.iterator();
                boolean b = false;
                while (it.hasNext()) {
                        Libro libro = it.next();
                        if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                                b = true;
                                if (libro.prestamo(libro)) {
                                        System.out.println("Se presta el libro solicitado.");
                                } else {
                                        System.out.println("Todos los ejemplares del libro están prestados");
                                }
                        }
                }
                if (!b) {
                        System.err.println("Lo siento, no nos figura ese libro en el inventario.");
                }
        }

        public void buquedaParaDevolucion(HashSet<Libro> biblioteca) {
                System.out.print("Ingrese el título del libro que quiere devolver: ");
                String tituloBuscado = leer.next();
                Iterator<Libro> it = biblioteca.iterator();
                boolean b = false;
                while (it.hasNext()) {
                        Libro libro = it.next();
                        if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                                b = true;
                                if (libro.devolucion(libro)) {
                                        System.out.println("Se recibe el libro solicitado.");
                                } else {
                                        System.out.println("Todos los ejemplares del libro están devueltos");
                                }
                        }
                }
                if (!b) {
                        System.err.println("Lo siento, no nos figura ese libro en el inventario.");
                }
        }

        public void agregarLibro(HashSet<Libro> biblioteca) {
                // Pido los datos del libro para crear el objeto del tipo Libro.
                System.out.print("Ingrese el título del libro: ");
                String titulo = leer.next();

                System.out.print("Ingrese el nombre del autor: ");
                String autor = leer.next();

                System.out.print("Ingrese el número de ejemplares: ");
                int ejemplares = leer.nextInt();

                // Creo el objeto del tipo Libro.
                Libro libroNuevo = new Libro(titulo, autor, ejemplares);

                // Guardo el objeto en el Conjunto.
                biblioteca.add(libroNuevo);

                System.out.println("\n\t!Libro agregado con éxito!");
        }

        public void modificarLibro(HashSet<Libro> biblioteca) {
                System.out.print("Ingrese el título del libro que quiere modificar: ");
                String tituloBuscado = leer.next();
                Iterator<Libro> it = biblioteca.iterator();
                char resp;
                boolean b = false;
                while (it.hasNext()) {
                        Libro libro = it.next();
                        if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                                b = true;
                                System.out.print("¿Quiere modificar el título? (S/N): ");
                                resp = Character.toUpperCase(leer.next().charAt(0));
                                if (resp == 'S') {
                                        System.out.print("\tIngrese el nuevo título del libro: ");
                                        libro.setTitulo(leer.next()); // Sobreescribo el dato viejo.
                                }

                                System.out.print("¿Quiere modificar el nombre del autor? (S/N): ");
                                resp = Character.toUpperCase(leer.next().charAt(0));
                                if (resp == 'S') {
                                        System.out.print("\tIngrese el nuevo nombre del autor: ");
                                        libro.setAutor(leer.next()); // Sobreescribo el dato viejo.
                                }

                                System.out.print("¿Quiere modificar la cantidad de ejemplares? (S/N): ");
                                resp = Character.toUpperCase(leer.next().charAt(0));
                                if (resp == 'S') {
                                        System.out.print("\tIngrese el nuevo número de ejemplares: ");
                                        libro.setEjemplares(leer.nextInt()); // Sobreescribo el dato viejo.
                                }
                                it.remove(); // Elimino del Conjunto el Elemento con los datos viejos.
                                biblioteca.add(libro); // Agrego el libro modificado como un libro nuevo.
                                System.out.println("\n\t!Libro modificado con éxito!");
                                break; // Tengo que salir de la busqueda para que no vuelva a encontrar al Elemento que acabo de modificar.
                        }
                }
                if (!b) {
                        System.err.println("Lo siento, no nos figura ese libro en el inventario.");
                }
        }

        public void eliminarLibro(HashSet<Libro> biblioteca) {
                System.out.print("Ingrese el título del libro que quiere eliminar: ");
                String tituloBuscado = leer.next();
                Iterator<Libro> it = biblioteca.iterator();
                boolean b = false;
                while (it.hasNext()) {
                        Libro libro = it.next();
                        if (libro.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                                b = true;
                                it.remove();
                                System.out.println("\n\t!Libro eliminado con éxito!");
                        }
                }
                if (!b) {
                        System.err.println("Lo siento, no nos figura ese libro en el inventario.");
                }
        }

        public void listarLibros(HashSet<Libro> biblioteca) {
                System.out.println("Éstos son los libros con los que cuenta la biblioteca: \n");
                int i = 0;
                for (Libro libro : biblioteca) {
                        System.out.println(libro.toString());
                        i++;
                        if (i % 15 == 0) {
                                System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                                leer.next();
                                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        }
                }
        }
}
