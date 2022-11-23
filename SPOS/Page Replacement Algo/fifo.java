import java.util.*;

public class fifo
{
    public static int n,fs,pageHit=0,pageFault=0,front=0;
    public static int frame[],refPage[];
    
    public  static void fifo()
    {
        for(int i=0;i<n;i++)
        {
            boolean isFull = false;

            for(int j=0;j<fs;j++)
            {
                if(frame[j]==-1)
                {
                    frame[j]=refPage[i];
                    pageFault++;
                    break;
                }

                else if(refPage[i]==frame[j])
                {
                    pageHit++;
                    break;
                }

                if(j==(fs-1))
                    isFull=true;
            }

            if(isFull)
            {
                frame[front]=refPage[i];
                front++;
                pageFault++;
                if(front==fs)
                    front=0;

            }

            display();
        }

        System.out.println("\nPage Hit: "+pageHit);
        System.out.println("\nPage Fault: "+pageFault);
    }


    public static void display()
    {
        System.out.println("\nFrame Content: ");
        for(int i=0;i<fs;i++)
        {
            System.out.println(frame[i]);
        }
    }


    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter total no. of pages: ");
        n = sc.nextInt();

        System.out.println("\nEnter pages: ");
        refPage = new int[n];
        for(int i=0;i<n;i++)
        {
            refPage[i]=sc.nextInt();
        }

        System.out.print("\nEnter frame size: ");
        fs = sc.nextInt(); 
        frame = new int[fs];
        for(int i=0;i<fs;i++)
        {
            frame[i]=-1;
        }

        fifo();
    }
}