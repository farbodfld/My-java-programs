public interface a {
    void shoemethod();

    void secondmethod();
}
interface b{
    void shoemethod2();

    void secondmethod2();
}
interface c1 extends a,b{
    
}
class c implements a,b{

    @Override
    public void shoemethod() {
        System.out.print("cheked");
    }

    @Override
    public void secondmethod() {
        System.out.print("cheked");
    }

    @Override
    public void shoemethod2() {
        System.out.print("cheked");
    }

    @Override
    public void secondmethod2() {
        System.out.print("cheked");
    }
}
class Main{
    public static void main(String[] args){
        a A = new c();
        b B = new c();
        A.shoemethod();
        A.shoemethod();
        B.secondmethod2();
        B.shoemethod2();
    }
}