import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i=0 ;i<n;i++){
            int x = input.nextInt();
            arr[i] = x;
        }
       int indexmax = 0;
        int max = arr[0];
        for(int j=0;j<arr.length;j++){
            if(arr[j] > max){
                max = arr[j];
                indexmax = j;
            }
        }
        if(indexmax == n - 1)
            System.out.print("0");
        else
            System.out.print(indexmax + 1);
	// write your code here
    }
}
