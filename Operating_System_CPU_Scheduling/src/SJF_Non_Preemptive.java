import java.util.Scanner;

public class SJF_Non_Preemptive {
    int n; // number of process
    int[] pid; // pid means process id
    int[] at; // at means arrival time
    int[] bt; // bt means burst time
    int[] ct; // ct means complete time
    int[] ta; // ta means turn around time
    int[] wt; // wt means waiting time
    int[] completed_flag; // flag that checks process is completed or not
    int st = 0, tot = 0;
    float AvgWt = 0, AvgTa = 0;

    public SJF_Non_Preemptive(int process_number) {
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
            /** Get the arrival and burst time from the file. */
            at[i] = arrivalTime[i];
            bt[i] = burstTime[i];

            pid[i] = i + 1;
            completed_flag[i] = 0;
        }
    }

    public void run() {
        while (true) {
            int c = n, min = 999;
            if (tot == n) // total no of process = completed process loop will be terminated
                break;
            for (int i = 0; i < n; i++) {
                /*
                 * If i'th process arrival time <= system time and its flag=0 and burst<min
                 * That process will be executed first
                 */
                if ((at[i] <= st) && (completed_flag[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }
            /* If c==n means c value can not updated because no process arrival time< system time so we increase the system time */
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                completed_flag[c] = 1;
                tot++;
            }
        }
        System.out.println("\npid  arrival burst  complete turn waiting");
        for (int i = 0; i < n; i++) {
            AvgWt += wt[i];
            AvgTa += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\naverage tat is " + (AvgTa / n));
        System.out.println("average wt is " + (AvgWt / n));
    }
}