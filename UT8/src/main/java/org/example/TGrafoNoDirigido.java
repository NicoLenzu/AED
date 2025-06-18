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

    public boolean conectados(Comparable etOrigen, Comparable etDestino){
        if (etOrigen == null || !getVertices().containsKey(etOrigen) || etDestino == null || !getVertices().containsKey(etDestino)) {
            return false;
        }
        boolean conectados = false;
        Queue<TVertice> U = new LinkedList<TVertice>();
        U.add(getVertices().get(etOrigen));
        getVertices().get(etOrigen).setVisitado(true);

        while (!U.isEmpty()) {
            TVertice tempVertice = U.poll();
            for (TAdyacencia ady : tempVertice.getAdyacentes()){
                if (!ady.getDestino().getVisitado()){
                    if (ady.getDestino().getEtiqueta().equals(etDestino)){
                        desvisitarVertices();
                        return true;
                    }
                    ady.getDestino().setVisitado(true);
                    U.add(ady.getDestino());

                }
            }
        }
        desvisitarVertices();
        return conectados;

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
        getLasAristas().ordenarPorCosto();
        Collection<TVertice> V = new ArrayList<TVertice>();
        V.addAll(getVertices().values());
        int n = V.size();
        TGrafoNoDirigido grafoKruskal = new TGrafoNoDirigido(new ArrayList<>(), new ArrayList<>());
        while (!V.isEmpty()) {
            for(TArista arista : getLasAristas()){
                if (!grafoKruskal.conectados(arista.getEtiquetaOrigen(), arista.getEtiquetaDestino()) ) {

                    grafoKruskal.getLasAristas().add(arista);
                    grafoKruskal.insertarArista(arista);

                    grafoKruskal.insertarVertice(arista.getEtiquetaOrigen());
                    grafoKruskal.insertarVertice(arista.getEtiquetaDestino());
                    for (TVertice v : V) {
                        if(arista.getEtiquetaDestino() == v.getEtiqueta() || arista.getEtiquetaOrigen() == v.getEtiqueta()) {
                            V.remove(v);
                            break;
                        }
                    }
                    if ((grafoKruskal.getLasAristas().size()) == (n-1)*2) {
                        return grafoKruskal;

                    }
                }
            }
        }
        return grafoKruskal;
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
                    bfslist.add(ady.getDestino());
                    U.add(ady.getDestino());
                    ady.getDestino().setVisitado(true);
                }
            }
        }
        desvisitarVertices();
        return bfslist;
    }
    public Collection<TVertice> dfs(Comparable etiquetaOrigen){
        if (etiquetaOrigen == null || !getVertices().containsKey(etiquetaOrigen)) {
            return null;
        }

        Collection<TVertice> dfslist = new ArrayList<>();
        Stack<TVertice> stack = new Stack<>();

        TVertice origen = getVertices().get(etiquetaOrigen);
        origen.setVisitado(true);
        stack.push(origen);

        while (!stack.isEmpty()) {
            TVertice actual = stack.pop();
            dfslist.add(actual);

            for (TAdyacencia ady : actual.getAdyacentes()) {
                TVertice vecino = ady.getDestino();
                if (!vecino.getVisitado()) {
                    vecino.setVisitado(true);
                    stack.push(vecino);
                }
            }
        }

        return dfslist;
    }



}
