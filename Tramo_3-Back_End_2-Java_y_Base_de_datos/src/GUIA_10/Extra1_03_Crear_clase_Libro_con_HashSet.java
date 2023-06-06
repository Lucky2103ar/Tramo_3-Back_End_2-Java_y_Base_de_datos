/*
3. Implemente un programa para una Librería haciendo uso de un HashSet para evitar
datos repetidos. Para ello, se debe crear una clase llamada Libro que guarde la
información de cada uno de los libros de una Biblioteca. La clase Libro debe guardar
el título del libro, autor, número de ejemplares y número de ejemplares prestados.
También se creará en el main un HashSet de tipo Libro que guardará todos los libros
creados.
En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos
sus datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y
se le pregunta al usuario si quiere crear otro Libro o no.
La clase Librería contendrá además los siguientes métodos:
• Constructor por defecto.
• Constructor con parámetros.
• Métodos Setters/getters
• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al
método. El método se incrementa de a uno, como un carrito de compras, el
atributo ejemplares prestados, del libro que ingresó el usuario. Esto sucederá
cada vez que se realice un préstamo del libro. No se podrán prestar libros de los
que no queden ejemplares disponibles para prestar. Devuelve true si se ha
podido realizar la operación y false en caso contrario.
• Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se
lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método.
El método decrementa de a uno, como un carrito de compras, el atributo
ejemplares prestados, del libro seleccionado por el usuario. Esto sucederá cada
vez que se produzca la devolución de un libro. No se podrán devolver libros
donde que no tengan ejemplares prestados. Devuelve true si se ha podido
realizar la operación y false en caso contrario.
• Método toString para mostrar los datos de los libros.
 */
package GUIA_10;

