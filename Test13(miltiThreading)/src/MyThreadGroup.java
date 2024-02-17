public class MyThreadGroup implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args){
        ThreadGroup tg1 = new ThreadGroup("Group farbod");
        Thread m = new Thread(tg1,new MyThreadGroup(),"one");
        Thread m2 = new Thread(tg1,new MyThreadGroup(),"two");
        Thread m3 = new Thread(tg1,new MyThreadGroup(),"three");

        m.start();
        m2.start();
        m3.start();
        tg1.list();
    }
}
