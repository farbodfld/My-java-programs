import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Testing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        int x;
        for (int i = 0; i < 3; i++) {
            x = in.nextInt();
            set.add(x);
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
