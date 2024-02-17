import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Round_Robin {
    int NUMBER_OF_PROCESS, QUANTUM_TIME, TIMER = 0, maxProcessIndex = 0;
    float AVG_waitingTime = 0;

    int[] arrival_time;
    int[] burst_time;
    int[] temp_burst;
    int[] wait_time;
    int[] turn;
    int[] queue;
    int[] timer;
    boolean[] complete;

    public Round_Robin(int number_of_number, int quantum_time) {
        this.NUMBER_OF_PROCESS = number_of_number;
        this.QUANTUM_TIME = quantum_time;

        arrival_time = new int[NUMBER_OF_PROCESS];
        burst_time = new int[NUMBER_OF_PROCESS];
        temp_burst = new int[NUMBER_OF_PROCESS];
        wait_time = new int[NUMBER_OF_PROCESS];
        turn = new int[NUMBER_OF_PROCESS];
        queue = new int[NUMBER_OF_PROCESS];
        complete = new boolean[NUMBER_OF_PROCESS];
        timer = new int[NUMBER_OF_PROCESS];
    }

    public void initialize(int[] arrivalTime, int[] burstTime) {
        for (int i = 0; i < NUMBER_OF_PROCESS; i++) {
            /** Get the arrival and burst time from the file. */
            arrival_time[i] = arrivalTime[i];
            burst_time[i] = burstTime[i];
            temp_burst[i] = burst_time[i];

            /**Initializing the queue and complete array. */
            complete[i] = false;
            queue[i] = 0;
        }
    }

    public void run() {
        while (TIMER < arrival_time[0])
            TIMER++;
        queue[0] = 1;

        while (true) {
            boolean end_flag = true;
            for (int i = 0; i < NUMBER_OF_PROCESS; i++) {
                if (temp_burst[i] != 0) {
                    end_flag = false;
                    break;
                }
            }

            if (end_flag)
                break;

            for (int i = 0; (i < NUMBER_OF_PROCESS) && (queue[i] != 0); i++) {

                /** process is getting CPU until quantum time ends or it's burst time ends. */
                int current_time_quantum = 0;
                while ((current_time_quantum < QUANTUM_TIME) && (temp_burst[queue[0] - 1] > 0)) {
                    temp_burst[queue[0] - 1] -= 1;
                    TIMER += 1;
                    current_time_quantum--;

                    /** check for new arrival and update te he ready queue until all processes arrive. */
                    CheckNewArrival(TIMER, arrival_time, NUMBER_OF_PROCESS, maxProcessIndex, queue);
                }

                /** store the exit times and make the tasks completed. */
                if ((temp_burst[queue[0] - 1] == 0) && (complete[queue[0] - 1] == false)) {
                    turn[queue[0] - 1] = TIMER;     //turn currently stores exit times.
                    complete[queue[0] - 1] = true; // task completed.
                }

                /** check if CPU is idle or not! */
                boolean idle = true;
                if (queue[NUMBER_OF_PROCESS - 1] == 0) {
                    for (int k = 0; k < NUMBER_OF_PROCESS && queue[k] != 0; k++) {
                        if (complete[queue[k] - 1] == false) {
                            idle = false;
                        }
                    }
                } else
                    idle = false;

                if (idle) {
                    TIMER++;
                    CheckNewArrival(TIMER, arrival_time, NUMBER_OF_PROCESS, maxProcessIndex, queue);
                }

                /** Maintaining the entries of processes after each preemption in the ready Queue. */
                QueueMaintainer(queue, NUMBER_OF_PROCESS);
            }
        }

        for (int i = 0; i < NUMBER_OF_PROCESS; i++) {
            turn[i] = turn[i] - arrival_time[i];
            wait_time[i] = turn[i] - burst_time[i];
        }

        for (int i = 0; i < NUMBER_OF_PROCESS; i++) {
            AVG_waitingTime += wait_time[i];
        }

        System.out.print("\nAverage wait time : " + (AVG_waitingTime / NUMBER_OF_PROCESS));
    }

    private void QueueMaintainer(int[] queue, int number_of_process) {
        for (int i = 0; (i < number_of_process - 1) && (queue[i + 1] != 0); i++) {
            int temp = queue[i];
            queue[i] = queue[i + 1];
            queue[i + 1] = temp;
        }
    }

    private void CheckNewArrival(int timer, int[] arrival_time, int number_of_process, int maxProcessIndex, int[] queue) {
        if (timer <= arrival_time[number_of_process - 1]) {
            boolean newArrival = false;
            for (int i = maxProcessIndex + 1; i < number_of_process; i++) {
                if (arrival_time[i] <= timer) {
                    if (maxProcessIndex < i) {
                        maxProcessIndex = i;
                        //timer[i] = TIMER;
                        newArrival = true;
                    }
                }
            }
            if (newArrival) //adds the index of the arriving process
                QueueUpdate(queue, timer, arrival_time, number_of_process, maxProcessIndex);
        }
    }

    private void QueueUpdate(int[] queue, int timer, int[] arrival_time, int number_of_process, int maxProcessIndex) {
        int zeroIndex = -1;
        for (int i = 0; i < number_of_process; i++) {
            if (queue[i] == 0) {
                zeroIndex = i;
                break;
            }
        }
        if (zeroIndex == -1)
            return;
        queue[zeroIndex] = maxProcessIndex + 1;
    }
}