import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String jang = input.next();
        String morde = "()";
        int counter = 0;
            while (jang.indexOf(morde) != -1) {
                jang = jang.replace(morde, "");
                counter++;
            }
            int taghi = jang.length();
            System.out.println(taghi);

        // write your code here
    }
}
