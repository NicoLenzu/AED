package org.example;

import java.util.Collection;

import java.util.Comparator;
import java.util.LinkedList;

public class TAristas extends LinkedList<TArista> {

    private final static String SEPARADOR_ELEMENTOS_IMPRESOS = "-";
    //private Collection<TArista> aristas  = new LinkedList<TArista>();

    /**
     * Busca dentro de la lista de aristas una arista que conecte a etOrigen con
     * etDestino
     *
     * @param etOrigen
     * @param etDestino
     * @return
     */
    public TArista buscar(Comparable etOrigen, Comparable etDestino) {
        TArista tempArista = null;
        for (TArista laa : this) {
            if ((laa.getEtiquetaOrigen().equals(etOrigen)) && laa.getEtiquetaDestino().equals(etDestino)) {
                tempArista = laa;
            }
        }

        return tempArista;
    }
    public TArista buscarMin(Collection<TVertice> U,Collection<TVertice> V ){
        TArista minArista = null;
        double minCosto = Double.MAX_VALUE;
        for (TVertice u : U) {
            for (TVertice v : V) {
                TArista tempArista = buscar(u.getEtiqueta(),v.getEtiqueta());
                if (tempArista != null) {
                    if (tempArista.getCosto() < minCosto) {
                        minArista = tempArista;
                        minCosto = tempArista.getCosto();
                    }
                }
            }
        }
        return minArista;
    }

    public String imprimirEtiquetas() {
        if (this.isEmpty()) {
            return null;
        }
        StringBuilder salida = new StringBuilder();
        //TODO: Completar codigo que imprime todas las aristas de la lista en el siguiente formato:
        //ORIGEN - DESTINO - COSTO
        return salida.toString();
    }

    void insertarAmbosSentidos(Collection<TArista> aristas) {
        TArista tempArista;
        for (TArista ta : aristas) {
            this.add(ta);
            this.add(ta.aristaInversa());
        }
    }
    public void ordenarPorCosto() {
        this.sort(Comparator.comparingDouble(TArista::getCosto));
    }

}
