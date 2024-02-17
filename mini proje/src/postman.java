import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class barbar extends admin {
    static barbar[] bb = new barbar[100];
    static String username;
    static long password;
    public String noesefareshat;
    public String namesefareshat;
    static public long hajmesefareshat = 0;
    static List<String> marsoolatedarhaleersal = new ArrayList<>();
    static List<String> sefareshatersalshode = new ArrayList<>();
    static List<String> userlistebb = new ArrayList<>();
    static List<Long> passlistebb = new ArrayList<>();
    static String motor;
    static String vanet;
    static String khodro;

    public barbar() {
        username = admin.getbbUsername();
        password = admin.getbbPassword();
    }

    static int j = 0;

    public void addbarbar() {
        bb[j] = new barbar();
        j++;
    }

    public static void enteruserandpass() {
        Scanner input = new Scanner(System.in);
        //admin.setbbuserandpass();
        System.out.println("enter your username");
        String a = input.nextLine();
        System.out.println("enter your password");
        int b = input.nextInt();
        if (a.contains(username) && b == password) {
            System.out.println("wellcome");
        } else {
            System.out.println("invalid username or password!");
            System.out.println("please try again");
            enteruserandpass();
        }
        userlistebb.add(admin.getbbUsername());
        passlistebb.add(admin.getbbPassword());
    }

    public static void sefareshemoshtariha() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < moshtari.ajnasekharidarishode.size(); i++) {
            System.out.println(moshtari.ajnasekharidarishode.get(i));
        }
        if ((admin.viecle.contains("motor") && khoraki.Hajm == 0.5 || pooshak.hajm == 0.5 || lavazemelctrici.Hajm == 0.5) ||
                (admin.viecle.contains("khodro") && pooshak.hajm == 2 || khoraki.Hajm == 2 || lavazemelctrici.hajm == 2) ||
                (admin.viecle.contains("vanet") && lavazemelctrici.Hajm == 12 || khoraki.Hajm == 12 || pooshak.hajm == 12)) {
            System.out.println("how many ajnas do you want?");
            int n = input.nextInt();
            for (int i = 0; i < n; i++) {
                String selectitem = input.nextLine();
                marsoolatedarhaleersal.add(selectitem);
                moshtari.ajnasekharidarishode.remove(selectitem);
                hajmesefareshat++;
            }
        }
    }

    public static void marsoolatedarhaleersal() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < marsoolatedarhaleersal.size(); i++) {
            System.out.println(marsoolatedarhaleersal.get(i));
            System.out.println("chose item you want to send it");
            String item = input.nextLine();
            marsoolatedarhaleersal.remove(item);
            sefareshatersalshode.add(item);
        }
    }

    public static void Sefareshatersalshode() {
        for (int i = 0; i < sefareshatersalshode.size(); i++) {
            System.out.println(sefareshatersalshode.get(i));
        }
    }

    public static void taghyirvasilenaghlie() {
        Scanner input = new Scanner(System.in);
        System.out.println("which one of viecles do you want?");
        String choseviecle = input.next();
        if (choseviecle.contains("motor")) {
            admin.viecle = motor;
        } else if (choseviecle.contains("vanet")) {
            admin.viecle = vanet;
        } else if (choseviecle.contains("khodro")) {
            admin.viecle = khodro;
        }
    }
}