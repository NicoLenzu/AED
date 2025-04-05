package org.example;

public class Lista implements ILista{
    private Nodo primero;
    private int cantElementos;

    @Override
    public void insertar(Nodo nodo) {
        Nodo actual = primero;
        while(actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nodo);
        cantElementos++;
    }

    // No se si deberia colocar un nuevo nodo antes del de la etiqueta o reemplazarlo
    @Override
    public void insertar(Comparable etiqueta, Object dato) {
        Nodo actual = primero;
        while (actual.getSiguiente().compareTo(etiqueta) != 0 && actual.getSiguiente() != null){
            actual = actual.getSiguiente();
        }
        Nodo Nuevo = new Nodo(etiqueta, dato);
        Nuevo.setSiguiente(actual.getSiguiente().getSiguiente());
        actual.setSiguiente(Nuevo);
    }

    @Override
    public Nodo buscar(Comparable clave) {
        Nodo actual = primero;
        while(actual != null){
            if(actual.getEtiqueta().equals(clave)){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        Nodo actual = primero;
        while(actual.getSiguiente() != null){
            if(actual.getSiguiente().getEtiqueta().equals(clave)){
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                cantElementos--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    @Override
    public String imprimir() {
        Nodo actual = primero;
        String cadena = "";
        while(actual != null){
            cadena += actual.getDato() + " ";
            actual = actual.getSiguiente();
        }
        return cadena;
    }

    @Override
    public String imprimir(String separador) {
        Nodo actual = primero;
        String cadena = "";
        while(actual != null){
            cadena += actual.getDato() + separador;
            actual = actual.getSiguiente();
        }
        return cadena;
    }

    @Override
    public int cantElementos() {
        return this.cantElementos;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        this.primero = unNodo;
        cantElementos++;
    }
}
