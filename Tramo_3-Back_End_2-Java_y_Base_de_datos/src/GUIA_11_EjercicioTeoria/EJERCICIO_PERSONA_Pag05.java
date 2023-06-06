/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package GUIA_11_EjercicioTeoria;

import GUIA_11_ENTIDADES.Dni;
import GUIA_11_ENTIDADES.Persona;

/**
 *
 * @author Lenovo
 */
public class EJERCICIO_PERSONA_Pag05 {

    public static void main(String[] args) {
        
       Persona persona = new Persona();
       Dni documento = new Dni();
       persona.setNombre("jose");
       persona.setApellido("sarasa");
       persona.setDni(documento);
       documento.setSerie("abcd");
       documento.setNumero(97978787);
       
        System.out.println(persona.getNombre()+" "+persona.getApellido()+ " " + persona.getDni().toString());
    }
}
