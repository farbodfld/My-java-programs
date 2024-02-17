/*
import java.util.InputMismatchException;
import java.util.Scanner;

public class NullExeption {

    static public int qoutient(int x , int y){
        return x/y;
    }

    public static void main(String[] args) {
        boolean flag = true;
        do {
            try {
                Scanner in = new Scanner(System.in);
                System.out.println("set number for denominator");
                int makhraj = in.nextInt();
                System.out.println("set number for nominator");
                int denominator = in.nextInt();
                int result = qoutient(makhraj, denominator);
                System.out.println(result);
                flag = false;
            } catch (InputMismatchException ex) {
                System.out.println(ex.toString());
                System.out.println();
                System.out.println("set valid input");
            } catch (ArithmeticException ea) {
                System.out.println(ea.toString());
                System.out.println("invalid input try again");
            }
        }while (flag);
    }
}
*/

import java.io.*;
/*
        * shows that the arrangement (order) of the catch blocks is essential
        * @author Parham Barati
        *
        */
class OrderHandler {
    /*
            * instantiate a new superclass exception type Exception
     * instantiate a new subclass exception type IOException
     * @param args args
     */
    public static void main(String[] args) {

        IOException _ioe = new IOException("IOException is instantiated");
        Exception _e = new Exception("Exception is instantiated");

        try {
            throw _ioe;
        }
        catch(IOException ioe){
            System.err.println(ioe);

        }
        catch(Exception e){
            System.err.println(e);

        }


    }
}
