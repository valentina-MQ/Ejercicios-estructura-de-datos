package taller;

import java.util.*;

public class Inverso {

    // Paso 1: Verifica si N1 es el inverso de M1
    public static boolean paso1(Stack<Integer> M1, Queue<Integer> N1) {
        if (M1.size() != N1.size()) {
            return false;
        }

        Stack<Integer> tempStack = new Stack<>();
        Queue<Integer> tempQueue = new LinkedList<>(N1);

        // Copiamos los elementos de M1 en una pila auxiliar para no modificarla
        tempStack.addAll(M1);

        while (!tempStack.isEmpty()) {
            if (!tempStack.pop().equals(tempQueue.poll())) {
                return false;
            }
        }
        return true;
    }

    // Paso 2: Crea una cola N1 con los elementos de M1 que no están en M2
    public static Queue<Integer> paso2(Stack<Integer> M1, Stack<Integer> M2) {
        Queue<Integer> N1 = new LinkedList<>();

        for (Integer elementoM1 : M1) {
            boolean encontrado = false;

            // Comparar con cada elemento de M2
            for (Integer elementoM2 : M2) {
                if (elementoM1.equals(elementoM2)) {
                    encontrado = true;
                    break;
                }
            }

            // Si no se encontró en M2, agregar a N1
            if (!encontrado) {
                N1.offer(elementoM1);
            }
        }
        return N1;
    }

    // Método para imprimir una pila sin modificarla
    public static void mostrarPila(Stack<Integer> pila) {
        System.out.println("Pila: " + pila);
    }

    // Método para imprimir una cola sin modificarla
    public static void mostrarCola(Queue<Integer> cola) {
        System.out.println("Cola: " + cola);
    }

    public static void main(String[] args) {
        // datos en M1
        Stack<Integer> M1 = new Stack<>();
        M1.push(10);
        M1.push(20);
        M1.push(30);
        M1.push(40);
        M1.push(50);
        M1.push(60);

        // N1 con los mismos datos que M1 pero en orden inverso
        Queue<Integer> N1 = new LinkedList<>();
        N1.offer(60);
        N1.offer(50);
        N1.offer(40);
        N1.offer(30);
        N1.offer(20);
        N1.offer(10);

        // datos en M2
        Stack<Integer> M2 = new Stack<>();
        M2.push(20);
        M2.push(40);
        M2.push(60);
        M2.push(80); // Este no está en M1

        // Mostrar contenido de las estructuras antes de las funciones
        System.out.println("Datos iniciales:");
        mostrarPila(M1);
        mostrarCola(N1);
        mostrarPila(M2);

        // Ejecutar paso 1
        System.out.println("\n¿C1 es el inverso de P1? " + paso1(M1, N1));

        // Ejecutar paso 2
        Queue<Integer> resultado = paso2(M1, M2);
        System.out.println("\nElementos de P1 que no están en P2:");
        mostrarCola(resultado);
    }
}
