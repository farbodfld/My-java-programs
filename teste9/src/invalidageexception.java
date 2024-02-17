import java.util.Scanner;

public class invalidageexception extends RuntimeException {
    public invalidageexception(String a) {
        super(a);
    }
}

class test2 {
    static void valid_age(int age) throws invalidageexception {
        if (age < 18) {
            throw new invalidageexception("not valid age");
        } else {
            System.out.println("welcome to voting");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int age = in.nextInt();
        try {
            valid_age(13);
        } catch (Exception e) {
            System.out.println("exception handled " + e);
        }
        System.out.println("rest of code");
    }
}