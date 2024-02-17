import java.util.Scanner;

public class Dictation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine(), s2 = scn.nextLine(),
                s3 = scn.nextLine(), s4 = scn.nextLine(),
                s5 = scn.nextLine();

        String[] stringArray = new String[5];
        stringArray[0] = s1;
        stringArray[1] = s2;
        stringArray[2] = s3;
        stringArray[3] = s4;
        stringArray[4] = s5;

        int counter = 0;

        for (int i = 0; i < 5; i++) {
            if (stringArray[i].contains("MOLANA") || stringArray[i].contains("HAFEZ"))
                System.out.print((i + 1) + " ");
            else
                counter++;
        }

        if (counter == 5)
            System.out.print("NOT FOUND!");
    }
}
