import java.util.InputMismatchException;
import java.util.Scanner;

public class Vote {

    public static void valid_age(int age){
        if (age < 18){
            throw new ArithmeticException("not valid age");
        }else {
            System.out.println("welcome to voting");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int age = in.nextInt();
        valid_age(age);
    }
}
