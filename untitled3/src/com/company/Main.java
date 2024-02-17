
        import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        for(int i = 0;i<x;i++){
            int n = input.nextInt();
            int count = 0;
            for(int j = 1;j<=n;j++){
                if(n%j == 0){
                    count++;
                }
            }
            if(count == 3){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }

        // write your code here
    }
}
