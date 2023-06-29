/*
Los métodos a implementar son:
• Métodos getters y setters de todos los atributos.
• Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
objeto y no será visible.
• Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
minúsculas. Este método se invocará al crear el objeto y no será visible.
• Metodo crearElectrodomestico(): le pide la información al usuario y llena el
electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
precio se le da un valor base de $1000.
• Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
precio. Esta es la lista de precios:

LETRA	PRECIO                  PESO	PRECIO
A	 $1000                 Entre 1 y 19 kg         $100
B	 $800                   Entre 20 y 49 kg	 $500
C	 $600                   Entre 50 y 79 kg	 $800
D	 $500                   Mayor que 80 kg	 $1000
E	 $300
F	 $100
 */
package GUIA_12_SERVICIOS;

import GUIA_12_ENTIDADES.Electrodomestico;
import java.util.Scanner;

/*
* Lucky2103ar
 */
public class ElectrodomesticoServicio {
         // leer va a ser heredado a los hijos.
        protected Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

//        • Método comprobarConsumoEnergetico(char letra): comprueba que la letra es correcta,
//        sino es correcta usara la letra F por defecto. Este método se debe invocar al crear el
//        objeto y no será visible.
        private char comprobarConsumoEnergetico(char letra) {
//                if (letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F') {
                if (letra >= 'A' && letra <= 'F') {
                        return letra; // Retorna la letra ingresada, si ésta es válida.
                }
                return 'F'; // Retorna F si la letra ingresada NO es válida.
        }

//        • Método comprobarColor(String color): comprueba que el color es correcto, y si no lo es,
//        usa el color blanco por defecto. Los colores disponibles para los electrodomésticos son
//        blanco, negro, rojo, azul y gris. No importa si el nombre está en mayúsculas o en
//        minúsculas. Este método se invocará al crear el objeto y no será visible.
        private String comprobarColor(String color) {
                if (color.equalsIgnoreCase("Blanco") || color.equalsIgnoreCase("Negro")
                        || color.equalsIgnoreCase("Rojo") || color.equalsIgnoreCase("Azul")
                        || color.equalsIgnoreCase("Gris")) {
                        return color; // Retorna el color ingresado, si éste es válido.
                }
                return "Blanco"; // Retorna Blanco si el color ingresado NO es válido.
        }

//        • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//        electrodoméstico, también llama los métodos para comprobar el color y el consumo. Al
//        precio se le da un valor base de $1000.
        public Electrodomestico crearElectrodomestico() {
                System.out.print("Ingrese el precio (valor base $1000): ");
                float precio = comprobarValor(leer.nextFloat());
                System.out.print("Ingrese el color: ");
                String color = comprobarColor(leer.next());
                System.out.print("Ingrese el consumo energético (A,B,C,D,E,F): ");
                char consumoEnergetico = comprobarConsumoEnergetico(Character.toUpperCase(leer.next().charAt(0)));
                System.out.print("Ingrese el peso (Kg): ");
                float peso = leer.nextFloat();
                return new Electrodomestico(precio, color, consumoEnergetico, peso);
        }

//        • Método precioFinal(): según el consumo energético y su tamaño, aumentará el valor del
//        precio. Esta es la lista de precios:
//
//        LETRA         PRECIO                  PESO                    PRECIO
//             A                $1000                 Entre 1 y 19 kg           $100
//             B                $800                   Entre 20 y 49 kg         $500
//             C                $600                   Entre 50 y 79 kg         $800
//             D                $500                   Mayor que 80 kg        $1000
//             E                $300
//             F                $100
        // private void precioFinal() {
        // seria private si usase el método dentro del servicio, por ejemplo llamandolo desde crearElectrodomestico()
        public void precioFinal(Electrodomestico electro) {
                switch (electro.getConsumoEnergetico()) {
                        case 'A':
                                electro.setPrecio(electro.getPrecio() + 1000); // precio = precio + 1000
                                break;
                        case 'B':
                                electro.setPrecio(electro.getPrecio() + 800);
                                break;
                        case 'C':
                                electro.setPrecio(electro.getPrecio() + 600);
                                break;
                        case 'D':
                                electro.setPrecio(electro.getPrecio() + 500);
                                break;
                        case 'E':
                                electro.setPrecio(electro.getPrecio() + 300);
                                break;
                        case 'F':
                                electro.setPrecio(electro.getPrecio() + 100);
                                break;
                }

//                switch ( (1 <= peso && peso < 20) ? 1 : (20<=peso && peso < 50) ? 2 : peso < 80 ? 3 : 4 )
//                creo que los () no son necesarios por una cuestion de prioridad de operadores
                switch (1 <= electro.getPeso() && electro.getPeso() < 20 ? 1 : electro.getPeso() < 50 ? 2 : electro.getPeso() < 80 ? 3 : 4) {
                        case 1:
                                electro.setPrecio(electro.getPrecio() + 100); // precio = precio + 100
                                break;
                        case 2:
                                electro.setPrecio(electro.getPrecio() + 500);
                                break;
                        case 3:
                                electro.setPrecio(electro.getPrecio() + 800);
                                break;
                        case 4:
                                electro.setPrecio(electro.getPrecio() + 1000);
                                break;
                }
        }

        // Metodos auxiliares
        public float comprobarValor(float valor) {
                if (valor >= 1000f) {
                        return valor; // Retorna el valor ingresado, si éste es válido.
                }
                return 1000f; // Retorna 1000 si el valor ingresado es menor al valor base.
        }
}
