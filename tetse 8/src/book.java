import java.util.ArrayList;
import java.util.Iterator;

public class book {
    public int isbn;
    public String name;
   public book(String name, int isbn){
       this.name = name;
       this.isbn = isbn;
    }
    void printbook(){
        System.out.println(isbn + " is isbn number\n" + name + " is name");
    }
}
class bookstore{
    public static void main(String[] args) {
        ArrayList<book> lst = new ArrayList<book>();
        book b1 = new book("madar",25);
        book b2 = new book("pedar",5);
        lst.add(b1);
        lst.add(b2);
        Iterator itr = lst.iterator();
        while (itr.hasNext()){
            book b = (book)itr.next();
            b.printbook();
        }
    }
}