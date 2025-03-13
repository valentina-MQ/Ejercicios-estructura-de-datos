package taller;

import java.util.LinkedList;
import java.util.Queue;

public class Eliminar {

    // Función recursiva
    public static void eliminar(Queue<Integer> cola, int dato) {
        if (cola.isEmpty()) return; // Caso base

        int inicio = cola.poll(); // Extrae el primer elemento
        
        eliminar(cola, dato); // Llamada recursiva

        if (inicio != dato) {
            cola.add(inicio); // Vuelve a insertar si no es el eliminado
        }
    }

    // Función recursiva para ordenar la cola después de eliminar el elemento
    public static void ordenar(Queue<Integer> cola) {
        if (cola.isEmpty()) return; // Caso base

        int inicio = cola.poll(); // Extrae el primer elemento
        ordenar(cola); // Llamada recursiva
        cola.add(inicio); // Reinsertamos para mantener el orden original
    }

    //Se agregan los elementos de la cola
    public static void main(String[] args) {
        Queue<Integer> cola = new LinkedList<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);

        

        int datoAEliminar = 4;
        System.out.println("Cola inicial: " + cola);

        eliminar(cola, datoAEliminar);
        ordenar(cola);

        System.out.println("Cola final " + datoAEliminar + ": " + cola);
    }
}
