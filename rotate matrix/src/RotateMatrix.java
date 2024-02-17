import java.util.Scanner;

public class RotateMatrix {

    static int N = 4;

    // Function to rotate the matrix 90 degree clockwise
    static void rotate90Clockwise(int a[][])
    {

       // int N = a.length;
        // Traverse each cycle
        for (int i = 0; i < N / 2; i++)
        {
            for (int j = i; j < N - i - 1; j++)
            {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    static void printMatrix(int arr[][])
    {
       // int N = arr.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }
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
        System.out.println("Clockwise or Counterclockwise and how many times?");
        String awn = input.next();
        if (awn.contains("Clockwise")){
            int rotatetime = input.nextInt();
            for (int i = 0; i < rotatetime; i++) {
                rotate90Clockwise(matrix);
            }
        }
        else if (awn.contains("Counterclockwise")){
            int rotatetime = input.nextInt();
            for (int i = 0; i < rotatetime; i++) {
                rotate90Clockwise(matrix);
            }
        }
    }
}

