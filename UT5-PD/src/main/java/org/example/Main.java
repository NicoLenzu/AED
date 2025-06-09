package PD3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear instancia del Trie
        Trie trie = new Trie();

        // Cargar palabras del índice
        System.out.println("Cargando palabras del índice...");
        trie.cargarPalabrasIndice("PalabrasIndice.txt");

        // Indizar el libro
        System.out.println("Indizando el libro...");
        trie.indizarLibro("libro.txt");

        // Imprimir el índice
        System.out.println("\nÍndice del libro:");
        System.out.println("----------------");
        trie.imprimirIndice();

        // Menú de búsqueda
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n¿Qué palabra desea buscar? (escriba 'salir' para terminar)");
            String palabra = scanner.nextLine().trim();
            
            if (palabra.equalsIgnoreCase("salir")) {
                break;
            }

            Trie.ResultadoBusqueda resultado = trie.buscar(palabra);
            System.out.println("\nResultado de la búsqueda:");
            System.out.println(resultado);
        }
        scanner.close();
    }
} 