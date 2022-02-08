package data_structures.arrays;

public class ReverseAString {

    public static String ReverseString1(String string){
        if(string == null || string.length() == 0){
            return "";
        }

        char[] chars = string.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i = chars.length-1; i >=0; i--){
            sb.append(chars[i]);
        }

        return sb.toString();
    }

    public static String ReverseString2(String string){
        String result ="";
        if(string == null || string.length() == 0){
            return result;
        }
        int length = string.length();

        for(int i = length -1 ; i >=0;i--){
            result += string.charAt(i);
        }
        return result;
    }

    public static String oneLineReverseString(String string){
        // Build-in method
        return new StringBuilder(string).reverse().toString();
    }

    public static void main(String[] args) {
        String rvString1 = ReverseString1("This is a Pan Jasper");
        String rvString2 = ReverseString2("This is a Pan Jasper");
        System.out.println(rvString1);
        System.out.println(rvString2);
    }
}
