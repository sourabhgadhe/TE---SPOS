import java.util.*;
public class sjf_preemptive {
public static void main (String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter no of process: ");
    int n= sc.nextInt();
    int pid[] = new int[n]; // it takes pid of process
    int at[] = new int[n]; // at means arrival time
    int bt[] = new int[n]; // bt means burst time
    int ct[] = new int[n]; // ct means complete time
    int ta[] = new int[n];// ta means turn around time
    int wt[] = new int[n]; // wt means waiting time
    int f[] = new int[n]; // f means it is flag it checks process is completed or not
    int copy_bt[]= new int[n]; // it is also stores burst time
    int st=0, tot=0;
    float avgwt=0, avgta=0;

    for (int i=0;i<n;i++)
    {
        pid[i]= i+1;
        System.out.println("Enter process " + (i+1) + " arrival time: ");
        at[i]= sc.nextInt();
        System.out.println("Enter process " + (i+1) + " burst time: ");
        bt[i]= sc.nextInt();
        copy_bt[i]= bt[i];
        f[i]= 0;
    }
 
    while(true)
    {
        int min=99,c=n;
        if (tot==n)
            break;
 
        for (int i=0;i<n;i++)
        {
            if ((at[i]<=st) && (f[i]==0) && (bt[i]<min))
            {
                min=bt[i];
                c=i;
            }
        }
 
        if (c==n)
            st++;
        else
        {
            bt[c]--;
            st++;
            if (bt[c]==0)
            {
                ct[c]= st;
                f[c]=1;
                tot++;
            }
        }
    }
 
 for(int i=0;i<n;i++)
 {
    ta[i] = ct[i] - at[i];
    wt[i] = ta[i] - copy_bt[i];
    avgwt+= wt[i];
    avgta+= ta[i];
 }
 System.out.println("\n ------ SJF (Preemptive) ------ \n");
 
System.out.println("==========================================================================================");
 System.out.println("\nProcess\t\tArrivalT\tBurstT\t\tCompleteT\tTurnT\t\tWaitingT");
 
System.out.println("==========================================================================================");

 for(int i=0;i<n;i++)
 {
    System.out.println(pid[i] +"\t\t"+ at[i]+"\t\t"+ copy_bt[i] +"\t\t"+ ct[i] +"\t\t"+ ta[i] +"\t\t"+ wt[i]);
 }
 
 System.out.println("\nAverage waiting time: "+ (avgwt/n)); 
 System.out.println("Average turnaround time:"+(avgta/n)); 
 sc.close();
}
}