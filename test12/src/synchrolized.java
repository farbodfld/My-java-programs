import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class synchrolized {
    public static void main(String[] args){
        List<String> sl = Collections.synchronizedList(new ArrayList<>());

        sl.add("slm");
        sl.add("chetori");

        Iterator<String> it = sl.iterator();
        while (it.hasNext()){
            synchronized (it){
                System.out.println(it.next());
            }
        }
    }
}
