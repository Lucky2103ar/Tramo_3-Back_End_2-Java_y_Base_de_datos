/*
SARASA VICTORIA
 */
package GUIA_11;

import GUIA_11_SERVICIOS.Jugador;
import GUIA_11_SERVICIOS.Revolver;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Ejercicio_02_Ruleta_rusa_de_agua {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        Revolver revolv = new Revolver();
        
        
        revolv.llenarRevolver();
        System.out.println(revolv);
       
        
        revolv.siguienteChorro();
        System.out.println(revolv);
        
        
        System.out.println("Indique la cantidad de jugadores a participar entre 1 y 6: ");
        int numJugadores = sc.nextInt();
        
        if (numJugadores < 1 || numJugadores > 6) {
            System.out.println("El numero es invalido y se define en 6");
            numJugadores = 6;
        }
        
        Jugador j = new Jugador();
        if (j.disparo(revolv)) {
            System.out.println("Se mojo" + j.getNombre() + " y se termino el juego");
        }
    }
    
}
