package algorithms.recursion;

public class MyReverseString {

    public static String reverseStringRecurse(String string){
        if(string == "" || string.length() == 0){
            return "";
        }
        return reverseStringRecurse(string.substring(1))+string.charAt(0);
    }

    public static String reverseStringIterative(String string){
        String result = "";

        for(int i = string.length()-1; i>=0;i--){
            result+= string.charAt(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseStringRecurse("Hello Moto!"));
    }
}
