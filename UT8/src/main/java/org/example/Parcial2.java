package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Parcial2
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//        // 1 - Cargar el Grafo
//        TGrafoRedDatos grafo = UtilGrafos.cargarGrafo("src/main/dispositivos.txt", "src/main/conexiones.txt", false, TGrafoRedDatos.class);
//
//        // 2 - Verificar que los componentes se encuentren conectados
//        //boolean conectados = grafo.conectados("nodoX","nodoY");
//
//        // 3 - Leer y cargar archivo mediciones.txt
//        TDato[] datos = Parcial2.cargarMediciones("src/main/mediciones.txt");
//
//        // 4 - Obtener dato de mayor medicion.
//        TMedidor medidor = new TMedidor();
//        TDato mayorMedicion = medidor.obtenerMayorMedicion(datos);
//
//        // 5 - Emitir archivo de salida salida.txt
//        // COMPLETAR CÓDIGO
//        // ManejadorArchivosGenerico.escribirArchivo("src/main/java/salida.txt", vector con lineas del archivo);

        Collection<TVertice> U = new ArrayList<TVertice>();
        U.add(new TVertice(1));
        U.add(new TVertice(2));
        U.add(new TVertice(3));
        U.add(new TVertice(4));
        U.add(new TVertice(5));
        U.add(new TVertice(6));

        TAristas aristas = new TAristas();
        aristas.add(new TArista(1,2,3));
        aristas.add(new TArista(1,3,5));
        aristas.add(new TArista(1,4,1));
        aristas.add(new TArista(1,5,7));
        aristas.add(new TArista(1,6,2));
        aristas.add(new TArista(2,3,1));
        aristas.add(new TArista(2,4,3));
        aristas.add(new TArista(2,5,5));
        aristas.add(new TArista(2,6,6));
        aristas.add(new TArista(3,4,2));
        aristas.add(new TArista(3,5,3));
        aristas.add(new TArista(3,6,5));
        aristas.add(new TArista(4,5,7));
        aristas.add(new TArista(4,6,1));
        aristas.add(new TArista(5,6,4));
        TGrafoNoDirigido grafoNoDirigido = new TGrafoNoDirigido(U,aristas);

        TGrafoNoDirigido grafoPrim = grafoNoDirigido.Prim();

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoPrim.getVertices()),grafoPrim.getVertices(),"Grafo Prim");
        TGrafoNoDirigido grafoKruskal = grafoNoDirigido.Kruskal();

        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(grafoKruskal.getVertices()),grafoKruskal.getVertices(),"Grafo Kruskal");


        System.out.println("Recorrido en Amplitud");
        for(TVertice v : grafoNoDirigido.bfs(1)){
            System.out.print(v.getEtiqueta()+" -> ");
        }
        System.out.println("Recorrido en Profundidad");
        for(TVertice v : grafoNoDirigido.dfs(1)){
            System.out.print(v.getEtiqueta()+" -> ");
        }
        System.out.println(grafoNoDirigido.conectados(1,6));
        System.out.println(grafoNoDirigido.conectados(6,1));

    }

    private static TDato[] cargarMediciones(String rutaAlArchivo) {
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(rutaAlArchivo, false);
        
        TDato[] mediciones = new TDato[lineas.length];
        for (int i = 0; i < lineas.length; i++) {
            String[] datos = lineas[i].split(",");
            mediciones[i] = new TDato(Double.parseDouble(datos[1]), Integer.parseInt(datos[0]));
        }

        return mediciones;
    }
}
