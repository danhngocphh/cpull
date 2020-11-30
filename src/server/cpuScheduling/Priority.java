/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.cpuScheduling;

import java.util.Scanner;
import static server.cpuScheduling.Sjf.mat;
 
public class Priority{
         
     public String schPriotity( String[] words) {
            int num = Integer.valueOf(words[1]);
            String send = "2;"+num;
           
 
            int x,n,p[],pp[],bt[],w[],t[],awt,atat,i;
 
            p = new int[10];
            pp = new int[10];
            bt = new int[10];
            w = new int[10];
            t = new int[10];
 
   //n is number of process
   //p is process
   //pp is process priority
   //bt is process burst time
   //w is wait time
   // t is turnaround time
   //awt is average waiting time
   //atat is average turnaround time
 
 
//   System.out.print("Enter the number of process : ");
   n = num;
   int count = 2;
//    System.out.print("\n\t Enter burst time : time priorities \n");
 
   for(i=0;i<n;i++)
    {
//       System.out.print("\nProcess["+(i+1)+"]:");\
      p[i] = Integer.valueOf(words[count]);count++;
      bt[i] = Integer.valueOf(words[count]);count++;
      pp[i] = Integer.valueOf(words[count]);count++;
     
    }
 
//sorting on the basis of priority
  for(i=0;i<n-1;i++)
   {
     for(int j=i+1;j<n;j++)
     {
       if(pp[i]>pp[j])
       {
     x=pp[i];
     pp[i]=pp[j];
     pp[j]=x;
     x=bt[i];
     bt[i]=bt[j];
     bt[j]=x;
     x=p[i];
     p[i]=p[j];
     p[j]=x;
      }
   }
}
w[0]=0;
awt=0;
t[0]=bt[0];
atat=t[0];
for(i=1;i<n;i++)
 {
   w[i]=t[i-1];
   awt+=w[i];
   t[i]=w[i]+bt[i];
   atat+=t[i];
 }
 
//Displaying the process
 
//  System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
for(i=0;i<n;i++)
{
            send = send + ";" +String.valueOf(p[i]);
            send = send + ";" +String.valueOf(bt[i]);
            send = send + ";" +String.valueOf(w[i]);
            send = send + ";" +String.valueOf(t[i]);
            send = send + ";" +String.valueOf(pp[i]);
    
}
 
awt/=n;
atat/=n;

            send = send + ";" +String.valueOf(awt);
            send = send + ";" +String.valueOf(atat);
//  System.out.print("\n Average Wait Time : "+awt);
//  System.out.print("\n Average Turn Around Time : "+atat);
  
  return send;
 
        }
}

