import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();
        double d = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        if(d >= r1 + r2)
            System.out.println("0.000");
        else if(d < Math.abs(r2 - r1)){
            if(r2>r1) {
                double result = ((1000 * r1 * r1 * Math.PI) / 1000);
                System.out.printf("%.3f\n",result);
            }
            else {
                double result2 = ((1000 * r2 * r2 * Math.PI) / 1000);
                System.out.printf("%.3f\n",result2);
            }
        }
        else{
            double A = (Math.acos((r1*r1 + d*d - r2*r2) / (2*r1*d))) * 2;
            double B = (Math.acos((r2*r2 + d*d - r1*r1) / (2*r2*d))) * 2;
            double gheta1 = 0.5 * B * r2*r2 - 0.5*r2*r2*Math.sin(B);
            double gheta2 = 0.5 * A * r1*r1 - 0.5*r1*r1*Math.sin(A);
            double masahat = ((double)((int)((gheta1+gheta2)*1000))) / 1000;
            System.out.printf("%.3f\n",masahat);
        }
    }
}
