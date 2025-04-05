package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public void BubbleSort(List<Integer> lista){
        int ifCont = 0;
        for(int i = 1; i<lista.size()-1; i++){
            for (int j = lista.size() - 1; j > i; j--){
                if (lista.get(j) < lista.get(j-1))
                    {
                        Integer aux = lista.get(j);
                        lista.set(j, lista.get(j-1));
                        lista.set(j-1, aux);
                        ifCont++;
                    }
            }

        }
        System.out.println("N: " + (lista.size()-1));
        System.out.println("Se han ordenado "+ifCont+" veces");
        System.out.println("Primer elemento: "+lista.get(1));
        System.out.println("Ultimo elemento: "+lista.get(lista.size()-1));
    }

    public List<Integer> leerArchivo(String nombreCompletoArchivo){
            List<Integer> lineas = new ArrayList<Integer>();
            try {
                File archivo = new File (nombreCompletoArchivo);
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader (fr);
                String linea = br.readLine();
                while (linea != null) {
                    lineas.add(Integer.valueOf(linea));
                    linea = br.readLine();
                }
                br.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error al leer el archivo "+nombreCompletoArchivo); // Imprime un mensaje de error si no se encuentra el archivo.
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo "+nombreCompletoArchivo);
                e.printStackTrace();
            }

            return lineas; // Devuelve una lista con las líneas del archivo.
        }

}
