import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sign_Up {
    File userNamesFile = new File("Users");
    Scanner scn = new Scanner(System.in);
    Map<String , User> usersList = new ConcurrentHashMap<>();

    public Sign_Up() throws FileNotFoundException {
        System.out.println("Please enter your USERNAME!");
        String userName = scn.next();
       // checking_UserName(userName);

        System.out.println("Please enter your PASSWORD!");
        String passWord = scn.next();
        // checking_Password(passWord);

        try {
            FileWriter fw = new FileWriter("Users");
            fw.write(userName);
            fw.write(passWord);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        User user = new User(userName , passWord);
        usersList.put(user.getUserName() , user);
    }

    private void checking_Password(String password) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;

        int password_length = password.length();
        if (password_length < 6) {
            System.out.println("your PASSWORD is less than 6 characters!\nEnter something with more characters!");
            password = scn.next();
            checking_Password(password);
        }
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }
        if (!(numberFlag && capitalFlag && lowerCaseFlag)) {
            System.out.println("your password must contains Uppercase and Lowercase characters with digits\nEnter new PASSWORD!");
            password = scn.next();
            checking_Password(password);
        }

        String regex = "[^a-zA-Z0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        if (!(m.matches())) {
            System.out.println("your password must contains special characters!\nEnter new PASSWORD!");
            password = scn.next();
            checking_Password(password);
        }

    }

    private void checking_UserName(String username) throws FileNotFoundException {
        Scanner in = new Scanner(userNamesFile);
        while (in.hasNext()) {
            if (username.equals(in.next())) {
                System.out.println("your USERNAME is already existed!\nPlease enter another one!");
                username = scn.next();
                checking_UserName(username);
            }
        }
        in.close();
    }
}
