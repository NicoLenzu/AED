package org.example;

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
}

