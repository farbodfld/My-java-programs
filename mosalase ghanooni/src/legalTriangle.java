import java.util.Scanner;

class IllegalTriangleException extends Exception {
    public IllegalTriangleException(String s) {
        super(s);
    }
}

public class legalTriangle {
    public static void checking_triangle() throws IllegalTriangleException {
        Scanner intput = new Scanner(System.in);
        int x, y, z;

        System.out.println("Enter x:");
        x = intput.nextInt();
        System.out.println("Enter y:");
        y = intput.nextInt();
        System.out.println("Enter z:");
        z = intput.nextInt();

        if ((x + y > z) && (x + z > y) && (y + z > x))
            System.out.println("Yes");
        else
            throw new IllegalTriangleException("You can't make triangle!");
    }

    public static void main(String[] args) {
        try {
            checking_triangle();
        } catch (IllegalTriangleException e) {
            System.out.println("exception handled " + e);
        }

    }
}
