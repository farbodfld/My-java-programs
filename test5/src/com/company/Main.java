class person {
    String name;

    public person() {
        name = "farbod";
    }
    void printname(){
            System.out.println(name);
        System.out.println("The person constructor is called");
        }
}
    class student extends person{
        int sid;
       public student(){
            sid = 35655;
        }
        void printsid(){
            System.out.println(sid);
            System.out.println("The student constructor is called");
        }
    }
    class gradstudent extends student {
        int term;
       public gradstudent(){
            term = 2;
        }
        void printterm(){
            System.out.println(term);
            System.out.println("The gradstudent constructor is called");
        }
}
class test{
    public static void main(String[] args) {
            person p1 = new person();
            student p2 = new student();
            gradstudent p3 = new gradstudent();
           // p1.printname();
           // p2.printsid();
            p3.printname();

        // write your code here
    }
}
class bankk{
    int getintrest(){
        return 5;
    }
}
class parsianbank extends bankk{
    int getintrest(){
        return 8;
    }
}
class melianbank extends bankk{
    int getintrest(){
        return 4;
    }
}
class Test{
    public static void main(String[] args) {
        bankk b1 = new bankk();
        parsianbank b2 = new parsianbank();
        melianbank b3 = new melianbank();
        System.out.println(b1.getintrest());
        System.out.println(b2.getintrest());
        System.out.println(b3.getintrest());
    }
}
class animal{
    String name = "cutie";
    void display(){
        System.out.println("animal is created");
    }
    void printname(){
        System.out.println(name);
    }
}
class cat extends animal{
    String color = "white";
    void display(){
        System.out.println("cat is created");
    }
    void printcolor(){
        System.out.println(color);
    }
}
class dog extends animal{
    double wheit = 5;
    void printwheit(){
        System.out.println(wheit);
    }
}
class babycat extends cat{
    double size = 10;
    void display(){
        System.out.println("a babycat is created");
    }
    void printsize(){
        System.out.println(size);
    }
}
class Teest{
    public static void main(String[] args) {
        babycat bc1 = new babycat();
        bc1.display();
     //   bc1.printsize();
       // bc1.printcolor();
       // bc1.printname();
        cat c1 = new cat();
        c1.display();
        c1.printcolor();
        c1.printname();
        dog d1 = new dog();
        d1.printwheit();
        d1.printname();
        d1.display();
        animal a1 = new animal();
        a1.display();
        cat bc2 = new babycat();
        Object o1 = new animal();
        Object o2 = new dog();
        Object o3 = new cat();
        Object o4 = new babycat();
        show(o4);
    }
    static void show(Object o){
        if(o instanceof babycat){
            babycat bc = (babycat) o;
        }
        else if(o instanceof cat){
            cat c = (cat) o;
        }
        else if(o instanceof dog){
            dog d = (dog) o;
        }
        else{
            animal a = (animal) o;
        }
    }
}