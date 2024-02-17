package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num =input.nextInt();
       // int n = input.nextInt();

        // For storing remainder
        int rem;

        // For storing result
        String str2="";

        // Digits in hexadecimal number system
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(num>0)
        {
            rem=num%16;
            str2=hex[rem]+str2;
            num=num/16;
        }
        System.out.println(str2);
	// write your code here
    }
}
