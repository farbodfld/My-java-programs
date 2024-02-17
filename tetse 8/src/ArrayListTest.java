import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String b = in.nextLine();
        String c = in.nextLine();
        String d = in.nextLine();
        ArrayList<String> a = new ArrayList<String>();
        a.add(s);
        a.add(b);
        a.add(c);
        a.add(d);
        for (String str: a){
            System.out.print(str + " ");
        }
    }
}
