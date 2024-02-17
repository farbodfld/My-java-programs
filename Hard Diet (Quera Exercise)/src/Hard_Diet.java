import java.util.Scanner;

public class Hard_Diet {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int redCounter = 0, yellowCounter = 0;
        String healthyTag = scn.nextLine();

        for (int i = 0; i < healthyTag.length(); i++) {
            if (healthyTag.charAt(i) == 'R')
                redCounter++;
            else if (healthyTag.charAt(i) == 'Y')
                yellowCounter++;
        }

        if (redCounter >= 3 || (redCounter >= 2 && yellowCounter >= 2) || !healthyTag.contains("G"))
            System.out.println("nakhor lite");
        else
            System.out.println("rahat baash");
    }
}
