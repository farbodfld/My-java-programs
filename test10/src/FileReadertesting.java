import java.io.*;
import java.util.Scanner;

public class FileReadertesting {
    public static void main(String[] args) {
        File file1 = new File("file");
        try {
            FileWriter fw = new FileWriter("file2");
            fw.write("farbod");
            fw.write(" ");
            fw.write("fld");
            fw.write("\n");
            fw.write("hello");
            fw.flush();


            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("success");
    }
}

class FileWritertesting {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file");
        FileReader fr = new FileReader("file2");
        int i = fr.read();
        while (i != -1){
            System.out.println((char) i);
        }
        fr.close();
    }
}