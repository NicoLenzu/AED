public class UtilMath {
    public static int factorial(int num){
        int result = 1;
        for(int i = 1; i <= num; i++){
            result *= i;
        }
        return result;
    }
    public static boolean isPrime(long n) {
        boolean prime = true;
        for (long i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) {
                prime = false;
                break;
            }
        if (( n%2 !=0 && prime && n > 2) || n == 2) {
            return true;
        } else {
            return false;
        }
    }
    /*
    Si lo es, el programa deberá
    calcular la suma de los números pares desde 0 hasta el número dado, y en caso contrario deberá
    calcular la suma de los números impares desde 0 hasta el número dado. Utilizar solamente sentencias
    while o do-while.
     */
    public static int sumaPrimosParesImpares(long n){
        int result = 0;
        if(n <= 0){
            return result;
        }
        if(isPrime(n)){
            for(int i = 0; i <= n; i+=2){
                    result += i; // Como el incremento es de a 2 y empieza en 0 lo suma directamente
                    //System.out.printf("suma parcial primo: "+ result + "\n");
            }
        } else {
            for (int i = 1; i <= n; i += 2) {
                result += i; // Misma logica pero empezando en 1
                //System.out.printf("suma parcial no primo: "+ result + "\n");
            }
        }
        return result;
    }
}
