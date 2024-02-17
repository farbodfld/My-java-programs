import java.util.*;

public class Collection {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        ArrayList<String> arr2 = new ArrayList<String>(arr.subList(0,4));
        List<String> arr3 = arr.subList(0,4);
        /*String aw = in.nextLine();
        String aw2 = in.nextLine();*/
        arr.add("salam");
        arr.add("khoobi");
        /*arr.set(1,aw2);
        arr.get(1);*/

        arr2.add("merci");
        arr2.add("shoma chtor");
        Collections.copy(arr,arr2);

        arr.removeAll(arr);
        arr.add("farbod");
        arr.add("fooladi");
        Collections.shuffle(arr);
        System.out.println(arr);
        Collections.swap(arr,0,1);

        Iterator it = arr2.iterator();
        while (it.hasNext()){
            String k = (String) it.next();
            System.out.println(k);
        }
    }
}
