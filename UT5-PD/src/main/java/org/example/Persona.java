package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Persona {
    public String nombre;
    public Persona izq;
    public Persona der;
    public Comparable<String> apellido;


    public Persona(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return nombre;
    }

    public boolean buscarLinea(String nombre, Stack pila) {
        if (this.nombre.equals(nombre)) {
            pila.push(this);
            return true;
        } else if (izq != null && izq.buscarLinea(nombre, pila)) {
            pila.push(this);
            return true;
        } else if (der != null && der.buscarLinea(nombre, pila)) {
            pila.push(this);
            return true;
        } else {
            return false;
        }
    }
    public String calacularParentesco(String p1, String p2){
        Stack pila1 =new Stack();
        this.buscarLinea(p1,pila1);
        Stack pila2 =new Stack();
        this.buscarLinea(p2,pila2);

        System.out.println(pila1);
        System.out.println(pila2);

        if (pila1.empty() || pila2.empty()) {
            return "No se encuentra la persona";
        }
        boolean sonIguales = true;
        while (!pila1.empty() && !pila2.empty() && sonIguales) {
            Persona a = (Persona) pila1.pop();
            Persona b = (Persona) pila2.pop();
            if (!a.nombre.equals(b.nombre)) {
                sonIguales = false;
                pila1.push(a);
                pila2.push(b);
            }
        }
        System.out.println(pila1.size() + " " + pila2.size());
        int grado = pila1.size()  + pila2.size() ;
        if (pila1.empty() || pila2.empty()) {
            return grado+ " Cosanguineo";
        }
        else{
            return grado+ " Politico";
        }
    }
}
