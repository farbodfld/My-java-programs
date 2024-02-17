import java.util.Scanner;

public class Solve_The_Equation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int resultNumber_int , firstNumber_int , secondNumber_int;
        String str  , result;
        str = scn.nextLine();
        String[] splitString = str.split("=");
        String str1 = splitString[0];
        String str2 = splitString[1];

        String[] splitString2 = str1.split("\\+");
        String first_number_string = splitString2[0];
        String[] first_number_temp = first_number_string.trim().split(" ");
        String firstNumber = first_number_temp[0];

        String second_number_string = splitString2[1];
        String[] second_number_temp = second_number_string.trim().split(" ");
        String secondNumber = second_number_temp[0];
        //int second_number = Integer.parseInt(second_number_temp[0]);

        String[] splitString3 = str2.trim().split(" ");
        String resultNumber = splitString3[0];
        //int result_number = Integer.parseInt(splitString3[0]);

        if (firstNumber.contains("#")){
            firstNumber_int = Integer.parseInt(resultNumber) - Integer.parseInt(secondNumber);
            firstNumber = Integer.toString(firstNumber_int);
            result = firstNumber + " + " + secondNumber + " = " + resultNumber;
            System.out.println(result);
        }
        else if (secondNumber.contains("#")){
            secondNumber_int = Integer.parseInt(resultNumber) - Integer.parseInt(firstNumber);
            secondNumber = Integer.toString(secondNumber_int);
            result = firstNumber + " + " + secondNumber + " = " + resultNumber;
            System.out.println(result);
        }
        else if (resultNumber.contains("#")){
            resultNumber_int = Integer.parseInt(firstNumber) + Integer.parseInt(secondNumber);
            resultNumber = Integer.toString(resultNumber_int);
            result = firstNumber + " + " + secondNumber + " = " + resultNumber;
            System.out.println(result);
        }


    }
}
