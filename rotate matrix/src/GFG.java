import java.util.Scanner;

public class GFG {

    static void antirotatematrix(int m,
                                 int n, int mat[][])
    {
        int row = 0, col = n-1;
        int prev, curr;
        while (row < m && col < n )
        {
            if (row+1 == m || col-1  == 0) {
                break; }
            prev = mat[row + 1][col];
            for (int i = col; i>= 0; i--)
            {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            for (int i = row; i < m; i++)
            {
                curr = mat[i][0];
                mat[i][0] = prev;
                prev = curr;
            }
            n--;

            if (row < m) {
                for (int i = n-2; i <= col; i++)
                {
                    curr = mat[m-1][i];
                    mat[m-1][i] = prev;
                    prev = curr;
                }
            }
            m--;
            if (col <= n)
            {
                for (int i = m-1; i >= row; i--)
                {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
                System.out.print( mat[i][j] + " ");
            System.out.print("\n");
        }
    }

    public static void reverse_columns(int mat[][]) {
        int k;
        for (int i = 0; i < mat.length; i++) {
            k = mat.length - 1;
            for (int j = 0; j < k; j++) {
                int temp = mat[j][i];
                mat[j][i] = mat[k][i];
                mat[k][i] = temp;
                k--;
            }
        }
    }

    public static void transpose_matrix(int mat[][]) {
        int i, j;
        for (i = 0; i < mat.length; i++) {
            for (j = i; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    public static int[][] rotateMatrix(int[][] m) {
        if (m.length == 0) return new int[0][0];

        int rows = m.length, cols = m[0].length;
        int[][] result = new int[cols][rows];

        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < rows; col++) {
                result[row][col] = m[col][rows - row - 1];
            }
        }

        return result;
    }

    private static int[][] rotateMatrixBy90Degree(int[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last - offset][last] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        /*System.out.println("Matrix After Rotating 90 degree:-");
        printMatrix(matrix, n);*/
        return matrix;

    }

    static int[][] rotate(int[][] input) {

        int n = input.length;
        int m = input[0].length;
        int[][] output = new int[m][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                output[j][n - 1 - i] = input[i][j];
        return output;
    }
    // static int N = 2;

    // Function to rotate the matrix 90 degree clockwise
    static void rotate90Clockwise(int a[][], int length) {

        // Traverse each cycle
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {

                // Swap elements of each cycle
                // in clockwise direction
                int temp = a[i][j];
                a[i][j] = a[length - 1 - j][i];
                a[length - 1 - j][i] = a[length - 1 - i][length - 1 - j];
                a[length - 1 - i][length - 1 - j] = a[j][length - 1 - i];
                a[j][length - 1 - i] = temp;
            }
        }
    }

    // Function for print matrix
    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

// Driver code

    public static void main(String[] args) {
        int mat[][] = {{1, 2, 3}, {4, 5, 6},{7,8,9}};
        Scanner in = new Scanner(System.in);
        /*int m = in.nextInt();
        int n = in.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = in.nextInt();
                arr[i][j] = x;
            }
        }
        System.out.println(arr.length);*/
        // rotate90Clockwise(arr,arr.length);
        // rotate(arr);
        // rotateMatrixBy90Degree(arr,arr.length);
        // rotateMatrix(arr);
        //  printMatrix(arr);
        antirotatematrix(3,3,mat);
        /*transpose_matrix(mat);
        reverse_columns(mat);
        printMatrix(mat);*/
    }
}
