import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter No. of blocks: ");
        int m=sc.nextInt();
        int block[]= new int[m];
        System.out.print("Enter the Block Array: ");
        for(int i=0;i<m;i++){
            block[i]=sc.nextInt();
        }
        System.out.print("Enter No. of processes: ");
        int n=sc.nextInt();
        int process[]= new int[n];
        System.out.print("Enter the Process Array: ");
        for(int i=0;i<n;i++){
            process[i]=sc.nextInt();
        }
        int allocation[]=new int[n];
        for(int i=0;i<n;i++){
            allocation[i]=-1;
        }


        for(int i=0;i<n;i++)
        {
            int index=-1;
            for(int j=0;j<m;j++)
            {
                if(block[j]>=process[i])
                {
                    if(index==-1)
                    {
                        index=j;
                    }
                    else if(block[index]>block[j])
                    {
                        index=j;
                    }
                }
            }

            if(index!=-1)
            {
                allocation[i]=index;
                block[index]-=process[i];
            }
        }
       
        System.out.println("Process No \t Process Size \t Block No");
        for(int i=0;i<n;i++){
            System.out.print("   " + (i+1)+ "\t\t    " + process[i]);
            if(allocation[i]!=-1){
                System.out.print("\t\t   " + (allocation[i]+1));
            }
            else{
                System.out.print("\t\t Not Allocated");
            }
            System.out.println();
        }
    }
}

