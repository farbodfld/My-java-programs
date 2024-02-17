package com.company;
import java.util.Scanner;

public class Main {

    void swap(int i,int j){
       int temp = i;
       i = j;
       j = temp;
   }

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       int num1 = input.nextInt();
        int num2 = input.nextInt();
       // int num3 = input.nextInt();
        System.out.println(num1);
        System.out.println(swap);
    }
}
