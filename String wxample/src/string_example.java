import java.util.Scanner;

public class string_example {
    public int detector(char[] str){
        int counter = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' '){
                str[counter++] = str[i];
            }
        }
        return counter;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        string_example example = new string_example();
        /*System.out.println("enter your sentence:");
        String input = scanner.next();*/
        char[] entry = "g eeks for ge eeks ".toCharArray();
        int i = example.detector(entry);
        System.out.println(String.valueOf(entry).subSequence(0, i));
        /*for (char c : entry) {
            System.out.print(c);
        }*/
    }
}
