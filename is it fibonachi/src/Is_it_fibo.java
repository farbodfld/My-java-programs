import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Is_it_fibo {
    public void checking_number(int n) {
        List<Integer> fib_list = new ArrayList<>();
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;
        fib_list.add(fib[0]);
        fib_list.add(fib[1]);

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            fib_list.add(fib[i]);
        }

        for (int i = 0; i < n; i++) {
            if (fib_list.contains(i)) {
                System.out.print("+");
            } else {
                System.out.print("-");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Is_it_fibo fibo = new Is_it_fibo();
        fibo.checking_number(n);
    }
}


