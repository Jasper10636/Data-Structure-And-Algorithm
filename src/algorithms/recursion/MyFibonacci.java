package algorithms.recursion;

public class MyFibonacci {

    public static int FibonacciRecurse(int number){
        if(number < 2) return number;
        return FibonacciRecurse(number-1)+FibonacciRecurse(number-2);
    }

    public static int FibonacciIterative(int value){
        int fib0 = 0;
        int fib1 = 1;
        int result = fib0+fib1;

        if(value < 2){
            return value;
        }

        for(int i = 3; i <= value;i++){
            fib0 = fib1;
            fib1 = result;
            result = fib1 + fib0;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(FibonacciRecurse(10));
        System.out.println(FibonacciIterative(10));
    }

}
