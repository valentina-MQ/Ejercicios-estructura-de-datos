package taller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;

public class Repetidos {
    
    public static void eliminarR(Stack<Integer> pila, Queue<Integer> cola, int dato, int contador) {
        // Caso base: si la pila está vacía, imprimir la cola y pila
        if (pila.isEmpty()) {
            System.out.println("Elementos extraídos (cola): " + cola);
            System.out.println("Total de elementos extraídos: " + contador);
            return;
        }
        
        int elemento = pila.pop();
        if (elemento == dato) {
            cola.offer(elemento);
            contador++;
        } else {
            eliminarR(pila, cola, dato, contador);
            pila.push(elemento); // Restaurar el elemento si no es igual al dato
            return;
        }
        
        eliminarR(pila, cola, dato, contador);
    }
    
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Queue<Integer> cola = new LinkedList<>();
        Random random = new Random();
        
        // Llenamos la pila con valores random
        for (int i = 0; i < 11; i++) {
            pila.push(random.nextInt(11)); // Números aleatorios entre 0 y 10
        }
        
        System.out.println("Pila incial: " + pila);
        
        int dato = random.nextInt(11); // Número aleatorio a eliminar
        System.out.println("Número a eliminar: " + dato);
        eliminarR(pila, cola, dato, 0);
        System.out.println("Pila después del proceso: " + pila);
    }
}
