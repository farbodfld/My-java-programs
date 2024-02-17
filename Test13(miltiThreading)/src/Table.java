public class Table {

    public /*synchronized*/ void printTable(int n){
        synchronized (this) {
            for (int i = 1; i < 6; i++) {
                System.out.print(n * i + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class MyThread1 extends Thread{
    Table t;

    public MyThread1(Table table){
        this.t = table;
    }

    public void run(){
        t.printTable(5);
    }
}

class MyThread2 extends Thread{
    Table t;

    public MyThread2(Table table){
        this.t = table;
    }

    public void run(){
        t.printTable(10);
    }
}

class TestSynch{
    public static void main(String[] args){
        Table t = new Table();
        MyThread1 mt = new MyThread1(t);
        MyThread2 mt2 = new MyThread2(t);

        mt.start();
        mt2.start();
    }
}