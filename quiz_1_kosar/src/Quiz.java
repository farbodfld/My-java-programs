public class Quiz {

    public static String stringMixing(String str1 , String str2){
        String result = "";
            for (int i = 0; i < str1.length(); i+=2) {
                result += str1.charAt(i);
            }
        for (int i = 0; i < str2.length(); i++) {
            for (int j = 1; j < result.length(); j+=2) {
                result += str2.charAt(i);
            }
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(stringMixing("hello" , "HELLO"));
    }
}
