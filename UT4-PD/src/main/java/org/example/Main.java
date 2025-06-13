package org.example;
import UT4PD.ArbolBinarioBusqueda;
import UT4PD.NodoArbol;

public class Main {
    public static void main(String[] args) {
        /*
        // Crear un árbol binario vacío
        ArbolBinarioBusqueda<Integer> arbol = new ArbolBinarioBusqueda<>(null);

        // Insertar nodos en el árbol. Actualizamos la referencia de la raíz al insertar.
        NodoArbol<Integer> raiz = new NodoArbol<>(4); // Nodo raíz
        arbol = new ArbolBinarioBusqueda<>(raiz); // Inicializamos el árbol con la raíz

        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(3));//          4
        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(5));//         3  5
        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(1));//        1    6
        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(2));//       0  2
        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(6));//
        arbol.insertar(arbol.getRaiz(), new NodoArbol<>(0));

        System.out.println(raiz.altura());
        System.out.println(raiz.hojas());
        System.out.println(raiz.internos());
        System.out.println(raiz.completos());

        System.out.println("Inorden: ");
        raiz.inOrder();
        System.out.println("Preorden: ");
        raiz.preOrder();
        System.out.println("Postorden: ");
        raiz.postOrder();

         */
        //a)
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda(new NodoArbol(12));
        arbol.insertar(arbol.getRaiz(), new NodoArbol(25));//           12
        arbol.insertar(arbol.getRaiz(), new NodoArbol(14));//         /   \
        arbol.insertar(arbol.getRaiz(), new NodoArbol(1));//         1     25
        arbol.insertar(arbol.getRaiz(), new NodoArbol(33));//         \     /\
        arbol.insertar(arbol.getRaiz(), new NodoArbol(88));//           2  14 33
        arbol.insertar(arbol.getRaiz(), new NodoArbol(45));//            \      \
        arbol.insertar(arbol.getRaiz(), new NodoArbol(2));//              7      88
        arbol.insertar(arbol.getRaiz(), new NodoArbol(7));//              /      / \
        arbol.insertar(arbol.getRaiz(), new NodoArbol(66));//            5      45  99
        arbol.insertar(arbol.getRaiz(), new NodoArbol(5));//                     \
        arbol.insertar(arbol.getRaiz(), new NodoArbol(99));//                     66
        //b)
        System.out.println("Inorden:");
        arbol.getRaiz().inOrder();
        //c)
        arbol.eliminar(99);//                       14
        arbol.eliminar(15);//                      /  \
        arbol.eliminar(2);//                      1    25
        arbol.eliminar(12);//                      \    \
        arbol.eliminar(77);//                       7    88
        arbol.eliminar(33);//                      /     /
        //d)                                                 5     45
        System.out.println("Inorden:");//                            \
        arbol.getRaiz().inOrder();//                                  66
        System.out.println("Preorden:");
        arbol.getRaiz().preOrder();
        System.out.println("Postorden:");
        arbol.getRaiz().postOrder();

    }
}
