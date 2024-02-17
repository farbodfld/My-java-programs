import java.util.Scanner;

public class Matrix {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int r = input.nextInt();
        int c = input.nextInt();
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int x = input.nextInt();
                matrix[i][j] = x;
            }
        }

        int index_column = 0;
        int TDF = r+1;

        for (int i = 0; i < c; i++) {
            int counter = 0;
            for (int j = 0; j < r; j++) {
                int point = 0;
                if (matrix[j][i] == point){
                    counter++;
                }
            }
            if (counter <= TDF){
                TDF = counter;
                index_column = i;
            }
            System.out.println();
        }
        for (int i = 0; i < r; i++) {
            System.out.println(matrix[i][index_column]);
        }
    }
}
