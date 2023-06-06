/*
3. Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main.
Pueden encontrar un ejemplo de Colección como Atributo en tu Aula
Virtual.
 */
package GUIA_10;

import GUIA_10_ENTIDADES.Alumno;
import GUIA_10_SERVICIOS.AlumnoServicio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Ejercicio_03_Crear_clase_Alumno {
        public static void main(String[] args) {
                Scanner leerStr = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                AlumnoServicio alumServ = new AlumnoServicio();
                ArrayList<Alumno> listaAlumnos = alumServ.crearAlumno(); // crearAlumno devuelve un ArrayList con elementos del tipo Alumno

                Iterator<Alumno> it = listaAlumnos.iterator();
                boolean b = false;
                System.out.print("Ingrese el nombre del alumno del que quiere calcular su nota final: ");
                String nomBuscado = leerStr.nextLine();
                while (it.hasNext()) {
                        Alumno alumno = it.next();
                        if (alumno.getNombre().equalsIgnoreCase(nomBuscado)) {
                                System.out.println("La nota final de " + nomBuscado + " es: " + alumServ.notaFinal(alumno.getNotas()));
                                b = true;
                        }
                }
                if (!b) {
                        System.out.println("El alumno "+ nomBuscado + " no está en la lista de alumnos.");
                }
        }
}
