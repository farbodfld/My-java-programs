import java.io.IOException;
import java.util.Scanner;

public class parent {
    void msg()throws IOException{
        System.out.println("parent is called");
    }
}

class child extends parent{
    void msg()throws IOException {
        System.out.println("child is called");
    }
}
class test{
    public static void main(String[] args) {
        parent p = new child();
    }
}