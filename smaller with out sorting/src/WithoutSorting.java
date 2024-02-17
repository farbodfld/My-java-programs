public class WithoutSorting {

    public static int showNumber(int arr[], int index) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                counter++;
            } else {
                break;
            }
        }
        return counter+1;
    }

    public static void main(String[] args) {
        int numbers[] = {1,2,5,8,4,3};
        System.out.println(showNumber(numbers , 4));
    }
}
