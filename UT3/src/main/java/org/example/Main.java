package org.example;

public class Main {
    public static void main(String[] args) {
        // Instanciando el supermercado
        Supermarket supermarketASD = new Supermarket();
        SupermarketLinkedList supermarket = new SupermarketLinkedList();

        // Creando productos de ejemplo
        Product product1 = new Product("Manzanas", "001", 1.5f);
        Product product2 = new Product("Pan", "002", 0.8f);
        Product product3 = new Product("Leche", "003", 1.2f);

        // Listando productos en el supermercado
        supermarket.listProduct(product1);
        supermarket.listProduct(product2);
        supermarket.listProduct(product3);

        // Agregando stock a los productos
        supermarket.addStock(product1, 50); // Agregamos 50 unidades de Manzanas
        supermarket.addStock(product2, 20);
        supermarket.addStock(product2, 30); // Agregamos 30 unidades de Pan
        supermarket.addStock(product3, 20); // Agregamos 20 unidades de Leche

        // Restando stock a un producto
        supermarket.removeStock(product1, 10); // Quitamos 10 unidades de Manzanas

        // Imprimiendo todos los productos y sus stocks
        supermarket.printStock();
    }
}