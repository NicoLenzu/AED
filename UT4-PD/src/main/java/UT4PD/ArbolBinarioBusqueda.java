package UT4PD;

public class ArbolBinarioBusqueda<T> {
    private NodoArbol<T> raiz;
    public ArbolBinarioBusqueda(NodoArbol<T> r) {
        raiz = r;
    }
    public NodoArbol<T> getRaiz() {
        return raiz;
    }
    public NodoArbol<T> insertar(NodoArbol<T> nodoAct, NodoArbol<T> nodoIns) {
        if (nodoAct == null) {
            return nodoIns; // Si el nodo actual es null, este pasa a ser el nuevo nodo.
        }
        if (nodoIns.getId().compareTo((T) nodoAct.getId()) > 0) {
            nodoAct.setDer(insertar(nodoAct.getDer(), nodoIns)); // Actualizamos la derecha
        } else if (nodoIns.getId().compareTo((T) nodoAct.getId()) < 0) {
            nodoAct.setIzq(insertar(nodoAct.getIzq(), nodoIns)); // Actualizamos la izquierda
        }
        return nodoAct; // Retornamos el nodo actualizado.
    }
    public boolean esVacio() {
        return raiz == null;
    }
    public void eliminar(Comparable unaEtiqueta) {
        if (esVacio()){
            return;
        }
        raiz.eliminar(unaEtiqueta);

    }







}
