public class person {
        String name;

        public person() {
            name = "farbod";
        }
        void printname(){
            System.out.println(name);
        }
    }
    class student extends person{
        int sid;
        public student(){
            sid = 35655;
        }
        void printsid(){
            System.out.println(sid);
        }
    }
    class gradstudent extends student {
        int term;
        public gradstudent(){
            term = 2;
        }
        void printterm(){
            System.out.println(term);
        }
    }
    class test{
        public static void main(String[] args) {
            person p1 = new person();
            student p2 = new student();
            gradstudent p3 = new gradstudent();
            p3.printsid();
            p1.printname();
            // write your code here
        }
}
