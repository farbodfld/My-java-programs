import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Log_in {
    Scanner scn = new Scanner(System.in);
    File file = new File("C:\\Users\\lenovo\\IdeaProjects\\HangMan\\User & Pass.txt");

    public Log_in() throws IOException {
        System.out.println("ENTER YOUR USERNAME AND PASSWORD: ");
        System.out.print("USERNAME: ");
        String username = scn.nextLine();
        System.out.print("PASSWORD: ");
        String password = scn.nextLine();

        if (checkingIdentity(username, password)) {
            System.out.println("WELCOME TO HANGMAN GAME!");
            System.out.println("Start game OR Show leader board");
            System.out.println("1)Start game\n2)Show leader board");
            int SS = scn.nextInt();
            switch (SS){
                case 1:
                   // new Game();
                    break;
                case 2:
                   // new Show_LeaderBoard();
                    break;
            }
            //new Game();
        } else {
            System.out.println("YOUR USERNAME OR PASSWORD INVALID!\nPLEASE TRY AGAIN OR SIGN UP!");
            new Menu();
        }
    }

    private boolean checkingIdentity(String username, String password) throws IOException {
        // SignUp1 signUp1 = new SignUp1();
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String Username = in.next();
            String Password = in.next();
//            System.out.println(Username);
//            System.out.println(Password);

            if (username.equals(Username) && password.equals(Password))
                return true;
        }
        in.close();
        return false;
    }
}
