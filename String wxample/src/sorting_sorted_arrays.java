import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class sorting_sorted_arrays {
    static class ArrayContainer implements Comparable<ArrayContainer> {
        Integer[] arrOFIntegers;
        int index;

        public ArrayContainer(Integer[] arr, int index) {
            this.arrOFIntegers = arr;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.arrOFIntegers[this.index] - o.arrOFIntegers[o.index];
        }
    }

    public static int[] sorting(List<Integer[]> arr) {
        PriorityQueue<ArrayContainer> arrayContainerPriorityQueue = new PriorityQueue<>();
        int ALL = 0;

        for (Integer[] ints : arr) {
            arrayContainerPriorityQueue.add(new ArrayContainer(ints, 0));
            ALL = ALL + ints.length;
        }

        int FLD = 0;
        int[] result = new int[ALL];

        while (!arrayContainerPriorityQueue.isEmpty()) {
            ArrayContainer AC = arrayContainerPriorityQueue.poll();
            result[FLD++] = AC.arrOFIntegers[AC.index];

            if (AC.index < AC.arrOFIntegers.length - 1) {
                arrayContainerPriorityQueue.add(new ArrayContainer(AC.arrOFIntegers, AC.index + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer[]> arrays = new ArrayList<>();

        int counter = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= counter; i++) {
            String input = reader.readLine();
            String[] tmp = input.substring(2).split(" ");

            Integer[] arr = new Integer[tmp.length];
            for (int j = 0; j < tmp.length; j++) {
                arr[j] = Integer.parseInt(tmp[j]);
            }

            arrays.add(arr);
        }

        int[] result = sorting(arrays);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
