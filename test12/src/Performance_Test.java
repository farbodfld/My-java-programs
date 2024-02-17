import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Performance_Test {
    public static void main(String[] args){
        Set<Integer> set = new HashSet<>();
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        Set<Integer> s = new TreeSet<>();

        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = (int) ((Math.random() * 100) + 1);
            set.add(x);
        }
        long end = System.nanoTime();
        System.out.println("hash set: " + (end - start));

        long start2 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = (int) ((Math.random() * 100) + 1);
            hs.add(x);
        }
        long end2 = System.nanoTime();
        System.out.println("linkedHashset " + (end2 - start2));

        long start3 = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = (int) ((Math.random() * 100) + 1);
            set.add(x);
        }
        long end3 = System.nanoTime();
        System.out.println("treeSet: "+(end3 - start3));
    }
}
