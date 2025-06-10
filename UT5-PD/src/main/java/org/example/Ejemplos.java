package org.example;

public class Ejemplos {
    class ImprimirArbol{
        public void imprimirArbol(Nodo nodo, int nivel) {
            if (nodo == null) return;

            imprimirArbol(nodo.derecho, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("    "); // sangría
            }
            System.out.println(nodo.valor);

            imprimirArbol(nodo.izquierdo, nivel + 1);
        }

    }

    class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    public class ArbolABB {
        Nodo raiz;

                    /*
                    10
                   /  \
                  5    15
                 / \   / \
                3   7 13 17
                     */
        public void construirEjemplo() {
            raiz = new Nodo(10);
            raiz.izquierdo = new Nodo(5);
            raiz.derecho = new Nodo(15);
            raiz.izquierdo.izquierdo = new Nodo(3);
            raiz.izquierdo.derecho = new Nodo(7);
            raiz.derecho.izquierdo = new Nodo(13);
            raiz.derecho.derecho = new Nodo(17);
        }
                        /*
                        8
                       / \
                      3   10
                       \    \
                        6    14
                            /
                           13

                         */
        public void construir() {
            raiz = new Nodo(8);
            raiz.izquierdo = new Nodo(3);
            raiz.izquierdo.derecho = new Nodo(6);
            raiz.derecho = new Nodo(10);
            raiz.derecho.derecho = new Nodo(14);
            raiz.derecho.derecho.izquierdo = new Nodo(13);
        }
    }
    class NodoAVL {
        int valor;
        NodoAVL izquierdo, derecho;
        int altura;

        NodoAVL(int valor) {
            this.valor = valor;
            this.altura = 1;
        }
    }
                    /*
                        20
                       /  \
                     10    30
                     / \   / \
                    5  15 25 35

                     */
    public class ArbolAVL {
        NodoAVL raiz;

        public void construirEjemploAVL() {
            raiz = new NodoAVL(20);
            raiz.izquierdo = new NodoAVL(10);
            raiz.derecho = new NodoAVL(30);
            raiz.izquierdo.izquierdo = new NodoAVL(5);
            raiz.izquierdo.derecho = new NodoAVL(15);
            raiz.derecho.izquierdo = new NodoAVL(25);
            raiz.derecho.derecho = new NodoAVL(35);
        }
    }


}
