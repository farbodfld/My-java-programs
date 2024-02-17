import java.util.Scanner;
import java.io.*;

public class exeption {

    void first() throws IOException {
        throw new IOException("error");
    }

    void second() throws IOException {
        first();
    }

    void third(){
        try {
            second();
        }catch (Exception e){
            System.out.println("exception handled");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        exeption e = new exeption();
        e.third();
        System.out.println("rest of code");
    }
}
