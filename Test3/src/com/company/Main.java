//package com.company;
import java.util.Scanner;
import java.util.Date;
import javax.swing.JFrame;

class circle{

    double reduse;
    circle(){
        reduse = 1;
    }
    circle(double r){
        reduse = r;
    }
    double getArea(){
        return Math.PI*reduse*reduse;
    }
    double getMohit(){
     return 2*Math.PI*reduse;
    }
}

class Test {

    public static void main(String[] args) {
        circle c1 = new circle(2);
        circle c2 = new circle();
       // System.out.println("the are of circle with reduse " + c2.reduse +  " is " + c2.getArea());
       // System.out.println("the mohit of circle with reduse " + c2.reduse + " is " + c2.getMohit());
        // write your code here
    }
}

class TV {
    private boolean statuse;
    private int chanel;
    private int valume;

    TV() {
        statuse = true;
        chanel = 1;
        valume = 1;
    }

    TV(boolean s, int c, int v) {
        statuse = s;
        chanel = c;
        valume = v;
    }

    void setChanel(int c) {
        if (statuse = true)
            chanel = c;
    }

    void setValume(int v) {
        if (statuse = true) {
            if (v >= 1 && v <= 9)
                valume = v;
        }
    }

    int getChanel() {
        return chanel;
    }

    int getValume() {
        return valume;
    }

    void inkchanel() {
        if (statuse = true) {
            if (chanel < 9)
                chanel++;
        }
    }

    class testtv {

        public void main(String[] args) {
            Scanner input = new Scanner(System.in);
            TV tv1 = new TV();
            int v = input.nextInt();
            int c = input.nextInt();
            TV tv2 = new TV(true, c, v);
            System.out.println(tv2.getChanel());
            System.out.println(tv2.getValume());
        }
    }
}
 class book {
    private int isbn;
    book(int i){
        isbn = i;
    }
    int getisbn(){
        return isbn;
    }
    void setisbn(int i){
        isbn = i;
    }
}

class testbook {
    static void swich(book b1,book b2){
             int temp =b1.getisbn() ;
            temp = b2.getisbn();
             temp = b1.getisbn();
    }

    public static void main(String[] args) {
        book b1 = new book(124322);
        book b2 = new book(123);
        book b3 = b2;
        System.out.println("the isbn of b2 i " + b2.getisbn());
        // write your code here
    }
}
class student{
  private   String name;
   private long id;
    student(long i,String n){
        name = n;
        id = i;
    }
    String getname(){
        return name;
    }
    long getid(){
        return id;
    }
}
class teststudent{
    public static void main(String[] args){
        student s1 = new student(98243045,"farbod");
        System.out.println();
    }
}

class sample{
    int a;
    int b;
    sample(int c,int d){
        a = c;
        b = d;
    }
    int geta(){
        return a;
    }
    int getb(){
        return b;
    }
}
class testsample{
    static void swich(sample b1,sample b2){
        int temp =b1.geta() ;
        temp = b2.getb();
        temp = b1.geta();
    }
    public static void main(String[] args){
        sample s1 = new sample(10,20);
        sample s2 = new sample(10,20);
        swich(s1,s2);
       // System.out.print();
    }
}



