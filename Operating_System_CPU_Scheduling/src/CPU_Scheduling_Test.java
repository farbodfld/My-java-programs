import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CPU_Scheduling_Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\lenovo\\IdeaProjects\\Operating_System_CPU_Scheduling\\src\\test.txt");
        Scanner in = new Scanner(file);
        String mode;
        List<String> modes = new ArrayList<>();
        int processNumber;
        int[] arrivalTime;
        int[] burstTime;
        int quantumTime;

        while (in.hasNext()) {
            mode = in.next();
            modes.add(mode);
        }

        switch (modes.get(0)) {
            case "RR": {
                quantumTime = Integer.parseInt(modes.get(1));
                processNumber = Integer.parseInt(modes.get(2));
                arrivalTime = new int[processNumber];
                burstTime = new int[processNumber];
                int j = 0;
                for (int i = 4; i < modes.size(); i += 4) {
                    arrivalTime[j] = Integer.parseInt(modes.get(i));
                    j++;
                }

                int k = 0;
                for (int i = 5; i < processNumber; i += 5) {
                    burstTime[k] = Integer.parseInt(modes.get(i));
                    k++;
                }

                Round_Robin RR = new Round_Robin(processNumber, quantumTime);
                RR.initialize(arrivalTime, burstTime);
                RR.run();

                FileWriter fw = new FileWriter("output.txt");
                fw.write(modes.get(0));
                fw.write(" ");
                fw.write(modes.get(1));
                for (int i = 0; i < processNumber; i++) {
                    int t = RR.TIMER;
                    fw.write(t);
                    fw.write("\t");
                    fw.write(i);
                }
                break;
            }
            case "PR_withPREMP": {
                processNumber = Integer.parseInt(modes.get(1));
                arrivalTime = new int[processNumber];
                burstTime = new int[processNumber];
                int j = 0;
                for (int i = 3; i < modes.size(); i += 4) {
                    arrivalTime[j] = Integer.parseInt(modes.get(i));
                    j++;
                }

                int k = 0;
                for (int i = 4; i < processNumber; i += 5) {
                    burstTime[k] = Integer.parseInt(modes.get(i));
                    k++;
                }

                SJF_Preemptive withPREMP = new SJF_Preemptive(processNumber);
                withPREMP.initialize(arrivalTime, burstTime);
                withPREMP.run();

                FileWriter fw = new FileWriter("output.txt");
                fw.write(modes.get(0));
                fw.write("\n");
                for (int i = 0; i < processNumber; i++) {
                    int t = withPREMP.st;
                    fw.write(t);
                    fw.write("\t");
                    fw.write(i);
                    fw.write("\n");
                }
                break;
            }
            case "PR_noPREMP": {
                processNumber = Integer.parseInt(modes.get(1));
                arrivalTime = new int[processNumber];
                burstTime = new int[processNumber];
                int j = 0;
                for (int i = 3; i < modes.size(); i += 4) {
                    arrivalTime[j] = Integer.parseInt(modes.get(i));
                    j++;
                }

                int k = 0;
                for (int i = 4; i < processNumber; i += 5) {
                    burstTime[k] = Integer.parseInt(modes.get(i));
                    k++;
                }

                SJF_Non_Preemptive noPREMP = new SJF_Non_Preemptive(processNumber);
                noPREMP.initialize(arrivalTime, burstTime);
                noPREMP.run();

                FileWriter fw = new FileWriter("output.txt");
                fw.write(modes.get(0));
                fw.write("\n");
                for (int i = 0; i < processNumber; i++) {
                    int t = noPREMP.st;
                    fw.write(t);
                    fw.write("\t");
                    fw.write(i);
                    fw.write("\n");
                }
                break;
            }
        }
        in.close();
    }
}
