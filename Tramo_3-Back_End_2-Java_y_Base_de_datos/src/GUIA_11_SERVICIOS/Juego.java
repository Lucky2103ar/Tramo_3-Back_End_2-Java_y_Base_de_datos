/*
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
Revolver

Métodos:
llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
10
ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package GUIA_11_SERVICIOS;

/*
 * modificado por Lucky
 */
import java.util.ArrayList;

public class Juego {

        private ArrayList<Jugador> jugadores;
        private Revolver revolver;

        public Juego(ArrayList<Jugador> jugadores, Revolver revolver) {
                this.jugadores = jugadores;
                this.revolver = revolver;
        }

//        ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
//        aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
//        moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
//        mojar. Al final del juego, se debe mostrar que jugador se mojó.
//        Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.    
        public void ronda() {
                boolean alguienSeMojO = false;
                do {
                        for (Jugador jugador : jugadores) {
                                System.out.print("\n\t" + jugador.getNombre() + " dispara el revolver.");
                                // Puedo asignarle valor a un variable en la condición lógica
                                if (alguienSeMojO = jugador.disparo(revolver)) {
                                        System.out.println(" ¡Se mojó!\n");
                                        break;
                                } else {
                                        System.out.println(" ¡El agua no salió!");
                                }
                        }
                } while (!alguienSeMojO);
        }
}
