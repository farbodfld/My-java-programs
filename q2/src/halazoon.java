import java.util.Scanner;

public class halazoon {
    static void halazooni(int m, int n, int a[][])
    {
        int i, v = 0, h = 0, sum = 0, score = 0;

        while (v < m && h < n) {

            for (i = h; i < n; ++i) {
               // System.out.print(a[v][i] + " ");
                sum+=a[v][i];
                if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0 ){
                    score++;
                }
            }
            v++;

            for (i = v; i < m; ++i) {
               // System.out.print(a[i][n - 1] + " ");
                sum+=a[i][n-1];
                if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0 ){
                    score++;
                }
            }
            n--;

            if (v < m) {
                for (i = n - 1; i >= h; --i) {
                   // System.out.print(a[m - 1][i] + " ");
                    sum+=a[m-1][i];
                    if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0 ){
                        score++;
                    }
                }
                m--;
            }

            if (h < n) {
                for (i = m - 1; i >= v; --i) {
                   // System.out.print(a[i][h] + " ");
                    sum+=a[i][h];
                    if (Math.sqrt(sum) - Math.floor(Math.sqrt(sum)) == 0 ){
                        score++;
                    }
                }
                h++;
            }
        }
        System.out.println();
        System.out.println(score);
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        halazooni(n,n,arr);
    }
}
