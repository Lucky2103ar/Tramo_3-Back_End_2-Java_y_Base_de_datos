/*
2. Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color,
consumo energético (letras entre A y F) y peso.

Los constructores que se deben implementar son los siguientes:
• Un constructor vacío.
• Un constructor con todos los atributos pasados por parámetro.
 */
package GUIA_12_ENTIDADES;

public class Electrodomestico {

//        Crear una superclase llamada Electrodoméstico con los siguientes atributos: precio, color,
//        consumo energético (letras entre A y F) y peso.
        protected Float precio;
        protected String color;
        protected Character consumoEnergetico;
        protected Float peso;

//        Los constructores que se deben implementar son los siguientes:
//        • Un constructor vacío.
//        • Un constructor con todos los atributos pasados por parámetro.
        public Electrodomestico() {
        }

        public Electrodomestico(Float precio, String color, Character consumoEnergetico, Float peso) {
                this.precio = precio;
                this.color = color;
                this.consumoEnergetico = consumoEnergetico;
                this.peso = peso;
        }

//        Los métodos a implementar son:
//        • Métodos getters y setters de todos los atributos.
        public Float getPrecio() {
                return precio;
        }

        public void setPrecio(Float precio) {
                this.precio = precio;
        }

        public String getColor() {
                return color;
        }

        public void setColor(String color) {
                this.color = color;
        }

        public Character getConsumoEnergetico() {
                return consumoEnergetico;
        }

        public void setConsumoEnergetico(Character consumoEnergetico) {
                this.consumoEnergetico = consumoEnergetico;
        }

        public Float getPeso() {
                return peso;
        }

        public void setPeso(Float peso) {
                this.peso = peso;
        }

        // Override
        @Override
        public String toString() {
                return "Electrodomestico" + "\nprecio= $" + precio + "\ncolor= " + color + "\nconsumoEnergetico= " + consumoEnergetico + "\npeso= " + peso + "Kg";
        }

}
