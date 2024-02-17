import java.util.Scanner;

public class Median {
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public double findMedian(int[] arr, int size) {
        sort(arr, 0, size - 1);
        if (size % 2 != 0)
            return arr[size / 2];
        return (arr[(size - 1) / 2] + arr[size / 2]) / 2.0;
    }

    public static void main(String[] args) {
        Median median = new Median();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int data;
        int listOfData[] = new int[n];

        /*for (int i = 0; i < n; i++) {
            data = scanner.nextInt();
            listOfData[i] = data;
            System.out.println(median.findMedian(listOfData, listOfData.length));
        }*/

        int a[] = {1};
        System.out.println(median.findMedian(a, a.length));
        /*for (int i = 0; i < listOfData.length; i++) {
            System.out.println(median.findMedian(listOfData, listOfData.length));
        }*/
    }
}


class Heap {

    static int MAXN = 105;

    static int[] dp = new int[MAXN];

    static int[][] nck = new int[MAXN][MAXN];

    static int[] log2 = new int[MAXN];

    public static int choose(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (k == 0) {
            return 1;
        }

        if (nck[n][k] != -1) {
            return nck[n][k];
        }

        int answer = choose(n - 1, k - 1) + choose(n - 1, k);
        nck[n][k] = answer;
        return answer;
    }

    public static int getLeft(int n) {
        if (n == 1) {
            return 0;
        }

        int h = log2[n];

        int numh = (1 << h);

        int last = n - ((1 << h) - 1);

        if (last >= (numh / 2)) {
            return (1 << h) - 1;
        } else {
            return (1 << h) - 1 - ((numh / 2) - last);
        }
    }

    public static int numberOfHeaps(int n) {
        if (n <= 1) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = getLeft(n);
        int ans = (choose(n - 1, left) * numberOfHeaps(left))
                * (numberOfHeaps(n - 1 - left));
        dp[n] = ans;
        return ans;
    }
}
