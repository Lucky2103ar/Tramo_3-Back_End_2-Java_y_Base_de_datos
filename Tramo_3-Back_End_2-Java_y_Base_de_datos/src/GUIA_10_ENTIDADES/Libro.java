/*
Para ello, se debe crear una clase llamada Libro que guarde la
información de cada uno de los libros de una Biblioteca. La clase Libro debe guardar
el título del libro, autor, número de ejemplares y número de ejemplares prestados.
La clase Librería contendrá además los siguientes métodos:
• Constructor por defecto.
• Constructor con parámetros.
• Métodos Setters/getters
• Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al
método. El método se incrementa de a uno, como un carrito de compras, el
atributo ejemplares prestados, del libro que ingresó el usuario. Esto sucederá
cada vez que se realice un préstamo del libro. No se podrán prestar libros de los
que no queden ejemplares disponibles para prestar. Devuelve true si se ha
podido realizar la operación y false en caso contrario.
• Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se
lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método.
El método decrementa de a uno, como un carrito de compras, el atributo
ejemplares prestados, del libro seleccionado por el usuario. Esto sucederá cada
vez que se produzca la devolución de un libro. No se podrán devolver libros
donde que no tengan ejemplares prestados. Devuelve true si se ha podido
realizar la operación y false en caso contrario.
• Método toString para mostrar los datos de los libros.
 */
package GUIA_10_ENTIDADES;

/*
* Lucky2103ar
 */
public class Libro {

        //  • ENTIDADES
        private String titulo;
        private String autor;
        private Integer ejemplares;
        private Integer prestados;

        // • Constructor por defecto.
        public Libro() {
        }

        // • Constructor con parámetros.
        public Libro(String titulo, String autor, Integer ejemplares) {
                this.titulo = titulo;
                this.autor = autor;
                this.ejemplares = ejemplares;
                this.prestados = 0; // Asumo que al crear el objeto no tengo ningún libro prestado.
        }

        // • Métodos Setters/getters
        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getAutor() {
                return autor;
        }

        public void setAutor(String autor) {
                this.autor = autor;
        }

        public Integer getEjemplares() {
                return ejemplares;
        }

        public void setEjemplares(Integer ejemplares) {
                this.ejemplares = ejemplares;
        }

        public Integer getPrestados() {
                return prestados;
        }

        public void setPrestados(Integer prestados) {
                this.prestados = prestados;
        }

//        • Método prestamo(): El usuario ingresa el titulo del libro que quiere prestar y se lo
//        busca en el conjunto. Si está en el conjunto, se llama con ese objeto Libro al
//        método. El método se incrementa de a uno, como un carrito de compras, el
//        atributo ejemplares prestados, del libro que ingresó el usuario. Esto sucederá
//        cada vez que se realice un préstamo del libro. No se podrán prestar libros de los
//        que no queden ejemplares disponibles para prestar. Devuelve true si se ha
//        podido realizar la operación y false en caso contrario.
        public boolean prestamo(Libro libroPrestado) {
                if (libroPrestado.getEjemplares() > libroPrestado.getPrestados()) {
                        libroPrestado.setPrestados(libroPrestado.getPrestados() + 1);
                        return true;
                }
                return false;
        }

//        • Método devolucion(): El usuario ingresa el titulo del libro que quiere devolver y se
//        lo busca en el conjunto. Si está en el conjunto, se llama con ese objeto al método.
//        El método decrementa de a uno, como un carrito de compras, el atributo
//        ejemplares prestados, del libro seleccionado por el usuario. Esto sucederá cada
//        vez que se produzca la devolución de un libro. No se podrán devolver libros
//        donde que no tengan ejemplares prestados. Devuelve true si se ha podido
//        realizar la operación y false en caso contrario.
               public boolean devolucion(Libro libroDevuelto) {
                if (libroDevuelto.getPrestados() > 0) {
                        libroDevuelto.setPrestados(libroDevuelto.getPrestados() - 1);
                        return true;
                }
                return false;
        } 
        
        // • Método toString
        @Override
        public String toString() {
                return "Título: " + titulo + " || Autor: " + autor + " || Número de ejemplares: " + ejemplares + " || Ejemplares prestados: " + prestados;
        }

}
