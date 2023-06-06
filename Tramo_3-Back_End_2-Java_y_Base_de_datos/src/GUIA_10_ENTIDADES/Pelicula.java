/*
4. Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
 */
package GUIA_10_ENTIDADES;

import java.util.Comparator;

/*
* Lucky2103ar
 */
public class Pelicula {

        // ATRIBUTOS
        private String titulo;
        private String director;
        private Float duracion;

        // CONSTRUCTORES
        public Pelicula() {
        }

        public Pelicula(String titulo, String director, Float duracion) {
                this.titulo = titulo;
                this.director = director;
                this.duracion = duracion;
        }

        // SETTERS y GETTERS
        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getDirector() {
                return director;
        }

        public void setDirector(String director) {
                this.director = director;
        }

        public Float getDuracion() {
                return duracion;
        }

        public void setDuracion(Float duracion) {
                this.duracion = duracion;
        }

        // MOSTRAR EL OBJETA DE ESTA CLASE
        @Override
        public String toString() {
                return "Pelicula{" + "Título= " + titulo + ", Director= " + director + ", Duración= " + duracion + '}';
        }

        // Crear el método compare de la clase Comparator
        public static Comparator<Pelicula> ordenarXDuracion = new Comparator<Pelicula>() {
                @Override
                public int compare(Pelicula p1, Pelicula p2) {
                        return p2.getDuracion().compareTo(p1.getDuracion());
                }
        };

        public static Comparator<Pelicula> ordenarXTitulo = new Comparator<Pelicula>() {
                @Override
                public int compare(Pelicula p1, Pelicula p2) {
                        return p1.getTitulo().compareTo(p2.getTitulo());
                }
        }; // <=======

        public static Comparator<Pelicula> ordenarXDirector = new Comparator<Pelicula>() {
                @Override
                public int compare(Pelicula p1, Pelicula p2) {
                        return p1.getDirector().compareTo(p2.getDirector());
                }
        };
}
