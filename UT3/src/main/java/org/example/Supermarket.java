package org.example;

import java.util.HashMap;

public class Supermarket {
    // Diccionario que almacena el producto con su stock
    private HashMap<Product, Integer> products = new HashMap<>();

    public void listProduct(Product p){
        products.put(p, 0);
    }
    public void removeProduct(Product p){
        products.remove(p);
    }
    public void addStock(Product p, int inc){
        if (products.containsKey(p))
            products.put(p, products.get(p) + inc);
        else
            System.out.println("No existe el producto");
    }
    public void removeStock(Product p, int dec){
        // Si el producto esta listado y su stock no es 0 le restamos al stock
        if (products.containsKey(p) && products.get(p) > 0){
            products.put(p, products.get(p) - dec);
        }
    }
    public void printStock(){
        for(Product p: products.keySet()){
            System.out.println(p.getName() + " " + products.get(p));
        }
    }
}
