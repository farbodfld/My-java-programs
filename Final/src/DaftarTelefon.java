import java.io.File;
import java.util.*;

public class DaftarTelefon {
    public static void main(String[] args) {
        boolean isfound = false;
        Map<String,String> phoneBookList = new HashMap<>();
        File file = new File("C:\\Users\\lenovo\\Desktop\\AP\\AP-1 to 4//New Text Document.txt");
        Scanner scr = null;
        Scanner in = new Scanner(System.in);

        try {
            scr = new Scanner(file);
            while(scr.hasNext()){
                String line = scr.nextLine();
                String[] information = line.split(" ");
                phoneBookList.put(information[0]+information[1],information[2]);
            }
            System.out.println("Enter name");
            String name = in.nextLine();

            for (int i = 0; i < phoneBookList.size(); i++) {
                if(phoneBookList.containsKey(name)){
                    System.out.println(phoneBookList.get(name));
                    isfound = true;
                }
            }
            if(!isfound){
                System.out.println("Enter another number");
                String new_number = in.next();
                phoneBookList.put(name,new_number);
            }
            Set set = phoneBookList.keySet();
            Iterator itr = set.iterator();
            while(itr.hasNext()){
                String string = (String) itr.next();
                System.out.println(string + " : " + phoneBookList.get(string));
            }
        } catch(Exception e){
            System.out.println(e);
        }


    }
}
