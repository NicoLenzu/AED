package org.example;

public class Contador {
    private final int MAX_CONT = 50;
    private int contador = 1;
    private int incremento = 1;
    public void mostrarContador() {
        while (contador <= MAX_CONT) {
            System.out.println(contador);
            contador += incremento;
        }
    }
    public void mostrarContadorDoWhile(){
        do {
            contador += incremento;
            System.out.println(contador);
        }
        while (contador < MAX_CONT);
        }


    public void mostrarContadorFor(){
        for (contador = contador; contador <= MAX_CONT; contador+= incremento){
            System.out.println(contador);
        }
    }
}


