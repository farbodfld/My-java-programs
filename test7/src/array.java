import java.util.Arrays;
import java.util.Scanner;

public class array {
    public static void sum(int...value){
        Scanner input = new Scanner(System.in);
        int sum = 0;


        for (int i = 0; i < value.length; i++) {
            System.out.print(i + " ");
            sum += value[i];
        }
        int miangin = sum/value.length;
        System.out.println("avrage is "+miangin);
    }

    public void printarrey(int arrey[][]){
        for (int i = 0; i < arrey.length; i++) {
            System.out.print(Arrays.toString(arrey[i]));
            System.out.println();
            for (int j = 0; j < arrey[i].length; j++) {
                System.out.print(Arrays.toString(arrey[j]));
            }
        }
    }
    public static void main(String[] args){
        sum(1,2,3);
        double[] arr = new double[10];
        arr[0] = 1.2;
        arr[1] = 3.2;

    }
}
