import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sets {
    static String out;
    static ArrayList<String> finalOut = new ArrayList<String>();
    static void combinationUtil(int arr[], int n, int r, int index, int data[], int i) {
        if (index == r) {
            out+="{";
            for (int j = 0; j < r; j++) {
                if (j!=r-1) {
                    out+=data[j] + ",";
                }
                else {
                    out+=data[j];
                }
            }
            out+="}";
            finalOut.add(out);
            out="";
            return;
        }
        if (i >= n)
            return;
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1,data, i + 1);
        combinationUtil(arr, n, r, index, data, i + 1);
    }
    static void printCombination(int arr[], int n, int r) {
        int data[] = new int[r];
        combinationUtil(arr, n, r, 0, data, 0);
    }
    static boolean ifContains(int a[],int m)  {
        for (int i : a) {
            if (i==m) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Set<Integer> first = new TreeSet<Integer>();
        Set<Integer> second = new TreeSet<Integer>();
        Scanner scan = new Scanner (System.in);
        String aa,bb;
        aa=scan.nextLine();
        int aaa = Integer.parseInt(aa);
        String[] firstLine;
        if (aaa==0) {
            //scan.nextLine();
            firstLine = new String[0];
        }
        else{
            firstLine = scan.nextLine().split(" ");
        }
        bb=scan.nextLine();
        int bbb = Integer.parseInt(bb);
        String[] secondLine;
        if (bbb==0) {
            //scan.nextLine();
            secondLine = new String[0];
        }
        else{
            secondLine = scan.nextLine().split(" ");
        }
        if (aaa!=0 && bbb!=0) {
            for (String i : firstLine) {
                first.add(Integer.parseInt(i));
            }
            for (String i : secondLine) {
                second.add(Integer.parseInt(i));
            }
            scan.close();
            int[] f = new int[first.size()];
            int[] s = new int[second.size()];
            int k1=0,k2=0;
            for (Integer i : first) {
                f[k1]=i;
                k1++;
            }
            for (Integer i : second) {
                s[k2]=i;
                k2++;
            }



            //subset

            for (int i = 0; i <= f.length; i++) {
                printCombination(f, f.length, i);
            }
            ArrayList<String> firstSubsets = new ArrayList <String>(finalOut);
            finalOut.removeAll(finalOut);
            for (int i = 0; i <= s.length; i++) {
                printCombination(s, s.length, i);
            }
            ArrayList<String> secondSubsets = new ArrayList <String>(finalOut);
            finalOut.removeAll(finalOut);

            firstSubsets.set(0, "{}");
            System.out.print("A -> ");
            for (int i = 0; i < firstSubsets.size(); i++) {
                System.out.print(firstSubsets.get(i));
                if (i!=firstSubsets.size()-1) {
                    System.out.print(" , ");
                }
            }
            System.out.println();
            System.out.print("B -> ");
            for (int i = 0; i < secondSubsets.size(); i++) {
                System.out.print(secondSubsets.get(i));
                if (i!=secondSubsets.size()-1) {
                    System.out.print(" , ");
                }
            }
            System.out.println();

            Set<Integer> sumOfSets = new TreeSet <Integer>();
            for (Integer i : f) {
                sumOfSets.add(i);
            }
            for (Integer i : s) {
                sumOfSets.add(i);
            }


            //A⋃B
            System.out.print("A⋃B:{");
            Integer[] sum = new Integer[sumOfSets.size()];
            sumOfSets.toArray(sum);
            for (int i = 0; i < sumOfSets.size(); i++) {
                System.out.print(sum[i]);
                if (i!=sumOfSets.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");


            //A⋂B
            ArrayList<Integer> eshterak = new ArrayList<Integer>();
            for (Integer i : sum) {
                if (ifContains(f, i) && ifContains(s, i)) {
                    eshterak.add(i);
                }
            }

            System.out.print("A⋂B:{");
            Integer[] esh = new Integer[eshterak.size()];
            eshterak.toArray(esh);
            for (int i = 0; i < eshterak.size(); i++) {
                System.out.print(esh[i]);
                if (i!=eshterak.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");

            //A-B

            ArrayList<Integer> A = new ArrayList<Integer>();
            for (Integer i : f) {
                A.add(i);
            }
            for (Integer i : eshterak) {
                A.remove(i);
            }
            //System.out.println("A-B: " + A.toString());

            System.out.print("A-B:{");
            Integer[] minus = new Integer[A.size()];
            A.toArray(minus);
            for (int i = 0; i < A.size(); i++) {
                System.out.print(minus[i]);
                if (i!=A.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");



            //A△B
            for (Integer i : eshterak) {
                sumOfSets.remove(i);
            }
            System.out.print("A△B:{");
            Integer[] sum2 = new Integer[sumOfSets.size()];
            sumOfSets.toArray(sum2);
            for (int i = 0; i < sumOfSets.size(); i++) {
                System.out.print(sum2[i]);
                if (i!=sumOfSets.size()-1) {
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
        else {
            if (aaa==0 && bbb!=0) {
                System.out.println("A -> {}");
                for (String i : secondLine) {
                    second.add(Integer.parseInt(i));
                }
                int[] s = new int[second.size()];
                int k2=0;
                for (Integer i : second) {
                    s[k2]=i;
                    k2++;
                }

                //Subset

                for (int i = 0; i <= s.length; i++) {
                    printCombination(s, s.length, i);
                }
                ArrayList<String> secondSubsets = new ArrayList <String>(finalOut);
                finalOut.removeAll(finalOut);
                secondSubsets.set(0, "{}");
                System.out.print("B -> ");
                for (int i = 0; i < secondSubsets.size(); i++) {
                    System.out.print(secondSubsets.get(i));
                    if (i!=secondSubsets.size()-1) {
                        System.out.print(" , ");
                    }
                }
                System.out.println();

                //A⋃B

                System.out.print("A⋃B:{");
                for (int i = 0; i < s.length; i++) {
                    if (i!=s.length-1) {
                        System.out.print(s[i]+",");
                    }
                    else{
                        System.out.print(s[i]);
                    }
                }
                System.out.println("}");

                //A⋂B

                System.out.println("A⋂B:{}");

                //A-B

                System.out.println("A-B:{}");

                //A△B

                System.out.print("A△B:{");
                for (int i = 0; i < s.length; i++) {
                    if (i!=s.length-1) {
                        System.out.print(s[i]+",");
                    }
                    else{
                        System.out.print(s[i]);
                    }
                }
                System.out.println("}");

            }
            if (aaa!=0 && bbb==0) {
                for (String i : firstLine) {
                    first.add(Integer.parseInt(i));
                }
                int[] f = new int[first.size()];
                int k1=0;
                for (Integer i : first) {
                    f[k1]=i;
                    k1++;
                }

                //Subset

                for (int i = 0; i <= f.length; i++) {
                    printCombination(f, f.length, i);
                }
                ArrayList<String> firstSubsets = new ArrayList <String>(finalOut);
                finalOut.removeAll(finalOut);
                firstSubsets.set(0, "{}");
                System.out.print("A -> ");
                for (int i = 0; i < firstSubsets.size(); i++) {
                    System.out.print(firstSubsets.get(i));
                    if (i!=firstSubsets.size()-1) {
                        System.out.print(" , ");
                    }
                }
                System.out.println();
                System.out.println("B -> {}");

                //A⋃B

                System.out.print("A⋃B:{");
                for (int i = 0; i < f.length; i++) {
                    if (i!=f.length-1) {
                        System.out.print(f[i]+",");
                    }
                    else{
                        System.out.print(f[i]);
                    }
                }
                System.out.println("}");

                //A⋂B

                System.out.println("A⋂B:{}");

                //A-B

                System.out.print("A-B:{");
                for (int i = 0; i < f.length; i++) {
                    if (i!=f.length-1) {
                        System.out.print(f[i]+",");
                    }
                    else{
                        System.out.print(f[i]);
                    }
                }
                System.out.println("}");

                //A△B

                System.out.print("A△B:{");
                for (int i = 0; i < f.length; i++) {
                    if (i!=f.length-1) {
                        System.out.print(f[i]+",");
                    }
                    else{
                        System.out.print(f[i]);
                    }
                }
                System.out.println("}");

            }
            if (aaa==0 && bbb==0) {
                System.out.println("A -> {}");
                System.out.println("B -> {}");
                System.out.println("A⋃B:{}");
                System.out.println("A⋂B:{}");
                System.out.println("A-B:{}");
                System.out.println("A△B:{}");
            }
        }
    }
}