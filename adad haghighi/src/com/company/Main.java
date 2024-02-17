import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String AdadHaghighi = input.nextLine();
                Pattern patern = Pattern.compile("^\\s*(\\+|-)?\\s?[0-9]+([.]?[0-9]+)?([0-9]+)?$|" +
                                                 "^\\s*(\\+|-)?\\s?[0-9]+(((\\+|-)?(e|E)(\\+|-)?)?[0-9]+)\\s*$|" +
                                                 "^\\s*(\\+|-)?\\s?[0-9]+([.]?[0-9]+)?(\\d+)?(((\\+|-)?(e|E)(\\+|-)?)?[0-9]+)\\s*$");
        Matcher macher = patern.matcher(AdadHaghighi);
        if(macher.matches()){
            System.out.println("LEGAL");
        }
        else {
            System.out.println("ILLEGAL");
        }
    }
}
