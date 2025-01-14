import java.util.Scanner;

public class BankersAlgorithm_237 {
    static int[][] allocation, max, need;
    static int[] available;
    static int numProcesses, numResources;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        numProcesses = sc.nextInt();
        System.out.print("Enter the number of resources: ");
        numResources = sc.nextInt();

        allocation = new int[numProcesses][numResources];
        max = new int[numProcesses][numResources];
        need = new int[numProcesses][numResources];
        available = new int[numResources];

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Process " + (i + 1) + ":");
            for (int j = 0; j < numResources; j++) {
                System.out.print(" Maximum value for resource " + (j + 1) + " (in x:y format): ");
                max[i][j] = parseInput(sc.next());
            }
            for (int j = 0; j < numResources; j++) {
                System.out.print(" Allocated from resource " + (j + 1) + " (in x:y format): ");
                allocation[i][j] = parseInput(sc.next());
            }
        }

        for (int i = 0; i < numProcesses; i++) {
            for (int j = 0; j < numResources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        for (int i = 0; i < numResources; i++) {
            System.out.print("Enter total value of resource " + (i + 1) + " (in x:y format): ");
            available[i] = parseInput(sc.next());
        }

        if (isSafe()) {
            System.out.println("The System is currently in a safe state and the safe sequence is:");
        } else {
            System.out.println("The system is not in a safe state.");
        }

        sc.close();
    }

    private static int parseInput(String input) {
        String[] parts = input.split(":");
        return Integer.parseInt(parts[1]);
    }

    private static boolean isSafe() {
        boolean[] finished = new boolean[numProcesses];
        int[] work = available.clone();
        int[] safeSequence = new int[numProcesses];
        int count = 0;

        while (count < numProcesses) {
            boolean found = false;
            for (int i = 0; i < numProcesses; i++) {
                if (!finished[i]) {
                    boolean canAllocate = true;
                    for (int j = 0; j < numResources; j++) {
                        if (need[i][j] > work[j]) {
                            canAllocate = false;
                            break;
                        }
                    }
                    if (canAllocate) {
                        for (int j = 0; j < numResources; j++) {
                            work[j] += allocation[i][j];
                        }
                        safeSequence[count++] = i + 1;
                        finished[i] = true;
                        found = true;
                    }
                }
            }
            if (!found) {
                return false;
            }
        }

        System.out.print("< ");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("P" + safeSequence[i] + " ");
        }
        System.out.println(">");

        return true;
    }
}