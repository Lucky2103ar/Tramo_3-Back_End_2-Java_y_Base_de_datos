/*
4. Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas
geométricas, en este caso un círculo y un rectángulo. Ya que este cálculo se va a repetir en las
dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
dos métodos para calcular el área, el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el
resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package GUIA_12;

import GUIA_12_ENTIDADES.Circulo;
import GUIA_12_ENTIDADES.Rectangulo;

/*
* Lucky2103ar
 */
public class Ejercicio_04_Calcular_area_y_perimetro_con_Interfaz {

        public static void main(String[] args) {
//                En el main se crearán las formas y se mostrará el resultado final.
                Circulo circulo = new Circulo(5);
                Rectangulo rectangulo = new Rectangulo(5, 3);
                /*      Quiero que el resultado de los cálculos se muestre solamente con 2 decimales. Para ello tengo 2 métodos.        */

                //      1º Método:
//                System.out.println("El área del círculo es: " + Math.round(circulo.calcularArea() * 100) / 100f);
                // Math.round devuelve un entero, por eso hago que el denomidador sea tipo float.
                
                //      2º Método:
                System.out.println("El área del círculo es: " + String.format("%.2f", circulo.calcularArea()));
                System.out.println("El perímitro del círculo es: " + String.format("%.2f", circulo.calcularPerimetro()));
                System.out.println("El area del rectángulo es de " + String.format("%.2f", circulo.calcularArea()));
                System.out.println("El perímetro del rectángulo es de " + String.format("%.2f", circulo.calcularPerimetro()));
        }
}
