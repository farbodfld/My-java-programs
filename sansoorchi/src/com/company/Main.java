import java.util.Scanner;
import javax.print.DocFlavor;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int counter = 0;
        while (counter < n) {
            String payamakehooshmand = input.next();
            String sansoor = input.next();
            counter++;
            for(;;){
                if(payamakehooshmand.indexOf(sansoor) == -1)
                    break;
                payamakehooshmand = payamakehooshmand.replace(sansoor, "");
            }
            System.out.println(payamakehooshmand);
        }
	// write your code here
    }
}
