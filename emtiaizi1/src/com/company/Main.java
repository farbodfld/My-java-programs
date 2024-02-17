import java.util.Scanner;

class Main
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        long M,N,result = 0;
        int temp;
        M = input.nextInt();
        N = input.nextInt();
        int length = (int) (Math.log(M)/Math.log(16)) + 1;
        int rotate = (int) (N % length);
        for (int i = rotate;0 < i;i--)
        {
            temp = ((int) ((double) M / Math.pow(16,i-1))) % 16;
            if (i == rotate && temp == 0)
                continue;
            if (temp < 10)
                System.out.print(temp);
            else
                System.out.print((char)('a' + (char) (temp-10)));
        }
        for (int i = length;rotate < i;i--)
        {
            temp = ((int) ((double) M / Math.pow(16,i-1))) % 16;
            if (temp < 10)
                System.out.print(temp);
            else
                System.out.print((char)('a' + (char) (temp-10)));
        }

    }
}