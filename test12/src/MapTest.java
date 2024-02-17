import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        String str = "farbod sam farbod parsa erfan arfan";
        String[] words = str.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                int n = map.get(words[i]);
                map.put(words[i], ++n);
            } else {
                map.put(words[i], 1);
            }
        }
        System.out.println(map);
    }
}
