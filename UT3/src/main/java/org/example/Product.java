package org.example;

public class Product {
    private char[] name= new char[30];
    private char[] id= new char[20];
    private float unitPrice;

    public Product(String name, String id, float unitPrice) {
        this.name = name.toCharArray();
        this.id = id.toCharArray();
        this.unitPrice = unitPrice;
    }

    public String getName() {
        String nameString = "";
        for(int i=0; i<name.length; i++){
            nameString += name[i];
        }
        return nameString;
    }

    public void setName(String name) {
        this.name = name.toCharArray();
    }

    public String getId() {
        String idString = "";
        for(int i=0; i<id.length; i++){
            idString += id[i];
        }
        return idString;
    }

    public void setId(String id) {
        this.id = id.toCharArray();
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String toString(){
        return "name= " + getName() + '\n' +
                "id= " + getId() + '\n' +
                "unitPrice= " + getUnitPrice();
    }

}
