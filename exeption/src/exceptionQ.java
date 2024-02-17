/*
import java.util.Random;
import java.util.Scanner;
import java.lang.String;
public class rand_game {

    public static double getRandomInteger(double koochik, double bozorg){
        return (int)(Math.random()*((bozorg-koochik)+1))+koochik;
    }

    public static void main(String[] args) {
        int rand_num1 =0;
        int rand_num2 = 0;
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        for (; ; ) {
            rand_num1 = (int) getRandomInteger(0,201);
            rand_num2 = (int) getRandomInteger(0,201);
            if (Math.abs(rand_num2 - rand_num1) > 10)
                break;
        }
        if (rand_num2 < rand_num1) {
            int temp = rand_num1;
            rand_num1 = rand_num2;
            rand_num2 = temp;
        }
        System.out.println("The first number: " + rand_num1);
        System.out.println("The second number: " + rand_num2);
        int n_mid = (random.nextInt() % (rand_num2 - rand_num1)) + rand_num1;
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter your number");
            String str = input.next();
            int num=str.charAt(0);
            int changeTo;
            try {
                changeTo = Integer.parseInt(str);
            }
            catch (InvalidInputException e) {
                changeTo = 0;
            }

        }
    }
}
class InvalidInputException extends Exception{
    */
/*public InvalidInputException(){
        super();
    }
    public void valid(int  num) throws InvalidInputException {
        if (num < 10 && num>=0){
            throw new InvalidInputException;
        }
        else {
        }
    }*//*

    class NumberOutOfRange extends Exception{
        public NumberOutOfRange(){
            super();
        }
        public void checkRange(int min,int max,int entry)throws NumberOutOfRange{
            if (entry < min || entry > max){
                throw new NumberOutOfRange();
            }
        }

}
*/
