/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIA_10_SERVICIOS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class PaisServicio {

        private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

        public void agregarPais(HashSet<String> paises) {
                System.out.println("Ingrese el nombre del pais que desea: ");
                String nombre = leer.next().toUpperCase();
                paises.add(nombre);

                System.out.println("Desea ingresar otro pais? :  S/N ");
                String resp = leer.next();

                if (resp.equalsIgnoreCase("s")) {
                        agregarPais(paises);
                }

        }

        //DespuÃ©s deberemos mostrar el conjunto ordenado alfabÃ©ticamente: para esto recordar
//cÃ³mo se ordena un conjunto.
        public void ordenarPaises(HashSet<String> paises) {
                //   TreeSet<String> ordenarPais = new TreeSet(paises);
                ArrayList<String> ordenarPais = new ArrayList(paises);
                Collections.sort(ordenarPais);
                for (String aux : ordenarPais) {
                        System.out.println(aux);
                }
        }

        //Por Ãºltimo, al usuario se le pedirÃ¡ un paÃ­s y se recorrerÃ¡ el conjunto con un Iterator, se
//buscarÃ¡ el paÃ­s en el conjunto y si estÃ¡ en el conjunto se eliminarÃ¡ el paÃ­s que ingresÃ³ el
//usuario y se mostrarÃ¡ el conjunto. Si el paÃ­s no se encuentra en el conjunto se le informarÃ¡
//al usuario.
        public void eliminarPais(HashSet<String> paises) {
                boolean aux = false;

                while (true) {
                        System.out.println("\nDesea eliminar una Pais? Si/No");
                        String res = leer.next();
                        if (res.equalsIgnoreCase("N")) {
                                break;
                        }

                        System.out.println("Ingrese un pais: ");
                        Iterator<String> it = paises.iterator();
                        String resp = leer.next().toUpperCase();

                        while (it.hasNext()) {
                                if (it.next().equals(resp)) {
                                        it.remove();
                                        aux = true;
                                        System.out.println("Pais eliminado.");
                                        break;
                                }
                        }
                        //   break;
                }

        }
}
