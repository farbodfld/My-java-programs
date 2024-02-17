package com.company;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long adad = input.nextLong();
        int count = 0;
            while (adad > 0) {
                if(adad%10 > count )
                    count = (int) (adad%10);
                adad/=10;
            }
            System.out.println(count);
        // write your code here
    }
}
