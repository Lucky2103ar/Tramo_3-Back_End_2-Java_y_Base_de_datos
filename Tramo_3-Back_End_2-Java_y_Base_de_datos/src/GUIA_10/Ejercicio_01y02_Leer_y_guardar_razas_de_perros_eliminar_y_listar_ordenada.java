/*
1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.
 */
package GUIA_10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class Ejercicio_01y02_Leer_y_guardar_razas_de_perros_eliminar_y_listar_ordenada {

        public static void main(String[] args) {
                Scanner leerStr = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                Scanner leercha = new Scanner(System.in);
                ArrayList<String> razaPerros = new ArrayList();
                char resp;

                //  leo y guardo razas de perros
                do {
                        System.out.print("Ingrese una raza de perro: ");
                        razaPerros.add(leerStr.nextLine());
                        System.out.print("¿Desea continuar añadiendo razas de perros (S/N)? ");
                        resp = Character.toUpperCase(leercha.next().charAt(0));
//                        leer.next(); // Limpio el buffer
                } while (resp == 'S');

                // muestro todos los perros guardados 
                System.out.println("\nLas razas de perros ingresadas son:");
                // bucle forEach
                for (String cadena : razaPerros) {
                        System.out.println("    *" + cadena);
                }

//                for (int i = 0; i < razaPerros.size(); i++) {
//                        System.out.print((i+1) + "°_ "+ razaPerros[i]);
//                }
//                
//                int j = leer.nextInt() - 1;
//                razaPerros.remove(j);

                /*
2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.
                 */
                System.out.print("\nIngrese la raza de perro a buscar: ");
                String raza = leerStr.nextLine();
                Iterator<String> it = razaPerros.iterator();
                boolean b = false;
                while (it.hasNext()) {
                        if (it.next().equalsIgnoreCase(raza)) {
                                it.remove();
                                b = true;
                        }
                }
                
                if (!b) {
                        System.err.println("el perro no se encuentra en la lista");
                }
                System.out.println("");
                
                Collections.sort(razaPerros);
                
//                it = razaPerros.iterator();
//                while (it.hasNext()) {
//                        System.out.println("    *" + it.next());
//                }
                for (String cadena : razaPerros) {
                        System.out.println("    *" + cadena);
                }
        }
}

/*public static void main(String[] args) {
        ArrayList<String> razaPerro = new ArrayList();
        Scanner leer = new Scanner(System.in);
        // Agregamos la raza en un bucle
        boolean opcion = true;
        do {
            System.out.println("Ingrese una raza de perro: ");
            razaPerro.add(leer.next());
            System.out.println("Desea seguir agregando razas? S/N");
            String respuesta = leer.next();
            if (respuesta.equalsIgnoreCase("N")) {
                opcion = false;
            }
        } while (opcion);

//        for (String razas : razaPerro) {
//            System.out.println(razas);
//        }
        System.out.println(razaPerro.toString());
System.out.println("Igrese un perro a borrar: ");
        String aux = leer.next();
        Iterator it = razaPerro.iterator();
        boolean comp = true;
        while (it.hasNext()){
            if (it.next().equals(aux)) {
                it.remove();
                comp = false;
            } 
        }
        if (comp){
                System.out.println("No se encontro esa raza ");
               
        }
        
        Collections.sort(razaPerro);
        
        System.out.println(razaPerro.toString());
    }
}
*/

