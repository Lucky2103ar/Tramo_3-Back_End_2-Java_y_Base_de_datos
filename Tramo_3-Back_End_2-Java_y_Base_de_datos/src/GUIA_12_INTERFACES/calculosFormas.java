//Ya que este cálculo se va a repetir en las
//dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
//dos métodos para calcular el área, el perímetro y el valor de PI como constante.
package GUIA_12_INTERFACES;

public interface calculosFormas {

        final float PI = (float) Math.PI;

        public float calcularArea();

        public float calcularPerimetro();

}
