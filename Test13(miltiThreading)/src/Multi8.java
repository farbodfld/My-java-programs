public class Multi8 extends Thread{

    public void run(){
        System.out.println("running thread name is: " + getName());
        System.out.println("running thread priority is: " + getPriority());
    }

    public static void main(String[] args){
        Multi8 m = new Multi8();
        Multi8 m2 = new Multi8();
        Multi8 m3 = new Multi8();

        m2.setPriority(Thread.MIN_PRIORITY);
        m3.setPriority(Thread.MAX_PRIORITY);

        m.start();
        m2.start();
        m3.start();
    }
}
