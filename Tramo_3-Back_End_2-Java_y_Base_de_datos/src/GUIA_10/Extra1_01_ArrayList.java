/*
1. Diseñar un programa que lea una serie de valores numéricos enteros desde el teclado
y los guarde en un ArrayList de tipo Integer. La lectura de números termina cuando se
introduzca el valor -99. Este valor no se guarda en el ArrayList. A continuación, el
programa mostrará por pantalla el número de valores que se han leído, su suma y su
media (promedio).
 */
package GUIA_10;

import java.util.ArrayList;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Extra1_01_ArrayList {

        public static void main(String[] args) {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                ArrayList<Integer> listaEnteros = new ArrayList();
                int suma = 0;

                System.out.println("Ingrese una serie de valores numéricos enteros.");
                System.err.println("La carga de datos se finaliza con el valor -99.");
                while (true) {
                        int num = leer.nextInt();
                        if (num == -99) {
                                break;
                        }
                        listaEnteros.add(num);
                }

                for (Integer num : listaEnteros) {
                        suma = suma + num;
                }

                System.out.println("\nEl número de valores que se han leído es: " + listaEnteros.size()
                        + "\nLa suma de los valores que se han leído es: " + suma
                        + "\nLa media de los valores que se han leído es: " + suma / listaEnteros.size());
        }
}
