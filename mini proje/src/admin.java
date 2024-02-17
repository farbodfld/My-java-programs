import java.util.Scanner;

class admin {
    static private String username;
    static private int password;
    static public String viecle;
    static private String tkuser;
    static private long tkpass;
    static private String bbuser;
    static private long bbpass;

    public admin() {
        Scanner input = new Scanner(System.in);
        System.out.println("set your username");
        username = input.nextLine();
        System.out.println("set your password");
        password = input.nextInt();
    }

    public static void settkuserandpass() {
        Scanner input = new Scanner(System.in);
        // System.out.println("set your barbar user and pass and viecle");
        System.out.println("set your tk username");
        tkuser = input.nextLine();
        System.out.println("set your tk password");
        tkpass = input.nextInt();
    }

    public static long gettkPassword() {
        return tkpass;
    }

    public static String gettkUsername() {
        return tkuser;
    }

    public static void setbbuserandpass() {
        Scanner input = new Scanner(System.in);
        System.out.println("set your barbar user");
        bbuser = input.nextLine();
        System.out.println("set your barbar password");
        bbpass = input.nextInt();
        System.out.println("set your barbar viecle");
        System.out.println("chose his viecle of motor or khodro or vanet");
        String viecle2 = input.next();
        if (viecle2.contains("motor")) {
            viecle = viecle2;
        }
        if (viecle2.contains("khodro")) {
            viecle = viecle2;
        }
        if (viecle2.contains("vanet")) {
            viecle = viecle2;
        }
    }

    public static long getbbPassword() {
        return bbpass;
    }

    public static String getbbUsername() {
        return bbuser;
    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your username");
        String a = input.nextLine();
        System.out.println("enter your password");
        int b = input.nextInt();
        if (a.contains(username) && b == password) {
            System.out.println("wellcome");
        } else {
            System.out.println("please try again");
            login();
        }
        while (true) {
            System.out.println("for making producer acount enter: tk");
            System.out.println("for making postman acount enter: bb");
            System.out.println("or if you want to do somthing else enter: next");
            String jv = input.next();
            if (jv.contains("tk")) {
                tolidkonande tk = new tolidkonande();
                admin.settkuserandpass();
                tk.addtolidkonande();
            } else if (jv.contains("bb")) {
                barbar bb = new barbar();
                admin.setbbuserandpass();
                bb.addbarbar();
            } else if (jv.contains("next")) {
                System.out.println("for see sood of producer enter: show sood");
                System.out.println("for see producer's money spent enter: show kharje moshtari");
                System.out.println("for see hajme jabeja shode of producer enter: show hajme jabeja shode");
                System.out.println("or if you want to log out enter : log out");
                amarvaargham ava = new amarvaargham();
                input.nextLine();
                String jv2 = input.nextLine();
                if (jv2.contains("show sood")) {
                    System.out.println("your producer's income is : " + tolidkonande.getSood());
                } else if (jv2.contains("show kharje moshtari")) {
                    System.out.println("your costumer's payment is : " + ava.showkharjemoshtari());
                } else if (jv2.contains("show hajme jabeja shode")) {
                    ava.showhajmejabejashode();
                    System.out.println("your postman's displaced volume is : " + ava.showhajmejabejashode());
                } else if (jv2.contains("log out")) {
                    return;
                }
            }
        }
    }

    public static int getPassword() {
        return password;
    }

    public void setPassword() {
        Scanner input = new Scanner(System.in);
        this.password = input.nextInt();//password;
    }

    public static String getUsername() {
        return username;
    }

    public void setUsername() {
        Scanner input = new Scanner(System.in);
        this.username = input.nextLine();//username;
    }

}