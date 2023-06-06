/*
Esta clase guardará cantantes famosos y
tendrá como atributos el nombre y discoConMasVentas.
 */

package GUIA_10_ENTIDADES;

/*
* Lucky2103ar
*/
public class CantanteFamoso {
        // ATRIBUTOS
        private String nombre;
        private String discoConMasVentas;
        
        // CONSTRUCTORES
        public CantanteFamoso() {
        }

        public CantanteFamoso(String nombre, String discoConMasVentas) {
                this.nombre = nombre;
                this.discoConMasVentas = discoConMasVentas;
        }
        
        // SETTERS y GETTERS 
        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getDiscoConMasVentas() {
                return discoConMasVentas;
        }

        public void setDiscoConMasVentas(String discoConMasVentas) {
                this.discoConMasVentas = discoConMasVentas;
        }

        @Override
        public String toString() {
                return "Nombre del Artista: " + nombre + "\t\tSu disco con más ventas es: " + discoConMasVentas;
        }
}
