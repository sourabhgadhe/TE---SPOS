import java.util.Scanner;  
public class RoundRobin  
{  
public static void main(String args[])  
{  
int time_qtm,temp,sq=0,i=0,count=0;  
float awt=0,atat=0;  
int[] bt = new int[10];  
int[] wt = new int[10];  
int[] tat = new int[10];  
int[] copy_bt = new int[10];  
Scanner sc=new Scanner(System.in);  
System.out.print("Enter the number of process: ");  
int n = sc.nextInt();  
System.out.print("Enter the burst time of the process:\n");  

for (i=0;i<n;i++)  
{   
    System.out.print("P"+i+" = ");   
    bt[i] = sc.nextInt();  
    copy_bt[i] = bt[i];  
}  

System.out.print("Enter the quantum time: ");  
time_qtm = sc.nextInt();  

while(true)  
{
    if(count == n)  
        break;

    for (i=0,count=0;i<n;i++)  
    {  
        temp = time_qtm;  
        
        if(copy_bt[i] == 0)  
        {  
            count++;  
            continue;  
        }  
        
        if(copy_bt[i]>time_qtm)  
            copy_bt[i]= copy_bt[i] - time_qtm; 

        if(copy_bt[i]>=0)  
        {  
            temp = copy_bt[i];  
            copy_bt[i] = 0;  
        }  
        
        sq = sq + temp;  
        tat[i] = sq;  
    }  

      
}  

System.out.print("--------------------------------------------------------------------------------");  
System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");  
System.out.print("--------------------------------------------------------------------------------");  

for(i=0;i<n;i++)  
{  
    wt[i]=tat[i]-bt[i];  
    awt=awt+wt[i];  
    atat=atat+tat[i];  
    System.out.print("\n "+(i+1)+"\t\t "+bt[i]+"\t\t\t "+tat[i]+"\t\t\t\t "+wt[i]+"\n");  
}  

awt=awt/n;  
atat=atat/n;  
System.out.println("\nAverage waiting Time = "+awt+"\n");  
System.out.println("Average turnaround time = "+atat);  
}  
} 