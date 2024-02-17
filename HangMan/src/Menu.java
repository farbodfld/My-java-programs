import java.io.IOException;
import java.util.Scanner;

public class Menu {
    Scanner scn = new Scanner(System.in);
    int SL;

    public Menu() throws IOException {
        System.out.println("WELCOME TO GAME!!");
        System.out.println("SIGN UP OR LOG IN?");
        System.out.println("1)SIGN UP\n2)LOG IN");
        SL = scn.nextInt();
        switch (SL){
            case 1:
                new SignUp();
                break;
            case 2:
                new Log_in();
                break;
            default:
                System.out.println("YOUR ENTERED NUMBER IS INVALID!!");
                showAgain();
                break;
        }
    }

    private void showAgain() throws IOException {
        System.out.println("SIGN UP OR LOG IN?");
        System.out.println("1)SIGN UP\n2)LOG IN");
        SL = scn.nextInt();
        switch (SL){
            case 1:
                new SignUp();
                break;
            case 2:
                new Log_in();
                break;
            default:
                System.out.println("YOUR ENTERED NUMBER IS INVALID!!");
                showAgain();
                break;
        }
    }
}
