import java.util.Scanner;
import java.lang.Math;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long adad = input.nextLong();
        int l = input.nextInt();
        int r = input.nextInt();
        l = (int) Math.log10(adad) - l + 2;
        r = (int) Math.log10(adad) - r + 2;
        int temp = l;
        l = r;
        r = temp;
        long samteChap = (long) (adad / Math.pow(10,r));
        if (samteChap > 0)
            System.out.print(samteChap);
        // reverse
        long vasati = (long) (adad/Math.pow(10,l-1)) % (long) Math.pow(10,r-l+1);
        int i = 0;
        while(vasati>0){
            if (i==0 && vasati%10 == 0 && r == (int) Math.log10(adad)+1) {
                vasati /= 10;
                continue;
            }
            System.out.print(vasati%10);
            vasati /= 10;
            i++;
        }
        // rasti
        long samteRast = adad % (long) Math.pow(10,l-1);
        if (samteRast > 0)
            System.out.print(samteRast);

    }
}