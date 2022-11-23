import java.util.*;
public class first_fit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter total no. of blocks: ");
        int m = sc.nextInt();
        int block[] = new int[m];
        System.out.print("\nEnter block array: ");
        for(int i=0;i<m;i++)
        {
            block[i] = sc.nextInt();
        }

        System.out.print("\nEnter total no. of processes: ");
        int n = sc.nextInt();
        int process[] = new int[n];  
        System.out.println("\nEnter process array: ");
        for(int i=0;i<n;i++)
        {
            process[i] = sc.nextInt();
        }

        int allocation[] = new int[n];
        for (int i=0;i<n;i++)
        {
            allocation[i] = -1;
        }

        for(int i =0;i<n;i++)
        {
            for(int j=0; j<m; j++)
            {
                if(block[j] >= process[i])
                {
                    allocation[i] = j;
                    block[j] -= process[i];
                    break;
                }
            }
        }

        System.out.println("\nProcess No." + "\t\tProcess Size"  + "\t\tAllocated Block No.");
        for(int i=0;i<n;i++)
        {
            System.out.print((i+1) + "\t\t\t\t" + process[i]);
            if(allocation[i] != -1)
            {
                System.out.println("\t\t\t" + (allocation[i]+1));
            }
            else
            {
                System.out.println("\t\tNot Allocated");
            }
        }
        
    }
}