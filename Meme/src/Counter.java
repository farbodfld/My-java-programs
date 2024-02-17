import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = 1;
        String checking;

        while (true){
            checking = sc.nextLine();
            if (checking.equals("0"))
                return;
            System.out.print(value);
            value++;
        }
    }
}
