import java.util.*;

public class Array {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>();
        Enumeration<String> e = Collections.enumeration(arr);
        String[] city = {"tehran","shiraz"};

        arr.add("slm");
        arr.add("chetori");

        arr2.add("merci");

        arr.addAll(arr2);

       /* while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }*/
    }
}
