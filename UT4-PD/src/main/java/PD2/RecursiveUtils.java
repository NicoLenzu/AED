package PD2;

public class RecursiveUtils {
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    public static int sumaLineal(int[] A, int n){
        if (n == 1) {
            return A[0];
        }
        else
            return sumaLineal(A, n-1) + A[n-1];
    }
    public static int potencia(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potencia(base, exponente - 1);
    }
    public static String[] invertir(String[] s,int i, int j) {
        if (i < j){
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            invertir(s, i+1, j-1);
        }
        return s;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(RecursiveUtils.sumaLineal(A, A.length));
        System.out.println(RecursiveUtils.factorial(5));
        System.out.println(RecursiveUtils.potencia(2, 3));
        String[] s = {"A","B","C","D"};
        String[] sResult = RecursiveUtils.invertir(s, 0, s.length-1);
        System.out.println("Array invertido: ");
        for (String string : sResult) {
            System.out.print(string);
        }
    }
}


