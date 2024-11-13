#include <iostream>
#include <vector>
#include <iomanip>
using namespace std;

struct Process {
int id;
int arrivalTime;
int burstTime;
int waitingTime = 0;
int turnAroundTime = 0;
};

void calculateFCFS(vector<Process>& processes) {
int currentTime = 0;
float totalWaitingTime = 0, totalTurnAroundTime = 0;

for (auto& process : processes) {

if (currentTime < process.arrivalTime) {
currentTime = process.arrivalTime;
}

process.waitingTime = currentTime - process.arrivalTime;
process.turnAroundTime = process.waitingTime + process.burstTime;

currentTime += process.burstTime;
totalWaitingTime += process.waitingTime;
totalTurnAroundTime += process.turnAroundTime;
}

cout << "FCFS Scheduling:\n";
for (const auto& process : processes) {
cout << "Process " << process.id << ": Waiting Time: " << process.waitingTime
<< " Turnaround Time: " << process.turnAroundTime << endl;
}
cout << fixed << setprecision(2);
cout << "Average Waiting time: " << totalWaitingTime / processes.size() << endl;
cout << "Average Turnaround time: " << totalTurnAroundTime / processes.size() << endl;
}

int main() {
int numProcesses;
cout << "Enter the number of processes: ";
cin >> numProcesses;

vector<Process> processes(numProcesses);
cout << "Enter the CPU times:\n";
for (int i = 0; i < numProcesses; i++) {
cin >> processes[i].burstTime;
processes[i].id = i + 1;
}

cout << "Enter the arrival times:\n";
for (int i = 0; i < numProcesses; i++) {
cin >> processes[i].arrivalTime;
}

sort(processes.begin(), processes.end(), [](const Process& a, const Process& b) {
return a.arrivalTime < b.arrivalTime;
});

calculateFCFS(processes);

return 0;
}
