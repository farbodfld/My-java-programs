public class Multi7 extends Thread{
    @Override
    public void run() {
        System.out.println("Running");
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){
        Multi7 m = new Multi7();
        Multi7 m2 = new  Multi7();

        System.out.println(m.getName() + " " + m.getId());
        System.out.println(m2.getName() + " " + m2.getId());

        m.setName("farbod");
        m2.setName("fld");

        m.start();
        m2.start();
    }
}
