package org.example;

import java.util.ArrayList;
import java.util.List;

public class ContadorPalabras {
    
    public ContadorPalabras() {}

    /*
     * Este método `contadorPalabras` cuenta la cantidad de palabras en un texto.
     * Primero verifica si el carácter actual es una letra. Si es así, marca la palabra
     * como verdadera. Luego, si encuentra un espacio o llega al final del texto, aumenta
     * el contador de palabras y marca la palabra como falsa.
     * 
     * Valor de retorno:
     * contador : Devuelve el número total de palabras en el texto.
     */ 
    public int contadorPalabras(String texto) {
        boolean palabra = false;
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                palabra = true;
            }
            if(palabra && (texto.charAt(i) == ' ' || i == texto.length() - 1 )){
                palabra = false;
                contador += 1;
            }
        }
        return contador;
    }

    /*
    Este método `cantidadMayorX` cuenta la cantidad de palabras en un texto que tienen exactamente
    la cantidad de caracteres especificada por el parámetro `caracteres`.

    El método recorre el texto carácter por carácter y mantiene un contador para determinar
    el número de caracteres de la palabra actual. Si encuentra una palabra con exactamente
    la cantidad requerida de caracteres, aumenta un contador y marca la palabra como contada.
    Se reinician los contadores al final de cada palabra para continuar con la siguiente.

    Parámetros:
    - `texto`: representa la cadena de texto que se analizará.
    - `caracteres`: número exacto de caracteres que se verificará en cada palabra.

    Valor de retorno:
    Devuelve el número total de palabras con exactamente la cantidad especificada de caracteres.
     */
    public int cantidadMayorX(String texto, int caracteres) {
        boolean palabra = false;
        boolean contado = false;
        int contadorPalabras = 0;
        int contadorCaracteres = 0;

        for (int i = 0; i < texto.length(); i++) {
            if (Character.isLetter(texto.charAt(i))) {
                palabra = true;
                contadorCaracteres += 1;
            }
            if (!contado && contadorCaracteres == caracteres) {
                contadorPalabras += 1;
                contado = true;
            }
            if(palabra && (texto.charAt(i) == ' ' || i == texto.length() - 1 )){
                contadorCaracteres = 0;
                palabra = false;
                contado = false;
            }
        }
        return contadorPalabras;
    }
    public int contadorVocales(String texto){
        int contadorVocales = 0;
        String vocales = "aeiouáéíóú";

        String textoMin = texto.toLowerCase();
        for (int i = 0; i < textoMin.length(); i++) {
            char letra = textoMin.charAt(i);

            String letraString = Character.toString(letra);
            if(vocales.contains(letraString)){
                contadorVocales++;
            }
        }
        return contadorVocales;
    }


    public int contadorConsonantes(String texto) {
        int contadorConsonantes = 0;
        String consonantes = "qwrtypsdfghjklzxcvbnm";

        String textoMin = texto.toLowerCase();
        for (int i = 0; i < textoMin.length(); i++) {
            char letra = textoMin.charAt(i);

            String letraString = Character.toString(letra);
            if (consonantes.contains(letraString)) {
                contadorConsonantes++;
            }
        }
        return contadorConsonantes;
    }


            /*
     * Este método `palabrasComunes` compara dos arreglos de palabras y devuelve un arreglo
     * con las palabras que se encuentran en ambos arreglos.
     * Valor de retorno:
     * palabrasComunesList : Devuelve un arreglo con las palabras comunes entre los dos arreglos.
     */
    public String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        List<String> palabrasComunesList = new ArrayList<>();
        for (int i = 0; i < palabras1.length; i++) {
            for (int j = 0; j < palabras2.length; j++) {
                if (palabras1[i].equals(palabras2[j])) {
                    palabrasComunesList.add(palabras1[i]);
                }
            }
        }
        return palabrasComunesList.toArray(new String[0]);
    }
}

