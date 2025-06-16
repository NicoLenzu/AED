package org.example;

import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido 
{

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas)
    {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);

    }

    @Override
    public boolean insertarArista(TArista arista)
    {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas()
    {
        return lasAristas;
    }

    public TGrafoNoDirigido Prim() {
        TAristas aristas = new TAristas();
        Collection<TVertice> U = new ArrayList<TVertice>();
        Collection<TVertice> V = new ArrayList<TVertice>();
        V.addAll(getVertices().values());
        U.add(V.iterator().next());

        while (!V.isEmpty()) {
            TArista tempArista = getLasAristas().buscarMin(U,V);
            if (tempArista != null) {
                aristas.add(tempArista);
                aristas.add(tempArista.aristaInversa());
                for (TVertice v : V) {
                    if(tempArista.getEtiquetaDestino() == v.getEtiqueta()) {
                        V.remove(v);
                        break;
                    }
                }
                U.add(new TVertice(tempArista.getEtiquetaDestino()));
            }
        }
        return (new TGrafoNoDirigido(U, aristas));
    }
    public TGrafoNoDirigido Kruskal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Collection<TVertice> bfs(Comparable etiquetaOrigen) {
        if (etiquetaOrigen == null || !getVertices().containsKey(etiquetaOrigen)) {
            return null;
        }
        Collection<TVertice> bfslist = new ArrayList();
        Queue<TVertice> U = new LinkedList<TVertice>();
        bfslist.add(getVertices().get(etiquetaOrigen));
        U.add(getVertices().get(etiquetaOrigen));
        getVertices().get(etiquetaOrigen).setVisitado(true);

        while (!U.isEmpty()) {
            TVertice tempVertice = U.poll();
            for (TAdyacencia ady : tempVertice.getAdyacentes()){
                if (!ady.getDestino().getVisitado()){
                ady.getDestino().setVisitado(true);
                U.add(ady.getDestino());
                bfslist.add(ady.getDestino());
                }
            }
        }
        return bfslist;
    }
    public Collection<TVertice> dfs(Comparable etiquetaOrigen){
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
