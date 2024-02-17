import java.util.Scanner;
import java.lang.Math.*;
public class Main {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       double x1 = input.nextDouble();
       double y1 = input.nextDouble();
       double r1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();
        double d = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
        if(d < r1 + r2){
            double meghdar = r1 * r1;
            double meghdar2 = r2 * r2;
           double m = (meghdar - meghdar2 + d * d) / (2 * d);
           double n = m * m;
           double z = Math.sqrt(meghdar - n);
            if (d <= Math.abs(r2 - r1)){
                System.out.println(Math.PI * Math.min(meghdar,meghdar2));
            }
            else{
                System.out.println(meghdar * Math.asin(z / r1) + meghdar2 * Math.asin(z / r2) - z * (m + Math.sqrt(z + meghdar2 - meghdar)));
            }
        }
	// write your code here
    }
}
