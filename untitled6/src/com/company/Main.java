import java.util.Scanner;
import java.lang.Math;
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
        double meghdar = r1 * r1;
        double meghdar2 = r2 * r2;
        double m = (meghdar - meghdar2 + d * d) / (2 * d * r1);
        double m2 = (meghdar2 - meghdar + d * d) / (2 * d * r2);
        double n = m * m;
        double result;
        double result2;
        double z = Math.sqrt(meghdar - n);
        if(d <r1 + r2) {

          if (d <= Math.abs(r2 - r1) && (r2 > r1)) {
                 result =(double)(long) ((Math.PI * meghdar) * 1000) / 1000.0;
                System.out.printf("%.3f", result);
            }
          else if (d <= Math.abs(r2 - r1) && (r2 < r1)) {
                result2 =(double)(long) ((Math.PI * meghdar2) * 1000) / 1000.0;
                System.out.printf("%.3f", result2);
            }
          else {

                double gheta1 = Math.acos(m) * 2;
                double gheta2 = Math.acos(m2) * 2;
                double area1 = gheta1 * meghdar * 0.5 - meghdar * Math.sin(gheta1) * 0.5;
                double area2 = gheta2 * meghdar2 * 0.5 - meghdar2 * Math.sin(gheta2) * 0.5;
                double natijemasahat = Math.floor(((area1 + area2) * 1000)) / 1000.0;
                System.out.printf("%.3f", natijemasahat);
            }
        }
       else if(d >= r1 + r2){
            System.out.println("0.000");
        }
    }
}