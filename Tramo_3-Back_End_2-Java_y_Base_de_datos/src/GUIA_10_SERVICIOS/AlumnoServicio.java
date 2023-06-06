package GUIA_10_SERVICIOS;

import GUIA_10_ENTIDADES.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class AlumnoServicio {

        private final Scanner leerStr = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        private final Scanner leerNum = new Scanner(System.in);

/*
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
*/
        public ArrayList<Alumno> crearAlumno() {
                // Creo una lista vacía de alumnos
                ArrayList<Alumno> listaAlumnos = new ArrayList();
                char resp;

                // Bucle para cargar los datos de los alumnos
                do {

                        // Pido los datos del alumno
                        System.out.print("Ingrese el nombre del alumno: ");
                        String nombre = leerStr.nextLine();

                        System.out.print("Ingrese la 1ra nota del alumno: ");
                        Float nota1 = leerNum.nextFloat();

                        System.out.print("Ingrese la 2da nota del alumno: ");
                        Float nota2 = leerNum.nextFloat();

                        System.out.print("Ingrese la 3ra nota del alumno: ");
                        Float nota3 = leerNum.nextFloat();

                        // Creo un objeto alumno con los datos ingresados y lo agrego a la lista
                        ArrayList<Float> notas = new ArrayList();
                        notas.add(nota1);
                        notas.add(nota2);
                        notas.add(nota3);
                        Alumno alumno = new Alumno(nombre, notas);
                        listaAlumnos.add(alumno);

                        // Pregunto si se desea cargar otro alumno
                        System.out.print("¿Desea continuar añadiendo ALUMNOS? (S/N): ");
                        resp = Character.toUpperCase(leerStr.next().charAt(0));

                } while (resp == 'S');  // Con cualquier caracter que no sea 'S' sale del DoWhile 
                return listaAlumnos;
        }

/*
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
*/
        public float notaFinal(ArrayList<Float> notas) {
                float n1 = notas.get(0);
                float n2 = notas.get(1);
                float n3 = notas.get(2);
                return (n1 + n2 + n3) / 3;
        }

}
