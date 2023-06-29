
package GUIA_12;

import GUIA_12_ENTIDADES.Animal;
import GUIA_12_ENTIDADES.Caballo;
import GUIA_12_ENTIDADES.Gato;
import GUIA_12_ENTIDADES.Perro;

public class Ejercicio_01_Crear_una_clase_padre_Animal {

    public static void main(String[] args) {
        Animal perro1 = new Perro("Stich", "Carnivoro", 15, "Doberman");

        perro1.Alimentarse();

        //Declaración de otro objeto Perro
        Animal perro2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");

        perro2.Alimentarse();

        //Declaración del objeto Gato
        Animal gato1 = new Gato("Pelusa", "Galletas", 15, "Siamés");

        gato1.Alimentarse();

        //Declaración del objeto Caballo
        Animal caballo1 = new Caballo("Spark", "Pasto", 25, "Fino");

        caballo1.Alimentarse();
    }
}