import java.util.*;

public class SetTesting {
    public static void main(String[] args) {
        String[] list = {"b", "b", "c"};
        Set<String> set = new HashSet<>();
        LinkedHashSet<String> hs = new LinkedHashSet<>();

        hs.addAll(Arrays.asList(list));
        Iterator<String> i2 = hs.iterator();
        while (i2.hasNext()) {
            String w2 = (String) i2.next();
            System.out.print(w2 + " ");
        }
        set.addAll(Arrays.asList(list));
        Iterator i = set.iterator();
        while (i.hasNext()) {
            String w = (String) i.next();
            System.out.print(w + " ");
        }
    }
}
