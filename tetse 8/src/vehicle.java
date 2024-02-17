public abstract class vehicle {
    int speed = 20;

    abstract void showspeed();
}

class bike extends vehicle {

    public void showspeed() {
        System.out.print("speed is " + speed);
    }

    public static void main(String[] args) {
        vehicle v = new bike();
        v.showspeed();
    }
}

interface bank {
    void addincome();

    void showincome();
}

abstract class parsian implements bank {
    int money = 0;

    public void showincome() {
        System.out.print("you don't have income");
    }

    public void addincome() {
        System.out.print("you don't have income");
    }
}

class meli extends parsian {
    public void mojoodi() {
        System.out.print(money);
    }

}

class test {
    public static void main(String[] args) {
        bank m = new meli();
        m.addincome();
        m.showincome();
    }
}