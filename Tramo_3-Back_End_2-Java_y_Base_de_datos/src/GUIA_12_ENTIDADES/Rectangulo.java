//Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
//calcule el área y el perímetro de los dos.
package GUIA_12_ENTIDADES;

import GUIA_12_INTERFACES.calculosFormas;

public class Rectangulo implements calculosFormas {

        private Float base;
        private Float altura;

        public Rectangulo() {
        }

        public Rectangulo(float base, float altura) {
                this.base = base;
                this.altura = altura;
        }

        public float getBase() {
                return base;
        }

        public void setBase(float base) {
                this.base = base;
        }

        public float getAltura() {
                return altura;
        }

        public void setAltura(float altura) {
                this.altura = altura;
        }

//        Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
        @Override
        public float calcularArea() {
                return base * altura;

        }

        @Override
        public float calcularPerimetro() {
                return (base + altura) * 2;
        }

}
