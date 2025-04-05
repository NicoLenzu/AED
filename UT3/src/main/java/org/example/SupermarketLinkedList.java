package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SupermarketLinkedList {
    LinkedList<Product> products = new LinkedList<>();
    public void listProduct(Product p){
        products.add(p);
    }
    public void removeProduct(Product p){
        products.remove(p);
    }
    public void addStock(String prodName, int quantity){
        if(products.contains())
    }

    public void printStock(){
        List<String> prod = new ArrayList<>();
        for(Product p: products){
            prod.add(p.getName());
        }
        prod.sort(String::compareTo);
    }

}
