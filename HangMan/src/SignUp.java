import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp {
    File file = new File("C:\\Users\\lenovo\\IdeaProjects\\HangMan\\User & Pass.txt");
    Scanner sc = new Scanner(System.in);
    String username;
    String Password;
    Map<String, User> usersList = new ConcurrentHashMap<>();

    public SignUp() throws IOException {
        System.out.println("Please Enter Your UserName : ");
        username = sc.next();
        checking_username(username);

        System.out.println("Please Enter A Password : ");
        Password = sc.next();
        checking_Password(Password);
        add_user_pass(username, Password);

        User user1 = new User(username, Password);
        usersList.put(user1.getUserName(), user1);

        System.out.println("YOU HAVE SIGNED UP SUCCESSFULLY");
        new Menu();
    }

    private void checking_username(String username) throws IOException {
        String[] words;  //Intialize the word Array
        FileReader fr = new FileReader(file); //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        String s;

        while ((s = br.readLine()) != null)   //Reading Content from the file
        {
            words = s.split(" ");  //Split the word using space
            for (String word : words) {
                if (word.equals(username))   //Search for the given word
                {
                    System.out.println("Your Username Has Been Used \n Please Enter Another One :  ");
                    username = sc.next();
                    checking_username(username);
                }
            }
        }
        fr.close();
    }

    private void checking_Password(String Password) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        int password_length = Password.length();

        if (password_length < 6) {
            System.out.println("Your Password Should Be more Than 6 Character \n Enter A Password With more than 6 Character : ");
            Password = sc.next();
            checking_Password(Password);
        }

        for (int i = 0; i < Password.length(); i++) {
            ch = Password.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
        }
        if (!(numberFlag && capitalFlag && lowerCaseFlag)) {
            System.out.println("Your Password Must Contains Uppercase and Lowercase Character with Digits \n Please Enter Another Password : ");
            Password = sc.next();
            checking_Password(Password);
        }

        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(Password);
        boolean b = m.find();
        if (!b) {
            System.out.println("Your Password Must Contains special Character  \n Please Enter Another Password : ");
            Password = sc.next();
            checking_Password(Password);
        }
    }

    private void add_user_pass(String username, String Password) {
        try {
            FileWriter fw = new FileWriter(file , true);
            fw.write(username);
            fw.write("      ");
            fw.write(Password);
            fw.write("      ");
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}