import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.IDN;
import java.util.Scanner;

public class FileTesting {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("file");

       // PrintWriter pw = new PrintWriter(file1);
        Scanner in = new Scanner(file1);


        while (in.hasNext()){
            String firstname = in.next();
            String lastname = in.next();
            long id = in.nextLong();
            System.out.println(firstname);
            System.out.println(lastname);
            System.out.println(id);

        }

        in.close();
        /*pw.println("farbod " + "fooladi " + "12365");
        pw.println("ali " + "hoseini "+ "254861");

        pw.close();*/
    }
}
