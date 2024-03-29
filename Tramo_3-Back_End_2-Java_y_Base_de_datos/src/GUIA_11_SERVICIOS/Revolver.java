/*
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
Métodos:

llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
mojar(): devuelve true si la posición del agua coincide con la posición actual
siguienteChorro(): cambia a la siguiente posición del tambor
toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package GUIA_11_SERVICIOS;

//import static java.lang.Math.random;
import java.util.Random;

/**
 *
 * @author Lenovo
 */
public class Revolver {
        // ATRIBUTOS

        private int posAct;
        private int posAgua;

        // CONSTRUCTOR
        public Revolver() {
                llenarRevolver();
        }

        public int getPosAct() {
                return posAct;
        }

        public void setPosAct(int posAct) {
                this.posAct = posAct;
        }

        public int getPosAgua() {
                return posAgua;
        }

        public void setPosAgua(int posAgua) {
                this.posAgua = posAgua;
        }

//        llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
//        deben ser aleatorios.
        public void llenarRevolver() {
                Random rand = new Random(); // Debo hacer ésta declaración para poder usar rand.nextInt(6)
                posAct = rand.nextInt(6) + 1;
                posAgua = rand.nextInt(6) + 1;
}

        //mojar(): devuelve true si la posición del agua coincide con la posición actual
        public boolean mojar() {
                return posAct == posAgua;
        }

        //siguienteChorro(): cambia a la siguiente posición del tambor
        public void siguienteChorro() {
                posAct = (posAct % 6) + 1; // (posAct mod 6) +1. Ej: (5 mod 6) + 1 = 6 / (6 mod 6) + 1 = 1
        }

        //toString(): muestra información del revolver (posición actual y donde está el agua)
        @Override
        public String toString() {
                return "Posicion Actual = " + posAct
                        + "\nPosicion Agua   = " + posAgua;
        }

}
