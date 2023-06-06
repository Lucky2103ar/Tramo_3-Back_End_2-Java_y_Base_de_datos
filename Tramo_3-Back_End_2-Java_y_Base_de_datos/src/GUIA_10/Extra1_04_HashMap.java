/*
4. Almacena en un HashMap los códigos postales de 10 ciudades a elección de esta
página: https://mapanet.eu/index.htm. Nota: Poner el código postal sin la letra, solo el
numero.
• Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
• Muestra por pantalla los datos introducidos
• Pide un código postal y muestra la ciudad asociada si existe sino avisa al
usuario.
• Muestra por pantalla los datos
• Agregar una ciudad con su código postal correspondiente más al HashMap.
• Elimina 3 ciudades existentes dentro del HashMap
 */
package GUIA_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
* Lucky2103ar
 */
public class Extra1_04_HashMap {

        public static void main(String[] args) {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
//                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                char op;

//                • Pedirle al usuario que ingrese 10 códigos postales y sus ciudades.
                HashMap<Integer, String> ciudades = new HashMap();
                System.out.print("¿Desea ingresar los datos en forma manual? (S/N)");
                char resp = Character.toUpperCase(leer.next().charAt(0));
                if (resp == 'S') {
                        for (int i = 0; i < 10; i++) {
                                System.out.println("Ingrese los datos de la " + (i + 1) + "° Ciudad ");
                                agregarCiudad(ciudades);
                        }
                } else {
                        llenadoAutomatico(ciudades);
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                
//                • Muestra por pantalla los datos introducidos
                mostrarDatos(ciudades);
                System.out.println("\n\t\tPresione ENTER para continuar...");
                leer.next();

                do {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        System.out.println("\tMENU");
                        System.out.println("1- Buscar una ciudad por código postal");
                        System.out.println("2- Muestra por pantalla los datos introducidos");
                        System.out.println("3- Muestra por pantalla los datos introducidos (ordenados por la key)");
                        System.out.println("4- Agregar una ciudad");
                        System.out.println("5- Eliminar 3 ciudades existentes dentro del HashMap");
                        System.out.println("S- Salir");
                        System.out.print("\n\t\tElija su opción: ");
                        op = Character.toUpperCase(leer.next().charAt(0));
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        switch (op) {
                                case '1':
                                        pedirCPyMostrarCiudad(ciudades);
                                        break;
                                case '2':
                                        mostrarDatos(ciudades);
                                        break;
                                case '3':
                                        mostrarDatosOrdenados(ciudades);
                                        break;
                                case '4':
                                        agregarCiudad(ciudades);
                                        break;
                                case '5':
                                        eliminar3Ciudades(ciudades);
                                        break;
                                case 'S':
                                        System.out.println("\t¡GRACIAS POR USAR NUESTRO PROGRAMA!");
                                        break;
                                default:
                                        System.err.println("\t\tOPCION NO VALIDA!!!");
                        }

                        System.out.println("\n\t\tPresione ENTER para continuar...");
                        leer.next();
                } while (op != 'S');
        } // FIN DEL MAIN

        private static Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

//        Función auxiliar para el llenado automático del HashMap
        private static void llenadoAutomatico(HashMap<Integer, String> ciudades) {
                ciudades.put(1638, "Vicente López");
                ciudades.put(1661, "Bella Vista");
                ciudades.put(4001, "San Miguel de Tucumán");
                ciudades.put(1659, "Campo de Mayo");
                ciudades.put(4115, "Buena Vista");
                ciudades.put(4168, "Bella Vista");
                ciudades.put(1604, "Florida Oeste");
                ciudades.put(1663, "San Miguel");
                ciudades.put(4000, "San Miguel de Tucumán");
                ciudades.put(1602, "Florida");

//                        Datos adicionales para usar luego
//                        ciudades.put(4105, "Villa Angelina");
//                        ciudades.put(1603, "Villa Martelli");
//                        ciudades.put(4111, "Bajo Grande");
//                        ciudades.put(2752, "Campo La Elisa");
//                        ciudades.put(2753, "La Luisa");
        }

//        • Muestra por pantalla los datos introducidos
        private static void mostrarDatos(HashMap<Integer, String> ciudades) {
                for (Map.Entry<Integer, String> entry : ciudades.entrySet()) {
                        System.out.println("Ciudad: " + entry.getValue() + "\tC.P.:" + entry.getKey());
                }
        }

//        • Muestra por pantalla los datos ORDENADOS
        private static void mostrarDatosOrdenados(HashMap<Integer, String> ciudades) {
                TreeMap<Integer, String> ordenamiento = new TreeMap(ciudades);
                for (Map.Entry<Integer, String> entry : ordenamiento.entrySet()) {
                        System.out.println("Ciudad: " + entry.getValue() + "\tC.P.:" + entry.getKey());
                }
        }

//        • Pide un código postal y muestra la ciudad asociada si existe sino avisa al usuario.
        private static void pedirCPyMostrarCiudad(HashMap<Integer, String> ciudades) {
//                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                System.out.print("Ingrese el CP de la ciudad buscada: ");
                int cp = leer.nextInt();
                if (existeCiudad(ciudades, cp)) {
                        System.out.println("\n\t La ciudad buscada es: " + ciudades.get(cp)); // .get me devuelve el DATO al que apunta la KEY del argumento.
                } else {
                        System.err.println("\n\tNo se encuentra la ciudad buscada!");
                }
        }

        private static boolean existeCiudad(HashMap<Integer, String> ciudades, int cp) {
                for (Map.Entry<Integer, String> entry : ciudades.entrySet()) {
                        if (entry.getKey() == cp) {
                                return true;
                        }
                }
                return false;
        }

//        • Agregar una ciudad con su código postal correspondiente más al HashMap.
        private static void agregarCiudad(HashMap<Integer, String> ciudades) {
//                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                System.out.print("Ingrese el Código Postal: ");
                int cp = leer.nextInt();
                System.out.print("Ingrese la Ciudad: ");
                String ciudad = leer.next().toUpperCase();
                ciudades.put(cp, ciudad);
        }

//        • Elimina 3 ciudades existentes dentro del HashMap
        private static void eliminar3Ciudades(HashMap<Integer, String> ciudades) {
//                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                if (ciudades.size() < 3) {
                        System.err.println("\t\t\t ¡¡¡ERROR!!! \n\t\t EL MAPA TIENE MENOS DE 3 CIUDADES CARGADAS");
                } else {
                        // Este método va a continuar hasta que elimine, SI O SI, 3 ciudades.
                        for (int i = 0; i < 3; i++) {
                                System.out.print("Ingrese el CP de la ciudad que quiere eliminar: ");
                                int cp = leer.nextInt();
                                if (existeCiudad(ciudades, cp)) {
                                        System.out.println("\n\t Eliminando la ciudad de: " + ciudades.get(cp));
                                        ciudades.remove(cp);
                                } else {
                                        System.err.println("\n\tNo se encuentra la ciudad buscada!");
                                        i--; // Si no se encontró la ciudad, entonces tiene que intentar otra vez.
                                }
                        }
                }
        }
}
