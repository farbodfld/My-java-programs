import java.util.Scanner;
import java.util.Random;
import java.lang.String;
public class Random_Game {
    public static double getRandomInteger(double koochik, double bozorg){
        return (int)(Math.random()*((bozorg-koochik)+1))+koochik;
    }
    public static void main(String[] args) {
        int rand_num1 =0;
        int rand_num2 = 0;
        Scanner input = new Scanner(System.in);
        for (; ;){
            rand_num1 = (int) getRandomInteger(0,201);
            rand_num2 = (int) getRandomInteger(0,201);
            if (Math.abs(rand_num1 - rand_num2) >= 10)
                break;
        }
        if (rand_num2 < rand_num1) {
            int tmp = rand_num1;
            rand_num1 = rand_num2;
            rand_num2 = tmp;
        }
        int rand_awnser = rand_num1 + (int)(rand_num2 * Math.random());
        System.out.println("first number: " + rand_num1);
        System.out.println("second number: " + rand_num2);
        for (int i = 0; i < 10; i++) {
            System.out.println("you have "+(i+1)+ " chance\nEnter number");
            String str = input.next();
            NumberOutOfRange numberOutOfRange = new NumberOutOfRange();
            InvalidInputException invalidInputException = new InvalidInputException();
            try {
                int vroodi = invalidInputException.checkInput(str);
                numberOutOfRange.checking_range(rand_num1,rand_num2,vroodi);
            }catch (InvalidInputException ex1){
                System.out.println("Invalid input , try again ! you must enter new number");
                i -= 1;
            }
            catch (NumberOutOfRange ex2){
                System.out.println("Number out of range , try again !\n you must enter a number between "+rand_num1+" and "+ rand_num2);
                i -= 1;

            }
        }
    }
}
class NumberOutOfRange extends Exception{
    public NumberOutOfRange(){
        super();
    }
    public void checking_range(int min, int max, int entry)throws NumberOutOfRange{
        if (entry < min || entry > max){
            throw new NumberOutOfRange();
        }
    }
}
class InvalidInputException extends Exception{
    public InvalidInputException(){
        super();
    }
    public int checkInput(String s) throws InvalidInputException{
        if (s.charAt(0) >= '0' && s.charAt(0) <= '9'){
            return Integer.parseInt(s);
        }else {
            throw new InvalidInputException();
        }
    }
}
