package algorithms.recursion;

public class MyRecursion {

    // 1.Identify Base case
    // 2.Identify Recursive case
    // 3.Get Closer and Closer and return when needed. Usually have 2 return

    private static int count;
    private static int i;

    private static void recurse(){
        int i = count;
        if(count == 5){
            return;
        }
        System.out.println(i+" iteration, number of count is "+count);
        count++;
        recurse();

    }

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
        System.out.println(factorialRecursion(2));
        System.out.println(factorialIterative(5));
//       recurse();
    }



}
