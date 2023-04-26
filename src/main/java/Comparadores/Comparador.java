/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comparadores;

import Paises.Pais;
import java.util.Comparator;

/**
 *
 * @author LizzW
 */
public class Comparador {
    public static Comparator<Pais> ordenarDesc = new  Comparator<Pais>(){
        @Override
        public int compare(Pais o1, Pais o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }
        
    };
}
