import java.util.*;

class Pair<N, N1> {
    double x;
    double y;

    // Constructor
    public Pair(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
}

// class to define user defined conparator
class Compare {

    static void compare(Pair<N, N1> arr[], int n)
    {
        // Comparator to sort the pair according to second element
        Arrays.sort(arr, new Comparator<Pair<N, N1>>() {
            @Override public int compare(Pair<N, N1> p1, Pair<N, N1> p2)
            {
                return (int) (p1.y - p2.y);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].x + " " + arr[i].y + " ");
        }
        System.out.println();
    }
}

public class Final {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Double> list_x = new ArrayList<>();
        ArrayList<Double> list_y = new ArrayList<>();

        int input = scanner.nextInt();
        double x, y;
        for (int i = 0; i < input; i++) {
            x = scanner.nextDouble();
            list_x.add(x);
        }

        for (int i = 0; i < input; i++) {
            y = scanner.nextDouble();
            list_y.add(y);
        }

        double counter = scanner.nextDouble();
        double coordinate;
        double size = counter * 4;
        ArrayList<Double> arr_x = new ArrayList<>();
        ArrayList<Double> arr_y = new ArrayList<>();
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            coordinate = scanner.nextDouble();
            arrayList.add(coordinate);
        }

        double y2 = 0;
        double x2 = 0;
        double y1 = 0;
        double x1 = 0;

        /*Collections.sort(list_x);
        Collections.sort(list_y);

        for (int i = 0; i < list_x.size();  i++) {
            System.out.print(list_x.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < list_y.size();  i++) {
            System.out.print(list_y.get(i) + " ");
        }
        System.out.println();*/

        ArrayList<Double> result_x = new ArrayList<>();
        ArrayList<Double> result_y = new ArrayList<>();

        Pair<N, N1> arr[] = new Pair<N, N1>[input];

        for (int l = 0; l < arrayList.size(); l += 4) {
            x1 = arrayList.get(l);
            y1 = arrayList.get(l + 1);
            x2 = arrayList.get(l + 2);
            y2 = arrayList.get(l + 3);

            for (int i = 0; i < list_x.size(); i++) {
                if (list_x.get(i) > x1 && list_x.get(i) <= x2) {
                    if (list_y.get(i) > y1 && list_y.get(i) <= y2) {
                        //System.out.print(list_x.get(i) + " ");
                        arr[i] = new Pair<N, N1>(list_x.get(i) , list_y.get(i));
                    }
                }
            }

            System.out.println();

            for (int i = 0; i < list_y.size(); i++) {
                if (list_y.get(i) > y1 && list_y.get(i) <= y2) {
                    if (list_x.get(i) > x1 && list_x.get(i) <= x2) {
                       // System.out.print(list_y.get(i) + " ");
                        arr[i] = new Pair<N, N1>(list_x.get(i) , list_y.get(i));
                    }
                }
            }
            System.out.println();
        }

        Compare obj = new Compare();
        obj.compare(arr, input);

    }
}