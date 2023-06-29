//Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
//calcule el área y el perímetro de los dos.
package GUIA_12_ENTIDADES;

import GUIA_12_INTERFACES.calculosFormas;

public class Circulo implements calculosFormas {

        private Float radio;
        private Float diametro;

        public Circulo() {
        }

        public Circulo(float radio) {
                this.radio = radio;
                this.diametro = radio*2;
        }

        public float getRadio() {
                return radio;
        }

        public void setRadio(float radio) {
                this.radio = radio;
        }

        public float getDiametro() {
                return diametro;
        }

        public void setDiametro(float diametro) {
                this.diametro = diametro;
        }

//        Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
        @Override
        public float calcularArea() {
                return (PI * (float) Math.pow(radio, 2));

        }

        @Override
        public float calcularPerimetro() {
                return (PI * diametro);
        }

}
