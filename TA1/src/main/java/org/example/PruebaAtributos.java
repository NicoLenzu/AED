package org.example;

public class PruebaAtributos {
    public static String nombre;
    public static int edad;
    public static double estatura;
    public static boolean casado;

    public static void main(String[] args) throws Exception {
        nombre = "Juan";
        edad = 25;
        toUpper();
        System.out.println(edad  + nombre );
        
    }
    public static void toUpper(){
        nombre = nombre.toUpperCase();
    }
}
