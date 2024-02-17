import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTesting {
    public static void main(String[] args){
        Map<String, Integer> tellbook = new HashMap<>();
        tellbook.put("ali",123);
        tellbook.put("reza",21554);
        tellbook.put("hosein",13545);
        Set<String> names = tellbook.keySet();
        Iterator iterator = names.iterator();
        while (iterator.hasNext()){
            String name = (String) iterator.next();
            System.out.println(name + " " + tellbook.get(name));
        }
    }
}
