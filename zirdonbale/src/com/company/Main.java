import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for(int j=0;j<n;j++){
            int x = input.nextInt();
            arr[j] = x;
        }
        int startmax=0,endmax=0,summax=arr[0],lengthmax=0;
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<arr.length;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    if(sum > summax){
                        summax = sum;
                        startmax = i;
                        endmax = j;
                        lengthmax = j-i;
                    }
                }
                if(sum == summax){
                    if(lengthmax < (j-i)){
                        summax = sum;
                        startmax = i;
                        endmax = j;
                        lengthmax = j-i;
                    }
                }
            }
        }
        for (int l=startmax;l<=endmax;l++){
            System.out.print(arr[l] + " ");
        }
    }
}
