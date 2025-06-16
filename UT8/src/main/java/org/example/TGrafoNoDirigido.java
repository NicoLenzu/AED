package org.example;

import java.util.ArrayList;
import java.util.Collection;

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
        Collection<TVertice> V = getVertices().values();
        U.add(V.iterator().next());

        while (!V.isEmpty()) {
            TArista tempArista = this.lasAristas.buscarMin(U,V);
            if (tempArista != null) {
                aristas.add(tempArista);
                aristas.add(tempArista.aristaInversa());
                if (!V.isEmpty()){
                for (TVertice v : V) {
                    if(tempArista.getEtiquetaDestino() == v.getEtiqueta()) {
                        V.remove(v);
                        break;
                    }

                }}
                U.add(new TVertice(tempArista.getEtiquetaDestino()));
            }
        }
        return (new TGrafoNoDirigido(U, aristas));
    }

}
