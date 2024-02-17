import java.util.Scanner;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String givenString = scanner.nextLine();
        if ((!givenString.endsWith(".com") && !givenString.endsWith(".net")) || ("aeiouAEIOU".indexOf(givenString.charAt(0))<0)){
            System.out.println("NO");
            return;
        }
        givenString = givenString.substring(0,givenString.length()-4);
        int countNumbers = 0,indexOfFirst = 0,indexOfSecond = 0;
        Matcher matcher = Pattern.compile("\\d").matcher(givenString);
        while(matcher.find()){
            countNumbers++;
            if (countNumbers == 1)
                indexOfFirst = matcher.start();
            if (countNumbers == 2)
                indexOfSecond = matcher.start();
        }
        if (countNumbers != 2){
            System.out.println("NO");
            return;
        }
        String tmp = givenString.substring(indexOfFirst+1,indexOfSecond);
        matcher = Pattern.compile("@").matcher(tmp);
        int counterat = 0;
        while (matcher.find())
            counterat++;
        if (counterat < 1){
            System.out.println("NO");
            return;
        }
        givenString = givenString.replaceAll("\\d|@","");
        if (!givenString.matches("[a-zA-Z]+")){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");

    }
}