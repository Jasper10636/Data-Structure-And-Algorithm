package algorithms.recursion;

public class MyFactorial {

    public static long factorialRecursion(long value){
        if(value <= 2){
            return value;
        }
        return value * factorialRecursion(value-1);
    }

    public static long factorialIterative(long value){
        long result = 1;
        for(long i = 1; i <=value;i++){
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorialIterative(5));
        System.out.println(factorialRecursion(5));
    }
}
