import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTesting {
    public static void main(String[] args) {
        CopyOnWriteArrayList cp = new CopyOnWriteArrayList();
        cp.add("hi");
        cp.add("hello");
        Iterator iterator = cp.iterator();
        while (iterator.hasNext()) {
            System.out.println((String) iterator.next());
        }
    }
}

