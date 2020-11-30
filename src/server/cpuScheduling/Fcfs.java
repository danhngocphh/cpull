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
// Java program for implementation of FCFS  
// scheduling  
  
import java.text.ParseException; 
import static server.cpuScheduling.Sjf.arrangeArrival;
import static server.cpuScheduling.Sjf.completionTime;
import static server.cpuScheduling.Sjf.mat;
  
public class Fcfs { 
  
    // Function to find the waiting time for all  
    // processes  
    static void findWaitingTime(int processes[], int n, 
            int bt[], int wt[]) { 
        // waiting time for first process is 0  
        wt[0] = 0; 
  
        // calculating waiting time  
        for (int i = 1; i < n; i++) { 
            wt[i] = bt[i - 1] + wt[i - 1]; 
        } 
    } 
  
    // Function to calculate turn around time  
    static void findTurnAroundTime(int processes[], int n, 
            int bt[], int wt[], int tat[]) { 
        // calculating turnaround time by adding  
        // bt[i] + wt[i]  
        for (int i = 0; i < n; i++) { 
            tat[i] = bt[i] + wt[i]; 
        } 
    } 
  
    //Function to calculate average time  
     public String findavgTime(int processes[], int n, int bt[]) { 
         String Send = "";
        int wt[] = new int[n], tat[] = new int[n]; 
        int total_wt = 0, total_tat = 0; 
  
        //Function to find waiting time of all processes  
        findWaitingTime(processes, n, bt, wt); 
  
        //Function to find turn around time for all processes  
        findTurnAroundTime(processes, n, bt, wt, tat); 
  
        //Display processes along with all details  
//        System.out.printf("Processes Burst time Waiting"
//                       +" time Turn around time\n"); 
  
        // Calculate total waiting time and total turn  
        // around time  
        for (int i = 0; i < n; i++) { 
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
        } 
        float s = (float)total_wt /(float) n; 
        int t = total_tat / n; 
//        System.out.printf("Average waiting time = %f", s); 
//        System.out.printf("\n"); 
//        System.out.printf("Average turn around time = %d ", t); 
        return Send;
    } 
    
    public String schFcfs( String[] words) { 
       
        int num = Integer.valueOf(words[1]);
        String send = "3;"+num;
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
  
  
        send += findavgTime(processes, n, burst_time); 

//        for (int i = 0; i < num; i++) { 
//            send = send + ";" +String.valueOf(mat[i][0]);
//            send = send + ";" +String.valueOf(mat[i][1]);
//            send = send + ";" +String.valueOf(mat[i][2]);
//            send = send + ";" +String.valueOf(mat[i][4]);
//            send = send + ";" +String.valueOf(mat[i][5]);
////             mat[i][0], mat[i][1], mat[i][2], mat[i][4], mat[i][5]); 
//        } 
        return send;
    } 
  
    // Driver code  
//    public static void main(String[] args) throws ParseException { 
//        //process id's  
//        int processes[] = {1, 2, 3}; 
//        int n = processes.length; 
//  
//        //Burst time of all processes  
//        int burst_time[] = {10, 5, 8}; 
//  
//        findavgTime(processes, n, burst_time); 
//  
//    } 
} 
// This code is contributed by 29ajaykumar  
