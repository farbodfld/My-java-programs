import java.util.*;

public class SJF_Preemptive {
    int n;
    int[] pid; // it takes pid of process
    int[] at; // at means arrival time
    int[] bt; // bt means burst time
    int[] ct; // ct means complete time
    int[] ta;// ta means turn around time
    int[] wt;  // wt means waiting time
    int[] completed_flag;  // f means it is flag it checks process is completed or not
    int[] k;   // it is also stores brust time
    int i, st = 0, tot = 0 , c;
    float AvgWt = 0, AvgTa = 0;

    public SJF_Preemptive(int process_number) {
        this.n = process_number;
        pid = new int[n];
        at = new int[n];
        bt = new int[n];
        ct = new int[n];
        ta = new int[n];
        wt = new int[n];
        completed_flag = new int[n];
    }

    public void initialize(int[] arrivalTime, int[] burstTime) {
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
            /** Get the arrival and burst time from the file. */
            at[i] = arrivalTime[i];
            bt[i] = burstTime[i];

            k[i] = bt[i];
            completed_flag[i] = 0;
        }
    }

    public void run() {
        while (true) {
            int min = 999;
            c = n;
            if (tot == n)
                break;

            for (i = 0; i < n; i++) {
                if ((at[i] <= st) && (completed_flag[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }

            if (c == n)
                st++;
            else {
                bt[c]--;
                st++;
                if (bt[c] == 0) {
                    ct[c] = st;
                    completed_flag[c] = 1;
                    tot++;
                }
            }
        }

        for (i = 0; i < n; i++) {
            ta[i] = ct[i] - at[i];
            wt[i] = ta[i] - k[i];
            AvgWt += wt[i];
            AvgTa += ta[i];
        }

        System.out.println("pid  arrival  burst  complete turn waiting");
        for (i = 0; i < n; i++) {
            System.out.println(pid[i] + "\t" + at[i] + "\t" + k[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }

        System.out.println("\naverage tat is " + (AvgTa / n));
        System.out.println("average wt is " + (AvgWt / n));
    }
}