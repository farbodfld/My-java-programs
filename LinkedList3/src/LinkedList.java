public class LinkedList {
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
        if (this.head == null) {
            this.head = new_node;
           // return true;
        }
       // new_node.next = null;
        else {
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return true;
    }

    public void add(int index , Integer element){
        if(index > this.size()){
            // throw new IndexOutOfBoundsException();
            return;
        }

        if(index == 0){
            this.addFirst(element);
            return;
        }
            Node courent = this.head;
            for (int j = 0; j < index-1 ; j++) {
                courent = courent.next;
            }
            if (courent.next == null) {
                Node newnode = new Node(element);
                courent.next = newnode;
            }else {
                Node new_node = new Node(element);
                new_node.next = courent.next;
                courent.next = new_node;
            }
    }

    public boolean addAll(LinkedList linkedlist){
        addAll(size(),linkedlist);
        return true;
    }

    public boolean addAll(int index, LinkedList linkedlist){
       // Node first = this.head;
        if(this.head == null){
            this.head = linkedlist.head;
        }
       else if(index == 0){
            Node a = linkedlist.head;
            while (a.next != null)
            {
                a = a.next;
            }
            a.next = this.head;
            this.head = linkedlist.head;
        }
       else{
           Node b = this.head;
            for (int i = 0; i < index-1; i++) {
                b = b.next;
            }
            Node c = b.next;
            b.next = linkedlist.head;
            while (b.next != null){
                b = b.next;
            }
            b.next = c;
        }
        return true;
    }

    public void addFirst(Integer element)
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
            if (courent.data == i) {
                return true;
            }
            courent = courent.next;
        }
        return false;
    }

    public Integer get(int index){
        if(head == null){
            return null;
        }
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
        return null;
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

    public Integer remove(){
        Node tmp = null;
        if(head != null) {

             tmp = head;
            head = head.next;
            // temp = null;
        }
        return tmp.data;
    }

    public Integer remove(int index){
        int a = 0;
        Node temp = head , prev = null;
       // Node temp = null;
       // Node corent = null;
        if(index >= 0 && index < size()){
            Node corent = head;
            for (int i = 0; i < index; i++) {
                corent = corent.next;
            }
            if(temp != null && temp.data == corent.data){
                head = temp.next;
                a  = corent.data;
                return a;
            }
            while (temp != null && temp.data != corent.data)
            {
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            a = corent.data;
           /* temp = corent;
            corent = corent.next;
            // temp = null;
           // a = temp.data; */
        }
        return a;
    }

    public int size() {
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
        Integer[] arrey = new Integer[size()];
        for (int i = 0; i < arrey.length; i++) {
            arrey[i] = courent.data;
            courent = courent.next;
        }
        return arrey;
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

class Main{
    public static void main(String[] args){
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addFirst(0);
        linkedList1.add(1);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.addLast(4);
        linkedList1.add(1,2);
        System.out.println(linkedList1.remove());
        System.out.println(linkedList1.remove(2));
        System.out.println(linkedList1.size());
        Integer list[] = linkedList1.toArray();
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]); // 0 1 2 3 4
        }

        System.out.println("");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAll(linkedList1);
        linkedList2.add(5);
        linkedList2.add(6);
        linkedList2.add(7);
        linkedList1.addAll(1,linkedList2);
        System.out.println(linkedList2.size());
        Integer list2[] = linkedList2.toArray();
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i]); // 0 1 2 3 4
        }
        System.out.println(linkedList1.indexOf(3));
        linkedList2.get(1);
        System.out.println(linkedList2.get(1));
        System.out.println(linkedList2.contains(4));
        linkedList1.clear();
        System.out.print(linkedList1.isEmpty());
       /* for (int i = 0; i < linkedList1.size(); i++) {
            System.out.print(linkedList1.get(i)); // 1 2 3
        }*/
    }
}