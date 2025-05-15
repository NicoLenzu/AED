package UT4PD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
class NodoArbolTest{

    @Test
    void testNodoArbolTest(){
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
        arbol.getRaiz().inOrder();
        //c)
        arbol.eliminar(99);//                       14
        arbol.eliminar(15);//                      /  \
        arbol.eliminar(2);//                      1    25
        arbol.eliminar(12);//                      \    \
        arbol.eliminar(77);//                       7    88
        arbol.eliminar(33);//                      /     /
        //d)                                                 5     45
        arbol.getRaiz().inOrder();//                                 \
        arbol.getRaiz().preOrder();//                                66
        arbol.getRaiz().postOrder();//

    }
}