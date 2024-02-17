import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    String username;
    String ip;
    public int money;

    public Bank(String username, String ip) {
        this.username = username;
        this.ip = ip;
        this.money = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Bank> users = new ConcurrentHashMap<>();

        int counter = scanner.nextInt();
        for (int i = 0; i < counter; i++) {
            int state = scanner.nextInt();

            if (state == 1) {
                String[] ip_AND_username = scanner.next().split(":");
                String ip = ip_AND_username[0];
                String username = ip_AND_username[1];

                if (username.contains("_"))
                    System.out.println("invalid username");
                else if (username.contains("*"))
                    System.out.println("invalid username");
                else if (username.contains("#"))
                    System.out.println("invalid username");
                else if (username.contains("$"))
                    System.out.println("invalid username");
                else {
                    Bank k = new Bank(username, ip);
                    users.put(ip , k);
                }

            } else if (state == 2) {

                String[] ip_AND_money = scanner.next().split(":");
                String ip = ip_AND_money[0];
                String username = ip_AND_money[1];
                int money_int = Integer.parseInt(ip_AND_money[2]);

                Bank k = users.get(ip);
                k.money -= money_int;
                for (Bank k1 : users.values()) {
                    if (k1.username.equals(username))
                        k1.money += money_int;
                }
            } else if (state == 3) {
                String init = scanner.next();
                Bank k = users.get(init);
                System.out.println(k.money);
            }
        }
    }
}
