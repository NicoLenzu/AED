package org.example;

public class Main {
    public static void main(String[] args) {
        Lista lista = new Lista();
        Nodo nodo = new Nodo(1, "hola");
        Nodo nodo2 = new Nodo(2, "adios");
        Nodo nodo3 = new Nodo(3, "que tal");
        Nodo nodo4 = new Nodo(4, "como estas");

        System.out.println(lista.cantElementos());

        lista.setPrimero(nodo);

        lista.insertar(nodo2);
        lista.insertar(nodo3);
        lista.insertar(nodo4);

        System.out.println(lista.cantElementos());

        System.out.println(lista.buscar(3).getDato());

        lista.insertar(3, "chau");

        System.out.println(lista.buscar(3).getDato());

        System.out.println(lista.imprimir());
    }
}