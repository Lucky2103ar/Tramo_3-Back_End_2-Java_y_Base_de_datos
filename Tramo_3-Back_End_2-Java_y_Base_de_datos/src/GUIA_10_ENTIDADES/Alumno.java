/*
3. Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
 */

package GUIA_10_ENTIDADES;

import java.util.ArrayList;

/*
* Lucky2103ar
*/
public class Alumno {
        // ATRIBUTOS
        private String nombre;
        private ArrayList<Float> notas = new ArrayList();
        
        // CONSTRUCTORES
        public Alumno() {
        }

        public Alumno(String nombre, ArrayList<Float> notas) {
                this.nombre = nombre;
                this.notas = notas;
        }
        
        // GETTERS y SETTERS

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public ArrayList<Float> getNotas() {
                return notas;
        }

        public void setNotas(ArrayList<Float> notas) {
                this.notas = notas;
        }

        @Override
        public String toString() {
                return "Alumno{" + "nombre=" + nombre + ", notas=" + notas + '}';
        }
}

