package org.example;

public class Nodo<T> implements INodo{
    private T dato;
    private Nodo siguiente;
    private Comparable etiqueta;
    public Nodo(Comparable etiqueta, T dato){
        this.etiqueta = etiqueta;
        this.dato = dato;
    }
    public void setDato(T dato){
        this.dato = dato;
    }
    @Override
    public Object getDato() {
        return this.dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(Nodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println( this.dato);
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println( this.etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }

}
