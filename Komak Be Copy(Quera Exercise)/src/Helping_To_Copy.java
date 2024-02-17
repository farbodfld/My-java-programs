import java.util.Scanner;

public class Helping_To_Copy {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String s = scn.next();

        StringBuilder temp = new StringBuilder();
        String tmp = "copy of ";

        for (int i = 0; i < n; i++) {
            temp.append(tmp);
        }

        temp.append(s);
        System.out.println(temp);
    }
}
