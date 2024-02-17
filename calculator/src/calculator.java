import java.util.Scanner;

class SQRT_exception extends Exception {
    SQRT_exception(String s) {
        super(s);
    }
}

public class calculator {

    public int add() {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("enter numbers!");
        x = input.nextInt();
        y = input.nextInt();
        return x + y;
    }

    public int circumstance() {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("enter numbers!");
        x = input.nextInt();
        y = input.nextInt();
        return x - y;
    }

    public int multiply() {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("enter numbers!");
        x = input.nextInt();
        y = input.nextInt();
        return x * y;
    }

    public int division() {
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("enter numbers!");
        x = input.nextInt();
        y = input.nextInt();
        if (y == 0) {
            throw new ArithmeticException("division by zero is not required");
        } else {
            return x / y;
        }
    }

    public int SQRT() throws SQRT_exception {
        Scanner input = new Scanner(System.in);
        int x;
        System.out.println("enter number!");
        x = input.nextInt();
        if (x < 0) {
            throw new SQRT_exception("invalid number's format");
        } else {
            return (int) Math.sqrt(x);
        }
    }
}

class Main {
    public static void main(String[] args) {
        calculator c = new calculator();

        while (true) {

            System.out.println("which operator do you want?\n1)add\n2)circumstance\n3)multiply\n4)division\n5)SQRT\n6)exit");

            Scanner in = new Scanner(System.in);

            int answer = in.nextInt();

            switch (answer) {
                case 1:
                    System.out.println(c.add());
                    break;
                case 2:
                    System.out.println(c.circumstance());
                    break;
                case 3:
                    System.out.println(c.multiply());
                    break;
                case 4:
                    try {
                        System.out.println(c.division());
                    } catch (ArithmeticException e) {
                        System.out.println("exception handled " + e);
                    }
                    break;
                case 5:
                    try {
                        System.out.println(c.SQRT());
                    } catch (SQRT_exception e) {
                        System.out.println("exception handled " + e);
                    }
                    break;
                case 6:
                    return;
            }
        }
    }
}