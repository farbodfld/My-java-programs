import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double zele1 = Math.hypot(x2 - x1,y2 - y1);
        double zele2 = Math.hypot(x3 - x1,y3 - y1);
        double zele3 = Math.hypot(x3 - x2,y3 - y2);
        if(zele1 + zele2 > zele3 && zele1 + zele3 > zele2 && zele2 + zele3 > zele1){
            System.out.println("YES");
            double masahat = Math.abs(0.5*(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2)));
            System.out.printf("%.2f",masahat);
        }
        else{
            System.out.println("NO");
        }
	// write your code here
    }
}
