/*
A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
además de los atributos heredados.

Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
llamar al constructor de la clase padre.
 */
package GUIA_12_ENTIDADES;

import java.util.Scanner;

/*
* Lucky2103ar
 */

public class Lavadora extends Electrodomestico {
//        A continuación, se debe crear una subclase llamada Lavadora, con el atributo carga,
//        además de los atributos heredados.
        protected Float carga;

//        Los constructores que se implementarán serán:
//        • Un constructor vacío.
//        • Un constructor con la carga y el resto de los atributos heredados. Recuerda que debes
//        llamar al constructor de la clase padre.
        public Lavadora() {
        }

        public Lavadora(Float carga, Float precio, String color, Character consumoEnergetico, Float peso) {
                super(precio, color, consumoEnergetico, peso);
                this.carga = carga;
        }

//        Los métodos que se implementara serán:
//        • Método get y set del atributo carga.        
        public Float getCarga() {
                return carga;
        }

        public void setCarga(Float carga) {
                this.carga = carga;
        }

        @Override
        public String toString() {
                return super.toString() +  "\ncarga= " + carga + "Kg"; //To change body of generated methods, choose Tools | Templates.
        }


}
