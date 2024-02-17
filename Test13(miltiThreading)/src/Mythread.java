public class Mythread implements Runnable {
    private boolean exit;
    private String name;
    Thread t;

    public Mythread(String name) {
        this.name = name;
        t = new Thread(this,name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!exit){
            System.out.println(name + " " + i);
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "stoped");
    }

    public void stop(){
        this.exit = true;
    }
}

class test{
    public static void main(String[] args) throws InterruptedException {
        Thread t  = new Thread(new Mythread("first thread"));
        
        try {
            Thread.sleep(500);
           // t.stop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}