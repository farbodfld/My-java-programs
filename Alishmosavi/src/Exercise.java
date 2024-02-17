import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AlishMosavi mosavi = new AlishMosavi();

        String s1 = scan.nextLine();
        mosavi.setS1(s1);

        String s2 = scan.nextLine();
        mosavi.setS2(s2);

        if (mosavi.equal()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}