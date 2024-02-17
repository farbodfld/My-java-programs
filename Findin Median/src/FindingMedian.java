import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindingMedian {

    public Queue<Integer> minHeap;
    public Queue<Integer> maxHeap;
    public int elements_Counter;

    private static class MaxHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public FindingMedian() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(10, new MaxHeapComparator());
        elements_Counter = 0;
    }

    public void addNumber(int num) {
        maxHeap.add(num);
        if (elements_Counter % 2 == 0) {
            if (minHeap.isEmpty()) {
                elements_Counter++;
                return;
            }

            if (maxHeap.peek() > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(maxHeap.poll());
        }
        elements_Counter++;
    }

    public Double find_Median() {
        if (elements_Counter % 2 == 0)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return Double.valueOf(maxHeap.peek());
    }

    public static void main(String[] args) {
        FindingMedian findingMedian = new FindingMedian();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int input = Integer.parseInt(reader.readLine());
            for (int i = 0; i < input; i++) {
                findingMedian.addNumber(Integer.parseInt(reader.readLine()));
                System.out.printf("%.1f%n", findingMedian.find_Median());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}