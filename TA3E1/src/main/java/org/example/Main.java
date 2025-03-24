package org.example;

public class Main {
    public static void main(String[] args) {
        ContadorPalabras contador = new ContadorPalabras();
        System.out.println(contador.contadorPalabras("Hola Mundo"));
        System.out.println(contador.cantidadMayorX("Hola Mundo asd a sdgfkjsdj    a123", 2));
        for (String palabra : contador.palabrasComunes(new String[]{"Hola", "mundo", "de", "los", "algoritmos"}, new String[]{"Hola", "mundo", "de", "la", "informatica"})) {
            System.out.println(palabra);
        }
        System.out.println(contador.contadorVocales("Hola Mundo"));
        System.out.println(contador.contadorConsonantes("Hola Mundo"));
        }   

}