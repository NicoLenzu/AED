package org.example;


/*
 * NO LICENCE 
 * Author: Ing. Agustin Paredes
 */

import java.util.Collection;


/**
 *
 * @author agustinp
 */
public class TGrafoRedDatos extends TGrafoNoDirigido implements ITGrafoRedDatos
{

    public TGrafoRedDatos(Collection<TVertice> vertices, Collection<TArista> aristas)
    {
        // Descomentar la siguiente línea luego de elegir una superclase
        super(vertices, aristas);
    }

    @Override
    public boolean conectados(Comparable etOrigen, Comparable b)
    {
        throw new UnsupportedOperationException("Método no implementado :(");
    }


}
