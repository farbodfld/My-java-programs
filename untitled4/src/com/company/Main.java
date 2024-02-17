import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true){
            double x = input.nextDouble();
            if(x == -1){
                break;
            }
            else {
                double masahat = ((Math.pow(3, 0.5) / 4.0) * Math.pow(x, 2));
                System.out.printf("%.4f\n",masahat);
            }
        }
        // write your code here
    }
}
