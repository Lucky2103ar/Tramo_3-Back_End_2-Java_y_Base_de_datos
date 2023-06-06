/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUIA_10;

import java.util.HashMap;

/*
* Lucky2103ar
*/
public class PRUEBAS {
        public static void main(String[] args) {
                                HashMap<Integer, String> ciudades = new HashMap();
                        ciudades.put(1661, "opcion correcta");
                        ciudades.put(4168, "Bella Vista");
                        String aux = ciudades.get(1661);
                        System.out.println(aux);

        }

}
