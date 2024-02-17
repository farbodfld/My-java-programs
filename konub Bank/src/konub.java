import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class konub {
    String username;
    String ip;
    int money;

    public konub(String username, String ip) {
        this.username = username;
        this.ip = ip;
        this.money = 0;
    }

    public static void main(String[] args) {
        Map<String, konub> users = new ConcurrentHashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int nbInput = Integer.parseInt(reader.readLine());
            for (int i = 0; i < nbInput; i++) {
                String s = reader.readLine();
                char cases = s.charAt(0);

                if (cases == '1') {
                    String ip = s.substring(1).substring(0, s.indexOf(":") - 1);
                    String username = s.substring(1).substring(s.indexOf(":"));

                    if (username.contains("_"))
                        System.out.println("invalid username");
                    else if (username.contains("*"))
                        System.out.println("invalid username");
                    else if (username.contains("#"))
                        System.out.println("invalid username");
                    else if (username.contains("$"))
                        System.out.println("invalid username");
                    else {
                        konub k = new konub(username, ip);
                        users.put(ip, k);
                    }

                } else if (cases == '2') {

                    String[] chars = s.substring(1).split(":");
                    int money_int = Integer.parseInt(chars[2]);

                    konub k = users.get(chars[0]);
                    k.money -= money_int;
                    for (konub k1 : users.values()) {
                        if (k1.username.equals(chars[1]))
                            k1.money += Integer.parseInt(chars[2]);
                    }
                } else if (cases == '3') {
                    konub k = users.get(s.substring(1));
                    System.out.println(k.money);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
