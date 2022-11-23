import java.util.*;

public class test
{
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter total no. of processes: ");
        int n = sc.nextInt();

        String task_id[] = new String[n];
        int arrival_time[] = new int[n];
        int burst_time[] = new int[n];
        int schedule_time[] = new int[n];
        int turnaround_time[] = new int[n];
        int waiting_time[] = new int[n];
    
        
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter task_id: ");
            task_id[i] = sc.next();

            System.out.print("Enter arrival_time: ");
            arrival_time[i] = sc.nextInt();

            System.out.print("Enter burst_time: ");
            burst_time[i] = sc.nextInt();


        }

        String temp1;
        int temp;

        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(arrival_time[i]>arrival_time[j])
                {
                    temp=arrival_time[j];
                    arrival_time[j]=arrival_time[i];
                    arrival_time[i]=temp;

                    temp=burst_time[j];
                    burst_time[j]=burst_time[i];
                    burst_time[i]=temp;

    
                    temp1=task_id[j];
                    task_id[j]=task_id[i];
                    task_id[i]=temp1;
                }
            }
        }

        int j=0,k=0;

        for(int i=0;i<n;i++)
        {
            j=burst_time[i];
            schedule_time[i]=k;
            k=k+j;

            waiting_time[i] = schedule_time[i] - arrival_time[i];
            turnaround_time[i] = waiting_time[i] + burst_time[i];
        }

        float avg_wt=0,avg_tt=0;

        System.out.println("Process Details after fcfs scheduling\n");
		for(int i=0;i<n;i++)
		{
			System.out.println(task_id[i]+"\t"+arrival_time[i]+"\t"+burst_time[i]+"\t"+schedule_time[i]+"\t"+waiting_time[i]+"\t"+turnaround_time[i]);

            avg_wt += waiting_time[i];
            avg_tt += turnaround_time[i];
		}


        System.out.println("\n Avg WT : "+ (avg_wt/n));
        System.out.println("\n Avg WT : "+ (avg_tt/n));
    }
}