import GUIA_10_ENTIDADES.Libro;
import GUIA_10_SERVICIOS.LibroServicio;
import java.util.HashSet;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Extra1_03_Crear_clase_Libro_con_HashSet {

        public static void main(String[] args) {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                Libro libro = new Libro();
                LibroServicio libServ = new LibroServicio();
                HashSet<Libro> biblioteca;

//                En el main tendremos un bucle que crea un objeto Libro pidiéndole al usuario todos
//                sus datos y los seteandolos en el Libro. Despues, ese Libro se guarda en el conjunto y
//                se le pregunta al usuario si quiere crear otro Libro o no.
                System.out.print("Desea llenar el conjunto en forma manual o automática (M/A): ");
                char op = Character.toUpperCase(leer.next().charAt(0));
                if (op == 'M') {
                        biblioteca = crearBiblioteca(); // Tengo que definir biblioteca fue del para evitar errores mas adelante.
                } else {
                        // Me devuelve un conjunto creado con 100 elementos.
                        biblioteca = crearBibliotecaAutomatica();
                }

                do {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        System.out.println("\tMENU DE OPCIONES");
                        System.out.println("1)_ Agregar un libro a la Librería.");
                        System.out.println("2)_ Modificar un libro de la Librería.");
                        System.out.println("3)_ Eliminar un libro de la Librería.");
                        System.out.println("4)_ Prestar un libro de la Librería.");
                        System.out.println("5)_ Devolver un libro a la Librería.");
                        System.out.println("6)_ Listar libros de la biblioteca.");
                        System.out.println("S)_ Salir del MENU.");
                        System.out.print("\t\t\tElija su opción: ");
                        op = Character.toUpperCase(leer.next().charAt(0));
                        switch (op) {
                                case '1':
                                        libServ.agregarLibro(biblioteca);
                                        break;
                                case '2':
                                        libServ.modificarLibro(biblioteca);
                                        break;
                                case '3':
                                        libServ.eliminarLibro(biblioteca);
                                        break;
                                case '4':
                                        libServ.buquedaParaPrestamo(biblioteca);
                                        break;
                                case '5':
                                        libServ.buquedaParaDevolucion(biblioteca);
                                        break;
                                case '6':
                                        libServ.listarLibros(biblioteca);
                                        break;
                                case 'S':
                                        System.out.println("\n\t\tGracias por usar nuestro programa.");
                                        break;
                                default:
                                        System.err.println("\n\t\tOPCION INCORRECTA!!!");
                        }
                        System.out.println("\n\t\t\t\t\tPresion ENTER para continuar...");
                        leer.next();
                } while (op != 'S');
        }

        private static HashSet<Libro> crearBiblioteca() {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                Libro libro = new Libro();
                LibroServicio libServ = new LibroServicio();
                HashSet<Libro> biblioteca = new HashSet();
                char resp;
                do {
//                        Otra forma de hacer la carga de los libros, dentro del bucle, es llamando éste método.
//                        libServ.agregarLibro(biblioteca); 
//                        Pero lo que pide el enunciado es pedir los datos y settearlos en el Objeto.

                       // Pido los datos del libro para setear en el Libro.
                        System.out.print("Ingrese el título del libro: ");
                        libro.setTitulo(leer.next());

                        System.out.print("Ingrese el nombre del autor: ");
                        libro.setAutor(leer.next());

                        System.out.print("Ingrese el número de ejemplares: ");
                        libro.setEjemplares(leer.nextInt());
                        
                        libro.setPrestados(0);
                        
                        // Guardo el objeto en el Conjunto.
                        biblioteca.add(libro);
                        
                        // Pregunto si se desea cargar otro libro.
                        System.out.print("¿Quiere cargar otro libro? (S/N): ");  // Con cualquier caracter que no sea 'S' o 's' va a terminar el DoWhile.
                        resp = Character.toUpperCase(leer.next().charAt(0));
                } while (resp == 'S');
                return biblioteca;
        }

        private static HashSet<Libro> crearBibliotecaAutomatica() {
                HashSet<Libro> biblioteca = new HashSet();
                // Se guardan los datos ingresados en el objeto y éste se guarda en la lista.
                Libro libro;
                libro = new Libro("Poema de Gilgamesh", "Anónimo", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Libro de Job (de la Biblia)", "Moisés", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Las mil y una noches", "Anónimo", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Saga de Njál", "Anónimo", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Todo se desmorona", "Chinua Achebe", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Cuentos infantiles", "Hans Christian Andersen", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Divina comedia", "Dante Alighieri", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Orgullo y prejuicio", "Jane Austen", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Papá Goriot", "Honoré de Balzac", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Molloy, Malone muere, El Innombrable, una trilogía", "Samuel Beckett", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Decamerón", "Giovanni Boccaccio", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ficciones", "Jorge Luis Borges", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Cumbres Borrascosas", "Emily Brontë", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El extranjero", "Albert Camus", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Poemas", "Paul Celan", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Viaje al fin de la noche", "Louis-Ferdinand Céline", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Los cuentos de Canterbury", "Geoffrey Chaucer", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Relatos cortos", "Antón Chéjov", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Nostromo", "Joseph Conrad", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Grandes Esperanzas", "Charles Dickens", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Jacques el fatalista", "Denis Diderot", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Berlin Alexanderplatz", "Alfred Döblin", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Crimen y castigo", "Fiódor Dostoievski", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El idiota", "Fiódor Dostoievski", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Los endemoniados", "Fiódor Dostoievski", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Los hermanos Karamazov", "Fiódor Dostoievski", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Middlemarch", "George Eliot", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El hombre invisible", "Ralph Ellison", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Medea", "Eurípides", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("¡Absalom, Absalom!", "William Faulkner", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El ruido y la furia", "William Faulkner", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Madame Bovary", "Gustave Flaubert", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La educación sentimental", "Gustave Flaubert", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Romancero gitano", "Federico García Lorca", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Cien años de soledad", "Gabriel García Márquez", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Fausto", "Johann Wolfgang von Goethe", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Almas muertas", "Nikolai Gogol", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El tambor de hojalata", "Günter Grass", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Gran Sertón: Veredas", "João Guimarães Rosa", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hambre", "Knut Hamsun", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El viejo y el mar", "Ernest Hemingway", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ilíada", "Homero", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Odisea", "Homero", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Casa de muñecas", "Henrik Ibsen", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ulises", "James Joyce", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Relatos cortos", "Franz Kafka", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El proceso", "Franz Kafka", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El castillo", "Franz Kafka", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Shakuntala", "Kālidāsa", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El sonido de la montaña", "Yasunari Kawabata", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Zorba, el griego", "Nikos Kazantzakis", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hijos y amantes", "D. H. Lawrence", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Gente independiente", "Halldór Laxness", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Poemas", "Giacomo Leopardi", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El cuaderno dorado", "Doris Lessing", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Pippi Calzaslargas", "Astrid Lindgren", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Diario de un loco", "Lu Xun", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hijos de nuestro barrio", "Naguib Mahfuz", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Los Buddenbrook", "Thomas Mann", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La montaña mágica", "Thomas Mann", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Moby-Dick", "Herman Melville", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ensayos", "Michel de Montaigne", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La historia", "Elsa Morante", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Beloved", "Toni Morrison", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Genji Monogatari", "Murasaki Shikibu", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El hombre sin atributos", "Robert Musil", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Lolita", "Vladimir Nabokov", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("1984", "George Orwell", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Las metamorfosis", "Ovidio", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Libro del desasosiego", "Fernando Pessoa", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Cuentos", "Edgar Allan Poe", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("En busca del tiempo perdido", "Marcel Proust", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Gargantúa y Pantagruel", "François Rabelais", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Pedro Páramo", "Juan Rulfo", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Masnavi", "Rumi", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hijos de la medianoche", "Salman Rushdie", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Bostan", "Saadi", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Tiempo de migrar al norte", "Tayeb Salih", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ensayo sobre la ceguera", "José Saramago", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hamlet", "William Shakespeare", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("El rey Lear", "William Shakespeare", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Otelo", "William Shakespeare", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Edipo rey", "Sófocles", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Rojo y negro", "Stendhal", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Vida y opiniones del caballero Tristram Shandy", "Laurence Sterne", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La conciencia de Zeno", "Italo Svevo", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Los viajes de Gulliver", "Jonathan Swift", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Guerra y paz", "Lev Tolstói", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ana Karenina", "Lev Tolstói", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La muerte de Iván Ilich", "Lev Tolstói", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Las aventuras de Huckleberry Finn", "Mark Twain", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Ramayana", "Valmiki", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Eneida", "Virgilio", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Mahabhárata", "Viasa", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Hojas de hierba", "Walt Whitman", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("La señora Dalloway", "Virginia Woolf", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Al faro", "Virginia Woolf", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                libro = new Libro("Memorias de Adriano", "Marguerite Yourcenar", (int) Math.round(Math.random() * 100 + 1));
                biblioteca.add(libro);
                return biblioteca;
        }
}
