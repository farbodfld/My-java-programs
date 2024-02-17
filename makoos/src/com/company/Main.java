import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int adad = input.nextInt();
        int l = input.nextInt();
        int r = input.nextInt();
        int adad2 = adad;
        int  sizeadad = 0;
        int natijenahayi = 0;
        int rev = 0;
        int h = 1;
        int M;
        for(;adad2>0;sizeadad++,adad2/=10);      // size adad ro peida mikonim

        int tedad = sizeadad;

        while (adad > 0) {
             M = adad % 10;
            if (sizeadad > r) {
                natijenahayi += M * h;
                h *= 10;            // samte rast adad ro dorost mikonim
                sizeadad--;
                adad /= 10;
            } else if (sizeadad == r) {
                while (sizeadad != (l - 1)) {
                    M = adad % 10;
                    adad /= 10;              // makoose adad ro dorost mikonim
                    rev = rev * 10 + M;
                    sizeadad--;
                }
                rev *= Math.pow(10, tedad - r);
                natijenahayi += rev;
            } else {
                natijenahayi += M * Math.pow(10, tedad - sizeadad);
                adad /= 10;                           // samte chape adad ro dorost mikonim
                sizeadad--;
            }
        }
        System.out.println(natijenahayi);     // dar akhar too natijenahayi mrizim o print mikonim
    }
}