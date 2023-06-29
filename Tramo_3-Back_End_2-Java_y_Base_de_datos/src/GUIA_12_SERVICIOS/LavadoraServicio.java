/*
Los métodos que se implementara serán:
• Método get y set del atributo carga.
• Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
el atributo propio de la lavadora.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
carga es menor o igual, no se incrementará el precio. Este método debe llamar al
método padre y añadir el código necesario. Recuerda que las condiciones que hemos
visto en la clase Electrodoméstico también deben afectar al precio.
 */
package GUIA_12_SERVICIOS;

import GUIA_12_ENTIDADES.Electrodomestico;
import GUIA_12_ENTIDADES.Lavadora;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class LavadoraServicio extends ElectrodomesticoServicio {

//        • Método crearLavadora (): este método llama a crearElectrodomestico() de la clase
//        padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//        el atributo propio de la lavadora.        
        public Lavadora crearLavadora() {
                System.out.println("\n\tLAVADORA\n\t========");
                Electrodomestico electro = super.crearElectrodomestico();
                System.out.print("Ingrese la capacidad de carga (Kg): ");
                float carga = leer.nextFloat();
                return new Lavadora(carga, electro.getPrecio(), electro.getColor(), electro.getConsumoEnergetico(), electro.getPeso());
        }

//        • Método precioFinal(): este método será heredado y se le sumará la siguiente
//        funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500, si la
//        carga es menor o igual, no se incrementará el precio. Este método debe llamar al
//        método padre y añadir el código necesario. Recuerda que las condiciones que hemos
//        visto en la clase Electrodoméstico también deben afectar al precio.
        public void precioFinal(Lavadora lavadora) {
                super.precioFinal(lavadora);
                if (lavadora.getCarga() > 30f) {
                        lavadora.setPrecio(lavadora.getPrecio() + 500);
                }
        }

}
