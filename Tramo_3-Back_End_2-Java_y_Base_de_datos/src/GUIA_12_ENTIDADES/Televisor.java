/*
Se debe crear también una subclase llamada Televisor con los siguientes atributos:
resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
heredados.

Los constructores que se implementarán serán:
• Un constructor vacío.
• Un constructor con la resolución, sintonizador TDT y el resto de los atributos
heredados. Recuerda que debes llamar al constructor de la clase padre.
 */
package GUIA_12_ENTIDADES;

/*
* Lucky2103ar
 */
public class Televisor extends Electrodomestico {

//        Se debe crear también una subclase llamada Televisor con los siguientes atributos:
//        resolución (en pulgadas) y sintonizador TDT (booleano), además de los atributos
//        heredados.
        protected Integer resolucion;
        protected Boolean sintonizadorTDT;

//        Los constructores que se implementarán serán:
//        • Un constructor vacío.
//        • Un constructor con la resolución, sintonizador TDT y el resto de los atributos
//        heredados. Recuerda que debes llamar al constructor de la clase padre.
        public Televisor() {
        }

        public Televisor(Integer resolucion, Boolean sintonizadorTDT, Float precio, String color, Character consumoEnergetico, Float peso) {
                super(precio, color, consumoEnergetico, peso);
                this.resolucion = resolucion;
                this.sintonizadorTDT = sintonizadorTDT;
        }

//        Los métodos que se implementara serán:
//        • Método get y set de los atributos resolución y sintonizador TDT.
        public Integer getResolucion() {
                return resolucion;
        }

        public void setResolucion(Integer resolucion) {
                this.resolucion = resolucion;
        }

        public Boolean getSintonizadorTDT() {
                return sintonizadorTDT;
        }

        public void setSintonizadorTDT(Boolean sintonizadorTDT) {
                this.sintonizadorTDT = sintonizadorTDT;
        }

        @Override
        public String toString() {
                return super.toString() + "\nresolución= " + resolucion + "\""+ "\nsintonizadorTDT= " + sintonizadorTDT;
        }

}
