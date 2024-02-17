
import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        long adad = input.nextLong();

        int result = 0;   // adadi ke por tekrar tarine

        int max_count = 0;   // tedad dafati ke adad tekrar shode

        long n;
        int count;

        for (int d = 0; d <= 9; d++)   // az 1 ta 9 ro chek mikonim ke kdoom bishtar tekrar shode
        {

             n = adad;
             count = 0;
            while (n > 0)
            {
                // baraye peida kardan dafat tekrar ye adad too majmooe az adad
                if (n % 10 == d)
                    count++;
                n = n / 10;
            }
            if (count > max_count)
            {
                max_count = count;
                result = d;
            }
        }
        System.out.println(result);

    }
}
