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
// Java program to implement Shortest Job first with Arrival Time 
import java.util.*; 
  
public class Sjf { 
  
    static int[][] mat = new int[10][6]; 
  
    static void arrangeArrival(int num, int[][] mat) { 
        for (int i = 0; i < num; i++) { 
            for (int j = 0; j < num - i - 1; j++) { 
                if (mat[j][1] > mat[j + 1][1]) { 
                    for (int k = 0; k < 5; k++) { 
                        int temp = mat[j][k]; 
                        mat[j][k] = mat[j + 1][k]; 
                        mat[j + 1][k] = temp; 
                    } 
                } 
            } 
        } 
    } 
  
    static void completionTime(int num, int[][] mat) { 
        int temp, val = -1; 
        mat[0][3] = mat[0][1] + mat[0][2]; 
        mat[0][5] = mat[0][3] - mat[0][1]; 
        mat[0][4] = mat[0][5] - mat[0][2]; 
  
        for (int i = 1; i < num; i++) { 
            temp = mat[i - 1][3]; 
            int low = mat[i][2]; 
            for (int j = i; j < num; j++) { 
                if (temp >= mat[j][1] && low >= mat[j][2]) { 
                    low = mat[j][2]; 
                    val = j; 
                } 
            } 
            mat[val][3] = temp + mat[val][2]; 
            mat[val][5] = mat[val][3] - mat[val][1]; 
            mat[val][4] = mat[val][5] - mat[val][2]; 
            for (int k = 0; k < 6; k++) { 
                int tem = mat[val][k]; 
                mat[val][k] = mat[i][k]; 
                mat[i][k] = tem; 
            } 
        } 
    } 
  
    // Driver Code 
   public String schSjf( String[] words) { 
       
        int num = Integer.valueOf(words[1]);
        String send = "1;"+num;
        int count = 2; 
        for (int i = 0; i < num; i++) { 

            mat[i][0] = Integer.valueOf(words[count]);count++; 

            mat[i][1] = Integer.valueOf(words[count]);count++; 

            mat[i][2] = Integer.valueOf(words[count]);count++; 
        } 
        count = 2;
  
  
        arrangeArrival(num, mat); 
        completionTime(num, mat); 

        for (int i = 0; i < num; i++) { 
            send = send + ";" +String.valueOf(mat[i][0]);
            send = send + ";" +String.valueOf(mat[i][1]);
            send = send + ";" +String.valueOf(mat[i][2]);
            send = send + ";" +String.valueOf(mat[i][4]);
            send = send + ";" +String.valueOf(mat[i][5]);
//             mat[i][0], mat[i][1], mat[i][2], mat[i][4], mat[i][5]); 
        } 
        System.out.print(send);
        return send;
    } 
   public String input()
    {
        String line = "";

        int num; 
        
        String[][] matt = new String[10][6]; 
        
        Scanner sc = new Scanner(System.in); 
  
        System.out.println("Enter number of Process: "); 
        num = sc.nextInt(); 
        line += num;

        
  
        System.out.println("...Enter the process ID..."); 
        for (int i = 0; i < num; i++) { 
            System.out.println("...Process " + (i + 1) + "..."); 
            System.out.println("Enter Process Id: "); 
            matt[i][0] = sc.nextLine();
            matt[i][0] = sc.nextLine(); 
            System.out.println("Enter Arrival Time: "); 
            matt[i][1] = sc.nextLine(); 
            System.out.println("Enter Burst Time: "); 
            matt[i][2] = sc.nextLine(); 
            line = ((line.concat(";"+matt[i][0])).concat(";"+matt[i][1])).concat(";"+matt[i][2]);
        } 
       return line;
    }
} 
  
// This code is contributed by 
// sanjeev2552 
