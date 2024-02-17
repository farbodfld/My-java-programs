import java.util.Arrays;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        //int q = scn.nextInt();
        String input , ip , username;
        int type;
        String[] splitString;

        //for (int i = 0; i < q; i++) {
            input = scn.nextLine();
            splitString = input.trim().split(" ");
            type = Integer.parseInt(splitString[0]);

            switch (type){
                case 1:
                    splitString = splitString[1].trim().split(":");
                    ip = splitString[0];
                    username = splitString[1];
            }
        //}
    }
}
