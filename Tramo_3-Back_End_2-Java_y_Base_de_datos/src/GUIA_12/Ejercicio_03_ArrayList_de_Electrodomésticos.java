/*
3. Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
precio de todos los Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de
2000 y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
electrodomésticos, 2000 para lavadora y 5000 para televisor.
 */
package GUIA_12;

import GUIA_12_ENTIDADES.Electrodomestico;
import GUIA_12_ENTIDADES.Lavadora;
import GUIA_12_ENTIDADES.Televisor;
import GUIA_12_SERVICIOS.LavadoraServicio;
import GUIA_12_SERVICIOS.TelevisorServicio;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author Lucky2103
 */
public class Ejercicio_03_ArrayList_de_Electrodomésticos {

        public static void main(String[] args) {
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                LavadoraServicio LavServ = new LavadoraServicio();
                Lavadora lavadora = new Lavadora();
                TelevisorServicio TVServ = new TelevisorServicio();
                Televisor televisor = new Televisor();

//        3. Siguiendo el ejercicio anterior, en el main vamos a crear un ArrayList de Electrodomésticos
//        para guardar 4 electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
                ArrayList<Electrodomestico> listElectros = new ArrayList();
                char resp;
                for (int i = 0; i < 4; i++) {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        System.out.print("Qué electrodoméstico desea agregar (L/T): ");
                        resp = Character.toUpperCase(leer.next().charAt(0));
                        switch (resp) {
                                case 'L':
                                        lavadora = LavServ.crearLavadora();        // CREO EL OBJETO
                                        listElectros.add(lavadora);                         // AGREGO EL OBJETO COMO ELEMENTO DEL ARRAYLIST
                                        break;
                                case 'T':
                                        televisor = TVServ.crearTelevisor();
                                        listElectros.add(televisor);
                                        break;
                                default:
                                        System.out.println("Respuesta incorrecta...");
                                        i--;    // AL SER UNA ELECCION INCORRECTA NO SE DEBE CONTAR LA VUELTA
                        }
                        System.out.println("\n\t\t\t\t\tPresione ENTER para continuar...");
                        leer.next();
                }

//        Luego, recorrer este array y ejecutar el método precioFinal() en cada electrodoméstico. Se
//        deberá también mostrar el precio de cada tipo de objeto, es decir, el precio de todos los
//        televisores y el de las lavadoras. Una vez hecho eso, también deberemos mostrar, la suma del
//        precio de todos los Electrodomésticos.
                float sumaPrecio = 0;
                int indiceLav = 1;
                int indiceTV = 1;
                for (Electrodomestico electro : listElectros) { // recorrer este array
                        if (electro instanceof Lavadora) {              // PREGUNTO SI ES UNA LAVADORA
                                LavServ.precioFinal(electro);   // ejecutar el método precioFinal() en cada electrodoméstico
                                System.out.println("El precio final de la " + indiceLav++
                                        + "º Lavadora es: $" + electro.getPrecio());     // Se deberá también mostrar el precio de cada tipo de objeto
                        }
                        if (electro instanceof Televisor) {             // PREGUNTO SI ES UN TELEVISOR
                                TVServ.precioFinal(electro);    // ejecutar el método precioFinal() en cada electrodoméstico
                                System.out.println("El precio final del " + indiceTV++
                                        + "º Televisor es: $" + electro.getPrecio());     // Se deberá también mostrar el precio de cada tipo de objeto
                        }
                        sumaPrecio += electro.getPrecio();              // SUMO EL PRECIO DE TODOS LOS ELECTRODOMESTICOS
                }
                System.out.println("\nEl precio total de TODOS los electrodomésticos es: $"
                        + sumaPrecio);  // deberemos mostrar, la suma del precio de todos los Electrodomésticos.
        }

}
