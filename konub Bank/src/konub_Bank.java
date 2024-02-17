import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class User {
    private String userName;
    private int money;

    public String getUserName() {
        return userName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public User(String userName) {
        this.userName = userName;
    }
}

class MedianOfIntegerStream {

    static HashMap<String, User> userHashMap = new HashMap<>();


    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int nbInput = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= nbInput; i++) {
                String s = reader.readLine();
                char cases = s.charAt(0);

                switch (cases) {
                    case '1':
                        String ip = s.substring(1).substring(0, s.indexOf(":") - 1);
                        String username = s.substring(1).substring(s.indexOf(":"));
                        if (userHashMap.containsKey(ip)) {
                            if (!userHashMap.get(ip).getUserName().equals(username))
                                System.out.println("invalid username");

                        } else {
                            if (checkUserName(username))
                                userHashMap.put(ip, new User(username));
                            else
                                System.out.println("invalid username");
                        }
                        break;
                    case '2':
                        String[] chars = s.substring(1).split(":");
                        userHashMap.get(chars[0]).setMoney(userHashMap.get(chars[0]).
                                getMoney() - Integer.parseInt(chars[2]));
                        for (User user : userHashMap.values()) {
                            if (user.getUserName().equals(chars[1]))
                                user.setMoney(user.getMoney() + Integer.parseInt(chars[2]));
                        }
                        break;
                    case '3':
                        System.out.println(userHashMap.get(s.substring(1)).getMoney());
                        break;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean checkUserName(String s) {
        boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
        if (s.contains("#"))
            flag1 = true;
        if (s.contains("$"))
            flag2 = true;
        if (s.contains("*"))
            flag3 = true;
        if (s.contains("_"))
            flag4 = true;
        return !flag1 && !flag2 && !flag3 && !flag4;
    }

}