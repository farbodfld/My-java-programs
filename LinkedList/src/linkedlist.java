
public class linkedlist {
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
        public Node(int data2,Node next2){
            this.next = next2;
            this.data = data2;
        }
    }

    public boolean add(Integer element){
        Node new_node = new Node(element);
        if (head == null)
        {
            head = new Node(element);
            return false;
        }
        new_node.next = null;
        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return true;
    }

    public void add(int index , Integer element){
        if(index < 0 || index > size()){
           // throw new IndexOutOfBoundsException();
            return;
        }
        if(index == size()){
            add(element);
            return;
        }
        else if(index == 0){
           // head = new Node(element,head);
            Node newnode = new Node(element);
            newnode.next = head.next;
            head.next = newnode;
        }
        else {
            Node courent = head;
            for (int j = 0; j < index ; j++) {
                courent = courent.next;
            }
            Node new_node = new Node(element);
            new_node.next = courent.next;
            courent.next = new_node;
        }
      /*  Node current = head;
        int count = 0;
        int a;
        while (current != null)
        {
            if (count == index){
                a = current.data;
            }
            count++;
            current = current.next;
        }
        if (current.next == null)
        {
            return;
        }
        Node new_node = new Node(element);
        new_node.next = current.next;
        current.next = new_node; */
    }

    public void addFirst(int element)
    {
        Node new_node = new Node(element);
        new_node.next = head;
        head = new_node;
    }

    public void addLast(Integer element){
        Node new_node = new Node(element);
        if (head == null)
        {
            head = new Node(element);
        }
        else {
            new_node.next = null;
            Node last = head;
            while (last.next != null)
                last = last.next;
            last.next = new_node;
        }
    }

    public void clear(){
        head = null;
    }

    public boolean contains(Integer i) {
        Node courent = head;
        while (courent != null){
            if (courent.equals(i)) {
                return true;
            }
                courent = courent.next;
    }
        return false;
    }

    public Integer get(int index){
        Node current = head;
        int count = 0;
        while (current != null)
        {
            if (count == index){
                return current.data;
            }
            count++;
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(Integer i){
        Node courent = head;
        int index = 0;
        while (courent != null){
            if(courent.data == i){
                return index;
            }
            index++;
            courent = courent.next;
        }
        return -1;
    }

    public void remove(){
        if(head == null){
            return ;
        }
        Node temp = head;
        head = head.next;
       // temp = null;
    }

    public Integer remove(int index){
        int a = 0;
        if(index >= 0 && index < size()){
            Node courent = head;
            for (int i = 0; i < index; i++) {
                courent = courent.next;
            }
             a = courent.data;
             Node temp = courent;
            courent = courent.next;
            // temp = null;
        }
        return a;
      /*  Node current = head;
        int count = 0;
        Node a;
        while (current != null)
        {
            if (count == index){
                a = current;
            }
            count++;
            current = current.next;
        }
        Node tmp = current;
        current = current.next;
        return current.data; */
    }

    public int size()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public Integer[] toArray(){
        Node courent = head;
        Integer[] array = new Integer[size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = courent.data;
            courent = courent.next;
        }
        return array;
       // LinkedList<Integer> linkedlist = new LinkedList<>();
       // Integer[] array = linkedlist.toArray(new Integer[linkedlist.size()]);
      //  return array;
    }

    public boolean isEmpty(){
        if(head == null){
            return true;
        }
        else {
            return false;
        }
    }
}
class test{
    public static void main(String[] args){
        linkedlist linkedList1 = new linkedlist();
        linkedList1.addFirst(0);
        linkedList1.add(1);
        linkedList1.add(3);
        linkedList1.addLast(4);
        linkedList1.add(1,2);
       // linkedList1.remove(3);
        System.out.println(linkedList1.remove(3));
        System.out.println(linkedList1.size());
        Integer list[] = linkedList1.toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]); // 1 2 3
        }
         System.out.println(linkedList1.indexOf(3));
         System.out.println(linkedList1.get(2));
         System.out.println(linkedList1.contains(5));
         linkedList1.remove();
         linkedList1.clear();
        System.out.print(linkedList1.isEmpty());
       /* for (int i = 0; i < linkedList1.size(); i++) {
            System.out.print(linkedList1.get(i)); // 1 2 3
        }*/
    }
}
