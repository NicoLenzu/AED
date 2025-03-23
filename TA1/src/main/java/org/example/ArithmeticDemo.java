package org.example;

public class ArithmeticDemo {
    public static void main (String[] args){

        /*
        int result = 1 + 2;
        System.out.println(result);
        result = result - 1;
        System.out.println(result);
        result = result * 2; 
        System.out.println(result);
        result = result / 2;
        System.out.println(result);
        result = result + 8;
        result = result % 7;
        System.out.println(result);
        */
        int result = 1 + 2;
        System.out.println(result);
        result -= 1;
        System.out.println(result);
        result *= 2;
        System.out.println(result);
        result /= 2;
        System.out.println(result);
        result += 8;
        result %= 7;    
        System.out.println(result);

        int a = 5;
        int i = 3;
        a+=++i; // = a + i + 1 <-(porque incrementa en valor de i)
        System.out.println(a);
        
    }
}
