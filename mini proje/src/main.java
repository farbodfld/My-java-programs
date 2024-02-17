import java.util.Scanner;

class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("first of all make admin account!");
        admin Admin = new admin();
        System.out.println("do you want to login?");
        String a = input.next();
        if (a.contains("yes")) {
            Admin.login();
        }
        while (true) {
            System.out.println("Welcome! please tell us who are you?");
            System.out.println("if you are admin and want to login to your account please type: i am admin");
            System.out.println("if you are producer please type: i am tk");
            System.out.println("if you are postman please type: i am barbar");
            System.out.println("if you are client please type: i am moshtari");
            System.out.println("if you want to exit the Market enter : exit");
            input.nextLine();
            String state = input.nextLine();
            switch (state) {
                case "i am admin":
                    Admin.login();
                    break;
                case "i am tk":
                    System.out.println("sign in or sign up!");
                    String aw = input.nextLine();
                    if (aw.contains("sign in")) {
                        tolidkonande.enteruserandpass();
                    } else if (aw.contains("sign up")) {
                        System.out.println("wait until admin gives you a user and pass");
                        Admin.login();
                        break;
                    }
                    System.out.println("do you want to make new products?");
                    String awnser4 = input.next();
                    if (awnser4.contains("yes")) {
                        tolidkonande.tolidajnas();
                    }
                    System.out.println("do you want to add your products?");
                    String awnser = input.next();
                    if (awnser.contains("yes")) {
                        /*TK*/
                        tolidkonande.ezafekardankala();
                    }
                    System.out.println("do you want to remove your products?");
                    String awnser2 = input.next();
                    if (awnser2.contains("yes")) {
                        /*TK*/
                        tolidkonande.hazfkardankala();
                    }
                    System.out.println("do you want to discount your products?");
                    String awnser3 = input.next();
                    if (awnser3.contains("yes")) {
                        /*TK*/
                        tolidkonande.discount();
                    }
                    System.out.println("do you want to see your status?");
                    String awnser6 = input.next();
                    if (awnser6.contains("yes")) {
                        /*TK*/
                        System.out.println("your income is : " + tolidkonande.getSood());
                        System.out.println("your product which is sold is : ");
                        for (int i = 0; i < moshtari.ajnasekharidarishode.size(); i++) {
                            System.out.println(moshtari.ajnasekharidarishode.get(i));
                        }
                    }
                    break;
                case "i am barbar":
                    System.out.println("sign in or sign up!");
                    String aw2 = input.nextLine();
                    if (aw2.contains("sign in")) {
                        barbar.enteruserandpass();
                    } else if (aw2.contains("sign up")) {
                        System.out.println("wait until admin gives you a user and pass");
                        Admin.login();
                        break;
                    }
                    System.out.println("which category do yo want? \n1)sefareshat moshtariha \n2)marsoolate dar hale ersal \n3)sefareshat ersal shode \n4)taghyire vasileye naghlie");
                    // input.next();
                    int javab = input.nextInt();
                    if (javab == 1) {
                        barbar.sefareshemoshtariha();
                    } else if (javab == 2) {
                        barbar.marsoolatedarhaleersal();
                    } else if (javab == 3) {
                        barbar.Sefareshatersalshode();
                    } else if (javab == 4) {
                        barbar.taghyirvasilenaghlie();
                    }
                    System.out.println("do you want to see your status?");
                    String javab2 = input.next();
                    if (javab2.equals("yes")) {
                        System.out.println("your hajme jabe ja shode is :" + barbar.hajmesefareshat);
                        System.out.println("your liste jabe ja shode is :");
                        for (int i = 0; i < barbar.sefareshatersalshode.size(); i++) {
                            System.out.println(barbar.sefareshatersalshode.get(i));
                        }
                    }
                    break;
                case "i am moshtari":
                    System.out.println("sign in or sign up!");
                    String aw3 = input.nextLine();
                    if (aw3.contains("sign in")) {
                        System.out.println("please enter your user and pass!");
                        String u = input.nextLine();
                        String p = input.next();
                        while (true) {
                            if (moshtari.listeuserandpass[0].equals(u) && moshtari.listeuserandpass[1].equals(p)) {
                                System.out.println("welcome");
                                break;
                            } else {
                                System.out.println("invalid username");
                                u = input.next();
                                p = input.next();
                            }
                        }
                    } else if (aw3.contains("sign up")) {
                        moshtari.setmoshtari();
                    }
                    System.out.println("which one of the list do you want? \n1)tolid konande ha \n2)daste bandi ajnas \n3)ajnase kharidari shode \n4)ajnase dar dastoor e ersal");

                    int pasokh5 = input.nextInt();
                    if (pasokh5 == 1) {
                        moshtari.showlist();
                    } else if (pasokh5 == 2) {
                        moshtari.showdastebandiajnas();
                    } else if (pasokh5 == 3) {
                        moshtari.showlistekharidarishode();
                    } else if (pasokh5 == 4) {
                        moshtari.showsafeersal();
                    }
                    System.out.println("do you want to see your status?");
                    String javab3 = input.next();
                    if (javab3.equals("yes")) {
                        System.out.println("your payment is :" + moshtari.kharjemoshtari);
                        System.out.println("your cart is :");
                        for (int i = 0; i < moshtari.ajnasekharidarishode.size(); i++) {
                            System.out.println(moshtari.ajnasekharidarishode.get(i));
                        }
                    }
                    break;
                case "exit":
                    return;
            }
        }

    }
}