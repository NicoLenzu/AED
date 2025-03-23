package org.example;

public class ContadorPalabras {
    public ContadorPalabras() {}
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
}
