/*
2. Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de
un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua,
se dispara y se moja. Las clases por hacer del juego son las siguientes:
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */

 /*
 * modificado por Lucky
 */
package GUIA_11;

import GUIA_11_SERVICIOS.Jugador;
import GUIA_11_SERVICIOS.Juego;
import GUIA_11_SERVICIOS.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio_02_Ruleta_rusa_de_agua {

        public static void main(String[] args) {
                ArrayList<Jugador> jugadores = new ArrayList<>();
                Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
                int cantJ;
                do {
                        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // LIMPIAR PANTALLA
                        System.out.print("Ingrese la cantidad de jugadores (de 1 a 6): ");
                        cantJ = leer.nextInt();
                        if (cantJ > 6) {
                                System.out.println("\n\tLa cantidad de jugadores se seteará en 6.");
                                cantJ = 6;
                                System.out.println("\n\tPresione ENTER para continuar...");
                                leer.next();
                        }
                        if (cantJ < 1) {
                                System.out.println("\n\tLa cantidad mínima de jugadores es 1.");
                                System.out.println("\n\tPresione ENTER para continuar...");
                                leer.next();
                        }
                } while (cantJ < 1);

//                jugadores.add(new Jugador(1));
//                jugadores.add(new Jugador(2));
//                jugadores.add(new Jugador(3));
//                jugadores.add(new Jugador(4));
//                jugadores.add(new Jugador(5));
//                jugadores.add(new Jugador(6));
                for (int i = 1; i <= cantJ; i++) {
                        jugadores.add(new Jugador(i));
                }

                Revolver revolver = new Revolver();
//                revolver.llenarRevolver(); // Ya no uso ésta utilidad por que, hora, el contructor llena el revolver.
                System.out.println(revolver.toString()); // Muestro los atributos de revolver para control.

                Juego juego = new Juego(jugadores, revolver);
                juego.ronda();
        }
}
