package UT4PD;

public class NodoArbol<T> {
    private T dato;

    public void setIzq(NodoArbol<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoArbol<T> der) {
        this.der = der;
    }

    private NodoArbol<T> izq;
    private NodoArbol<T> der;

    private Comparable<T> id;

    public NodoArbol(T dato) {
        this.dato = dato;
        this.id = (Comparable<T>) dato;
    }
    public T getDato() {
        return dato;
    }
    public NodoArbol<T> getDer() {
        return der;
    }
    public NodoArbol<T> getIzq() {
        return izq;
    }
    public Comparable<T> getId() {
        return id;
    }
    public boolean esHoja() {
        return izq == null && der == null;
    }
    public int altura(NodoArbol<T> nodoAct)
    {
        int A = -1;
        int B = -1;
        if (nodoAct.getIzq() != null) {
            A = nodoAct.getIzq().altura(nodoAct.getIzq());
        }
        if (nodoAct.getDer() != null) {
            B = nodoAct.getDer().altura(nodoAct.getDer());
        }
        return Math.max(A, B) + 1;
    }
    public int hojas(NodoArbol<T> nodoAct)
    {
        int hojas = 0;
        if (nodoAct.esHoja()) {
            hojas++;
        }
        if (nodoAct.getIzq() != null) {
            hojas += nodoAct.getIzq().hojas(nodoAct.getIzq());
        }
        if (nodoAct.getDer() != null) {
            hojas += nodoAct.getDer().hojas(nodoAct.getDer());
        }
        return hojas;
    }
    public int internos(NodoArbol<T> nodoAct)
    {
        int internos = 1; // contando la raiz
        if (!nodoAct.esHoja()) {
            internos++;
        }
        if (nodoAct.getIzq() != null) {
            internos += nodoAct.getIzq().hojas(nodoAct.getIzq());
        }
        if (nodoAct.getDer() != null) {
            internos += nodoAct.getDer().hojas(nodoAct.getDer());
        }
        return internos;
    }
    public int completos(NodoArbol<T> nodoAct){
        int completos = 0;
        if (nodoAct.getDer() != null && nodoAct.getIzq() != null) {
            completos++;
        }
        if (nodoAct.getIzq() != null) {
            completos += nodoAct.getIzq().completos(nodoAct.getIzq());
        }
        if (nodoAct.getDer() != null) {
            completos += nodoAct.getDer().completos(nodoAct.getDer());
        }
        return completos;


    }
    public void inOrder(NodoArbol<T> nodoAct){
        if (nodoAct != null) {
            inOrder(nodoAct.getIzq());
            System.out.println(nodoAct.getDato());
            inOrder(nodoAct.getDer());
        }
    }
    public void preOrder(NodoArbol<T> nodoAct){
        if (nodoAct != null) {
            System.out.println(nodoAct.getDato());
            preOrder(nodoAct.getIzq());
            preOrder(nodoAct.getDer());
        }
    }
    public void postOrder(NodoArbol<T> nodoAct){
        if (nodoAct != null) {
            postOrder(nodoAct.getIzq());
            postOrder(nodoAct.getDer());
            System.out.println(nodoAct.getDato());
        }
    }

}
