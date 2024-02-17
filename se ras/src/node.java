import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.Arrays;

class tamrin2 {
    static int mod = (int) 1e9 + 7;
    static HashSet<Integer> ver = new HashSet<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph g = new graph(n);
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g.addEdge(u, v);
        }
        for (int i = 0; i < n; i++) {
            if (g.ll[i].size() == 1) {
                g.dfs(i, 0, i);
                break;
            }
        }
        int a = g.a;
        g.a = 0;
        g.max = 0;
        g.dfs(a, 0, a);
        int b = g.a, max = g.max;
        if (max == n - 1) {
            int c;
            for (int i = 0; i < n; i++) {
                if (a != i && b != i) {
                    c = i;
                    System.out.println(n - 1);
                    System.out.println((a + 1) + " " + (b + 1) + " " + (c + 1));
                    return;
                }
            }
        }
        g.dfs2(a, b, a);
        g.a = 0;
        g.max = 0;
        for (int j : ver) {
            if (g.ll[j].size() > 2) {
                for (int k : g.ll[j]) {
                    if (!ver.contains(k)) {
                        g.dfs(k, 1, j);
                    }
                }
            }
        }
        int c = g.a;
        System.out.println(max + g.max);
        int[] array1 = new int[]{a, b, c};
        Arrays.sort(array1);
        System.out.println(array1[0] + 1);
        System.out.println(array1[1] + 1);
        System.out.println(array1[2]);
    }

    static class graph {
        int v;
        int max, a;
        boolean z = false;
        List<Integer>[] ll;

        graph(int v) {
            this.v = v;
            ll = new List[v];
            for (int i = 0; i < v; i++) ll[i] = new LinkedList<>();
        }

        void addEdge(int u, int v) {
            ll[u].add(v);
            ll[v].add(u);
        }

        void dfs(int src, int size, int parent) {
            if (size > max) {
                max = size;
                a = src;
            }
            for (int i : ll[src]) {
                if (i != parent) dfs(i, size + 1, src);
            }
        }

        void dfs2(int src, int des, int parent) {
            if (src == des) {
                z = true;
                ver.add(des);
                return;
            }
            for (int i : ll[src]) {
                if (i != parent) {
                    dfs2(i, des, src);
                    if (z) {
                        ver.add(src);
                        return;
                    }
                }
            }
        }
    }
}
