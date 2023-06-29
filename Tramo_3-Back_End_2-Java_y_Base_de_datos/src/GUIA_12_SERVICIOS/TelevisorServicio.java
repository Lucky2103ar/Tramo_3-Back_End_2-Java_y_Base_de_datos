/*
Los métodos que se implementara serán:
• Método get y set de los atributos resolución y sintonizador TDT.
• Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
los atributos del televisor.
• Método precioFinal(): este método será heredado y se le sumará la siguiente
funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
$500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
también deben afectar al precio.
 */
package GUIA_12_SERVICIOS;

import GUIA_12_ENTIDADES.Electrodomestico;
import GUIA_12_ENTIDADES.Televisor;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class TelevisorServicio extends ElectrodomesticoServicio {

//        • Método crearTelevisor(): este método llama a crearElectrodomestico() de la clase
//        padre, lo utilizamos para llenar los atributos heredados del padre y después llenamos
//        los atributos del televisor.
        public Televisor crearTelevisor() {
                System.out.println("\n\tTELEVISOR\n\t=========");
                Electrodomestico electro = super.crearElectrodomestico();
                System.out.print("Ingrese la resolución (en pulgadas): ");
                int resolucion = leer.nextInt();
                System.out.print("Posee sintonizador TDT (s/n): ");
                char resp = Character.toUpperCase(leer.next().charAt(0));
                return new Televisor(resolucion, resp == 'S', electro.getPrecio(), electro.getColor(), electro.getConsumoEnergetico(), electro.getPeso());
        }

//        • Método precioFinal(): este método será heredado y se le sumará la siguiente
//        funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//        incrementará el precio un 30% y si tiene un sintonizador TDT incorporado, aumentará
//        $500. Recuerda que las condiciones que hemos visto en la clase Electrodomestico
//        también deben afectar al precio.
        public void precioFinal(Televisor televisor) {
                if (televisor.getResolucion() > 40) {
                        televisor.setPrecio(televisor.getPrecio() * 1.3f);
                }
                if (televisor.getSintonizadorTDT()) {
                        televisor.setPrecio(televisor.getPrecio() + 500);
                }
                super.precioFinal(televisor);
        }

}
