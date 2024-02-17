import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String vroodi = input.nextLine();
        Pattern patern = Pattern.compile("^[aeouiAEOUI]+[0-9]{1}[a-zA-Z]?[@]+[a-zA-Z]?[0-9]{1}\\.[com[net]]$");
        Matcher macher = patern.matcher(vroodi);
        if(macher.matches()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
	// write your code here
    }
}
