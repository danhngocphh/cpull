/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.cpuScheduling;

/**
 *
 * @author PC
 */
// Java program for implementation of RR scheduling 
  
public class Rr 
{ 
    // Method to find the waiting time for all 
    // processes 
    static void findWaitingTime(int processes[], int n, 
                 int bt[], int wt[], int quantum) 
    { 
        // Make a copy of burst times bt[] to store remaining 
        // burst times. 
        int rem_bt[] = new int[n]; 
        for (int i = 0 ; i < n ; i++) 
            rem_bt[i] =  bt[i]; 
       
        int t = 0; // Current time 
       
        // Keep traversing processes in round robin manner 
        // until all of them are not done. 
        while(true) 
        { 
            boolean done = true; 
       
            // Traverse all processes one by one repeatedly 
            for (int i = 0 ; i < n; i++) 
            { 
                // If burst time of a process is greater than 0 
                // then only need to process further 
                if (rem_bt[i] > 0) 
                { 
                    done = false; // There is a pending process 
       
                    if (rem_bt[i] > quantum) 
                    { 
                        // Increase the value of t i.e. shows 
                        // how much time a process has been processed 
                        t += quantum; 
       
                        // Decrease the burst_time of current process 
                        // by quantum 
                        rem_bt[i] -= quantum; 
                    } 
       
                    // If burst time is smaller than or equal to 
                    // quantum. Last cycle for this process 
                    else
                    { 
                        // Increase the value of t i.e. shows 
                        // how much time a process has been processed 
                        t = t + rem_bt[i]; 
       
                        // Waiting time is current time minus time 
                        // used by this process 
                        wt[i] = t - bt[i]; 
       
                        // As the process gets fully executed 
                        // make its remaining burst time = 0 
                        rem_bt[i] = 0; 
                    } 
                } 
            } 
       
            // If all processes are done 
            if (done == true) 
              break; 
        } 
    } 
       
    // Method to calculate turn around time 
    static void findTurnAroundTime(int processes[], int n, 
                            int bt[], int wt[], int tat[]) 
    { 
        // calculating turnaround time by adding 
        // bt[i] + wt[i] 
        for (int i = 0; i < n ; i++) 
            tat[i] = bt[i] + wt[i]; 
    } 
       
    // Method to calculate average time 
     public String findavgTime(int processes[], int n, int bt[], 
                                         int quantum) 
    { 
        String Send = "";
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
       
        // Function to find waiting time of all processes 
        findWaitingTime(processes, n, bt, wt, quantum); 
       
        // Function to find turn around time for all processes 
        findTurnAroundTime(processes, n, bt, wt, tat); 
       
        // Display processes along with all details 
//        System.out.println("Processes " + " Burst time " + 
//                      " Waiting time " + " Turn around time"); 
       
        // Calculate total waiting time and total turn 
        // around time 
        for (int i=0; i<n; i++) 
        { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
             Send += ";" + processes[i];
//            System.out.printf(" %d ", (i + 1)); 
            Send += ";" + bt[i];
//            System.out.printf("     %d ", bt[i]); 
            Send += ";" + wt[i];
//            System.out.printf("     %d", wt[i]); 
            Send += ";" + tat[i];
//            System.out.printf("     %d\n", tat[i]); 
//            System.out.println(" " + (i+1) + "\t\t" + bt[i] +"\t " + 
//                              wt[i] +"\t\t " + tat[i]); 
        } 
       
//        System.out.println("Average waiting time = " + 
//                          (float)total_wt / (float)n); 
//        System.out.println("Average turn around time = " + 
//                           (float)total_tat / (float)n); 
        return Send;
    } 
      
    // Driver Method 
    public String schRR( String[] words) 
    { 
        int num = Integer.valueOf(words[1]);
        String send = "4;"+num;
        int processes[];
        processes = new int[10];
        int count = 2; 
        int n = num; 
        int burst_time[];
        burst_time = new int[10];
        for (int i = 0; i < num; i++) { 

           processes[i] = Integer.valueOf(words[count]);count++; 

           burst_time[i] = Integer.valueOf(words[count]);count++; 

            
            
        } 
        int quantum = 2; 
       
  
        send +=  findavgTime(processes, n, burst_time, quantum); 

//        for (int i = 0; i < num; i++) { 
//            send = send + ";" +String.valueOf(mat[i][0]);
//            send = send + ";" +String.valueOf(mat[i][1]);
//            send = send + ";" +String.valueOf(mat[i][2]);
//            send = send + ";" +String.valueOf(mat[i][4]);
//            send = send + ";" +String.valueOf(mat[i][5]);
////             mat[i][0], mat[i][1], mat[i][2], mat[i][4], mat[i][5]); 
//        } 
        // process id's 
//        int processes[] = { 1, 2, 3}; 
//        int n = processes.length; 
//       
//        // Burst time of all processes 
//        int burst_time[] = {10, 5, 8}; 
       
        // Time quantum 
        
        return send;
    } 
} 
