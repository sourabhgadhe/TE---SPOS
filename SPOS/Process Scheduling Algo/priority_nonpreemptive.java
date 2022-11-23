import java.util.*;

public class priority
{
	public static void main(String[] args)
	{
		int n,temp;
		String temp1;

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter total no. of processes: ");
		n = sc.nextInt();

		String[] task_id = new String[n];
		int[] arrival_time = new int[n];
		int[] burst_time = new int[n];
		int[] scheduled_time = new int[n];
		int[] total_time = new int[n];
		int[] waiting_time = new int[n];
		int[] priority = new int[n];

		for(int i=0;i<n;i++)
		{
			System.out.print("\nEnter task_id: ");
			task_id[i] = sc.next();

			System.out.print("Enter arrival_time: ");
			arrival_time[i] = sc.nextInt();

			System.out.print("Enter burst_time: ");
			burst_time[i] = sc.nextInt();

			System.out.print("Enter priority: ");
			priority[i] = sc.nextInt();
		}
		
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(priority[i] > priority[j])
				{
					temp1 = task_id[j];
					task_id[j] = task_id[i];
					task_id[i] = temp1;

					temp = arrival_time[j];
					arrival_time[j] = arrival_time[i];
					arrival_time[i] = temp;

					temp = burst_time[j];
					burst_time[j] = burst_time[i];
					burst_time[i] = temp;

					temp = priority[j];
					priority[j] = priority[i];
					priority[i] = temp;
				}
			}
		}

		int j=0, k=0;

		for(int i=0;i<n;i++)
		{
			j = burst_time[i];
			scheduled_time[i] = k;
			k = k+j;

			waiting_time[i] = scheduled_time[i] - arrival_time[i]; 
			total_time[i] = waiting_time[i] + burst_time[i];
		}

		System.out.println("Process\t"+"\tArrival Time\t"+"Burst Time\t"+"Waiting Time\t"+"Scheduled Time\t"+"Total Time");

		for(int i=0; i<n;i++)
		{
			System.out.println(task_id[i]+"\t\t"+arrival_time[i]+"\t\t"+burst_time[i]+"\t\t"+waiting_time[i]+"\t\t"+
			scheduled_time[i]+"\t\t"+total_time[i]);
		}
	}
}