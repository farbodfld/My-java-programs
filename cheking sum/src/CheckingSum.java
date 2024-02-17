import java.lang.reflect.Array;

public class CheckingSum {

    public static boolean check(boolean array[], int x) {
        int j = x;
        for (int i = 0; i < j; i++) {
            if (array[i] && array[j]) {
                return true;
            }
            j--;
            /*int y = array[i] + array[i + 1];
            if (y == x) {
                break;
            }*/
        }
        return true;
    }

    public static void main(String[] args) {
       // int numbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean n[] = new boolean[4001];
        HashTable hashTable = new HashTable();
        hashTable.insert(20);
        hashTable.insert(30);
        for (int i = 0; i < n.length; i++) {
            n[i] = hashTable.insert(20);
        }
        //check(numbers, 8);
        System.out.println(check(numbers, 9));
    }
}

 class HashTable {
    private boolean[] table = new boolean[4001];

    public void insert(int a) {
        table[a] = true;
    }

    public void remove(int b) {
        table[b] = false;
    }

    public boolean search(int c) {
        return table[c];
    }

    public boolean areThereTwoNumbersWithSumOf(int x) {
        int i = 0, j = x;
        while (i < j) {
            if (table[i] && table[j])
                return true;
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(10);
        System.out.println(hashTable.search(10));
        hashTable.remove(10);
        System.out.println(hashTable.search(10));
        hashTable.insert(20);
        hashTable.insert(30);
        System.out.println(hashTable.areThereTwoNumbersWithSumOf(50));
    }
}