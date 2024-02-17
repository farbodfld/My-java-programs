import java.util.Scanner;

public class Rotate {

    static void rotate_Clockwise(int m, int n, int[][] arr){
        int[][] new_Mat = new int[m][n];
        for (int i = 0 ; i < m; i++) {
            for (int j = 0,h=n-1; j < n && h>=0; j++,h--) {
                new_Mat[i][j] = arr[h][i];
            }
        }
        printMatrix(new_Mat);
    }

    static void printMatrix(int arr[][])
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int mat[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = in.nextInt();
                mat[i][j] = x;
            }
        }
        System.out.println("Clockwise or Counterclockwise and how many times?");
        String awn = in.next();
        if (awn.contains("Clockwise")){
            int rotatetime = in.nextInt();
            for (int i = 0; i < rotatetime; i++) {
                rotate_Clockwise(m,n,mat);
            }
        }
        else if (awn.contains("Counterclockwise")){
            int rotatetime = in.nextInt();
            for (int i = 0; i < (4-(4%rotatetime)); i++) {
                rotate_Clockwise(m,n,mat);
            }
        }
    }
}
