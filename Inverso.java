package taller;

import java.util.LinkedList;
import java.util.Queue;

public class Invertir {

    // Función recursiva que invierte la cola sin eliminar datos
    public static void invertir(Queue<Integer> cola) {
        if (cola.isEmpty()) return; // Caso base

        int frente = cola.poll(); // Extrae el primer elemento
        invertir(cola); // Llamada recursiva
        cola.add(frente); // Reinsertamos el elemento al final
    }

    //Se agregan los elementos de la cola
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(1);
        cola.add(2);
        cola.add(3);

        
        System.out.println("Cola inicial: " + cola);

        invertir(cola);
        
        System.out.println("Cola invertida: " + cola);
    }
}
