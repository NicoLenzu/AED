package org.example;

class PrePostDemo {
    public static void main(String[] args){
    int i = 3;
    i++;
    System.out.println(i);
    ++i;
    System.out.println(i);
    System.out.println(++i);
    System.out.println(i++); // Primero se imprime el valor y luego se incrementa
    System.out.println(i);

    }
   }