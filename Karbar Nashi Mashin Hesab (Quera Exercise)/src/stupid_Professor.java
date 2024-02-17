import java.util.Scanner;

public class stupid_Professor {
    public static String parseToCientificNotation(double value) {
        int cont = 0;
        java.text.DecimalFormat DECIMAL_FORMATER = new java.text.DecimalFormat("0.##");
        while (((int) value) != 0) {
            value /= 10;
            cont++;
        }
        return DECIMAL_FORMATER.format(value).replace(",", ".") + " x10^ -" + cont;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int number;
        float result = 1;

        for (int i = 0; i < n; i++) {
            number = scn.nextInt();

            if (number == 2)
                result = result / 2;
            else if (number == 5)
                result = result * 5;
        }

        System.out.print(parseToCientificNotation(result));
    }
}
