import java.util.Scanner;

public class Main {
    public static void main(String[]args)
    {
        Scanner input=new Scanner(System.in);

        double x1=input.nextDouble();
        double y1=input.nextDouble();
        double r1=input.nextDouble();
        double x2=input.nextDouble();
        double y2=input.nextDouble();
        double r2=input.nextDouble();
        double area1,area2;

        double d = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2));
        if(d<=Math.abs(r2-r1)){

            area1=(double)((long)(r1*r1*Math.PI*1000))/1000;
            area2=(double)((long)(r2*r2*Math.PI*1000))/1000;
            if(r2<r1)
                System.out.printf("%.3f \n",area2);

            else
                System.out.printf("%.3f \n",area1);
        }
        else {
            double zd1 = (Math.acos((r1 * r1 + d * d - r2 * r2) / (2 * r1 * d))) * 2;
            double zd2 = (Math.acos((r2 * r2 + d * d - r1 * r1) / (2 * r2 * d))) * 2;
            double m = 0.5 * zd2 * r2 * r2 - 0.5 * r2 * r2 * Math.sin(zd2);
            double n = 0.5 * zd1 * r1 * r1 - 0.5 * r1 * r1 * Math.sin(zd1);
            double area = ((double) ((long) ((m + n) * 1000))) / 1000;
            System.out.printf("%.3f\n", area);
        }
       /* if (d>=r2+r1)
            System.out.println("0.000");*/
        //else
         if (d>=r2+r1)
            System.out.println("0.000"); /*if(d<=Math.abs(r2-r1)){

            area1=(double)((long)(r1*r1*Math.PI*1000))/1000;
            area2=(double)((long)(r2*r2*Math.PI*1000))/1000;
            if(r2<r1)
                System.out.printf("%.3f \n",area2);

            else
                System.out.printf("%.3f \n",area1);
        }*/
       /* else{
            double zd1 = (Math.acos((r1*r1 + d*d - r2*r2) / (2*r1*d))) * 2;
            double zd2 = (Math.acos((r2*r2 + d*d - r1*r1) / (2*r2*d))) * 2;
            double m = 0.5 * zd2 * r2*r2 - 0.5*r2*r2*Math.sin(zd2);
            double n = 0.5 * zd1 * r1*r1 - 0.5*r1*r1*Math.sin(zd1);
            double area = ((double)((long)((m+n)*1000))) / 1000;
            System.out.printf("%.3f\n",area);
        }*/
    }
}