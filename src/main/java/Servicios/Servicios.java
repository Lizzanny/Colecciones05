/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Comparadores.Comparador;
import Paises.Pais;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author LizzW
 * 
 *
 * Se requiere un programa que lea y guarde países, y para evitar que se
 * ingresen repetidos usaremos un conjunto. El programa pedirá un país en un
 * bucle, se guardará el país en el conjunto y después se le preguntará al
 * usuario si quiere guardar otro país o si quiere salir, si decide salir, se
 * mostrará todos los países guardados en el conjunto. (Recordemos hacer los
 * servicios en la clase correspondiente) Después deberemos mostrar el conjunto
 * ordenado alfabéticamente: para esto recordar cómo se ordena un conjunto. Por
 * último, al usuario se le pedirá un país y se recorrerá el conjunto con un
 * Iterator, se buscará el país en el conjunto y si está en el conjunto se
 * eliminará el país que ingresó el usuario y se mostrará el conjunto. Si el
 * país no se encuentra en el conjunto se le informará al usuario.
 */
public class Servicios {
    private final Scanner sc;
    HashSet<Pais> paises;

    public Servicios() {
        this.sc = new Scanner(System.in).useDelimiter("\n");
        this.paises = new HashSet<>();
    }
    
    
    
    public void agregarPais(){
        System.out.println("Ingrese el nombre del pais");
        String nombre = sc.next();
        paises.add(new Pais(nombre));
    }
    
    public void imprimirTodos(){
        for (Pais pais_ : paises) {
             System.out.println(pais_.getNombre());
        }
    }
    
    public void buscarEliminar() {
        System.out.println("Ingrese el nombre del pais a eliminar");
        String paisEliminar = sc.next();
        boolean aux = false;
        
        Iterator<Pais> it = paises.iterator();
        while (it.hasNext()) {
            if (it.next().getNombre().equals(paisEliminar)) { // Si se cumple la condicion de encontrar "Ese apellido elegido,lo elimina)
                it.remove();
                aux=true;
            }
        }
        if(!aux){
                System.out.println("El país no se encuentra en el conjunto");
            }
    }
    
    public void ordenarNombre(){
        ArrayList<Pais> listaPaises = new ArrayList(paises);
        Collections.sort(listaPaises, Comparador.ordenarDesc);
        for (Pais listaPaise : listaPaises) {
            System.out.println(listaPaise.getNombre());
        }
    }
    
    public void menu(){
        boolean salir=false;
        do{
            System.out.print("¿Que acción deseas realizar? \n"
            +"1. Crear país\n"
            +"2. Listar paises\n"
            +"3. Eliminar país\n"
            +"4. Ordenar lista\n"
            +"5. Salir\n"
            +"Opción: ");
            
            switch (sc.nextInt()) {
                case 1 -> //Crear alumno
                    agregarPais();
                case 2 -> //Mostrar lista alumnos
                    imprimirTodos();
                case 3 -> {
                    buscarEliminar();
                }
                case 4 -> {
                    ordenarNombre();
                }
                case 5 -> {
                    //Salir
                    System.out.println("Saliendo... ");
                    salir=true;
                }
                default -> System.out.println("Opción invalida");
            }

        }while(!salir);
    }
}
